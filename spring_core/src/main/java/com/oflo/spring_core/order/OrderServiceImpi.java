package com.oflo.spring_core.order;

import com.oflo.spring_core.discount.DiscountPolicy;
import com.oflo.spring_core.discount.FixDiscountPolicy;
import com.oflo.spring_core.member.Member;
import com.oflo.spring_core.member.MemberRepository;
import com.oflo.spring_core.member.MemoryMemberRepository;

public class OrderServiceImpi implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}

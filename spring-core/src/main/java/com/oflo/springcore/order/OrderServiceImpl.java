package com.oflo.springcore.order;

import com.oflo.springcore.discount.DiscountPolicy;
import com.oflo.springcore.discount.FixDiscountPolicy;
import com.oflo.springcore.member.Member;
import com.oflo.springcore.member.MemberRepository;
import com.oflo.springcore.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);


        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}

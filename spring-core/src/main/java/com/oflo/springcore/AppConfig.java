package com.oflo.springcore;

import com.oflo.springcore.discount.DiscountPolicy;
import com.oflo.springcore.discount.FixDiscountPolicy;
import com.oflo.springcore.member.MemberRepository;
import com.oflo.springcore.member.MemberService;
import com.oflo.springcore.member.MemberServiceImpl;
import com.oflo.springcore.member.MemoryMemberRepository;
import com.oflo.springcore.order.OrderService;
import com.oflo.springcore.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    };

    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
}

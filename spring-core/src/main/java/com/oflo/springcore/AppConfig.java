package com.oflo.springcore;

import com.oflo.springcore.discount.FixDiscountPolicy;
import com.oflo.springcore.member.MemberService;
import com.oflo.springcore.member.MemberServiceImpl;
import com.oflo.springcore.member.MemoryMemberRepository;
import com.oflo.springcore.order.OrderService;
import com.oflo.springcore.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    };

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}

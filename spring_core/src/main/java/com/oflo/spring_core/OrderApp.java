package com.oflo.spring_core;

import com.oflo.spring_core.member.Grade;
import com.oflo.spring_core.member.Member;
import com.oflo.spring_core.member.MemberService;
import com.oflo.spring_core.member.MemberServiceImpl;
import com.oflo.spring_core.order.Order;
import com.oflo.spring_core.order.OrderService;
import com.oflo.spring_core.order.OrderServiceImpi;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpi();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = "+ order);
    }
}

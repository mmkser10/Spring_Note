package com.oflo.springcore;

import com.oflo.springcore.member.Grade;
import com.oflo.springcore.member.Member;
import com.oflo.springcore.member.MemberService;
import com.oflo.springcore.member.MemberServiceImpl;
import com.oflo.springcore.order.Order;
import com.oflo.springcore.order.OrderService;
import com.oflo.springcore.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);

    }
}

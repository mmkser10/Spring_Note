package com.oflo.spring_core;

import com.oflo.spring_core.member.Grade;
import com.oflo.spring_core.member.Member;
import com.oflo.spring_core.member.MemberService;
import com.oflo.spring_core.member.MemberServiceImpl;
import com.oflo.spring_core.order.Order;
import com.oflo.spring_core.order.OrderService;
import com.oflo.spring_core.order.OrderServiceImpi;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = "+ order);
    }
}

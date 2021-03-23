package com.oflo.spring_core;

import com.oflo.spring_core.discount.DiscountPolicy;
import com.oflo.spring_core.discount.FixDiscountPolicy;
import com.oflo.spring_core.discount.RateDiscountPolicy;
import com.oflo.spring_core.member.MemberRepository;
import com.oflo.spring_core.member.MemberService;
import com.oflo.spring_core.member.MemberServiceImpl;
import com.oflo.spring_core.member.MemoryMemberRepository;
import com.oflo.spring_core.order.OrderService;
import com.oflo.spring_core.order.OrderServiceImpi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 설정정보
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpi(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy()
        return new RateDiscountPolicy();
    }
}

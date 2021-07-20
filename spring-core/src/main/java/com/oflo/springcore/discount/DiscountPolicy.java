package com.oflo.springcore.discount;

import com.oflo.springcore.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);


}

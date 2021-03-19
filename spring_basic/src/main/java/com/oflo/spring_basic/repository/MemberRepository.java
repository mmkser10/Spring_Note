package com.oflo.spring_basic.repository;

import com.oflo.spring_basic.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name); //null return시 Optional에 포암해서 하는 경향
    List<Member> findAll();

}

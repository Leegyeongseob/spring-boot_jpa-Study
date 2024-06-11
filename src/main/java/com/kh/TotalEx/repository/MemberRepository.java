package com.kh.TotalEx.repository;

import com.kh.TotalEx.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
    Optional<Member> findByEmailAndPwd(String email,String pwd);
    boolean existsByEmail(String email);

}

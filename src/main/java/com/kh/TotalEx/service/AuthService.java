package com.kh.TotalEx.service;


import com.kh.TotalEx.dto.MemberReqDto;
import com.kh.TotalEx.dto.MemberResDto;
import com.kh.TotalEx.dto.TokenDto;
import com.kh.TotalEx.entity.Member;
import com.kh.TotalEx.jwt.TokenProvider;
import com.kh.TotalEx.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class AuthService {
    private final AuthenticationManagerBuilder managerBuilder;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    //회원가입
    public MemberResDto signup(MemberReqDto requestDto) {
        if (memberRepository.existsByEmail(requestDto.getEmail())) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다");
        }
        Member member = requestDto.toMember(passwordEncoder);
        return MemberResDto.of(memberRepository.save(member));
    }

    //로그인
    public TokenDto login(MemberReqDto requestDto) {
        UsernamePasswordAuthenticationToken authenticationToken = requestDto.toAuthentication();

        Authentication authentication = managerBuilder.getObject().authenticate(authenticationToken);

        return tokenProvider.generateTokenDto(authentication);
    }
    // 회원 전체 조회
    public List<MemberResDto> getMemberList() {
        List<Member> members = memberRepository.findAll();
        List<MemberResDto> memberDtos = new ArrayList<>();
        for(Member member : members) {
            memberDtos.add(convertEntityToDto(member));
        }
        return memberDtos;
    }
    // 회원 엔티티를 회원 DTO로 변환
    private MemberResDto convertEntityToDto(Member member) {
        return MemberResDto.builder().email(member.getEmail())
                .name(member.getName())
                .regData(member.getRegDate())
                .image(member.getImage())
                .build();
    }
}

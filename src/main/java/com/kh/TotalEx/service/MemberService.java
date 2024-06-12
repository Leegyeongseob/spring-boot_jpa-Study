package com.kh.TotalEx.service;

import com.kh.TotalEx.dto.MemberResDto;
import com.kh.TotalEx.entity.Member;
import com.kh.TotalEx.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
@Slf4j
@RequiredArgsConstructor
@Transactional

public class MemberService {
    private final MemberRepository memberRepository;
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

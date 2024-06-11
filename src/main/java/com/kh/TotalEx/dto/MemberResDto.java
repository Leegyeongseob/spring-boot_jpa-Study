package com.kh.TotalEx.dto;

import com.kh.TotalEx.entity.Member;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberResDto {
    private String name;
    private String email;
    private String image;
    private LocalDateTime regData;

    public static MemberResDto of(Member memeber){
        return MemberResDto.builder()
                .name(memeber.getName())
                .email(memeber.getEmail())
                .image(memeber.getImage())
                .regData(memeber.getRegDate())
                .build();
    }
}

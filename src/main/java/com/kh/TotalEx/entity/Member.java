package com.kh.TotalEx.entity;
import com.kh.TotalEx.constant.Authority;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Member {
    @Id
    @Column(name="member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String pwd;

    @Column(unique = true)
    private String email;

    private String image;
    private LocalDateTime regDate;

    @Enumerated(EnumType.STRING)
    private Authority authority;
}

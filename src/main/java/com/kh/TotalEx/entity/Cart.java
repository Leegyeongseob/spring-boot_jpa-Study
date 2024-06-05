package com.kh.TotalEx.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Cart {
    @Id
    @Column(name="cart_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cardName; //card_name

    @OneToOne
    @JoinColumn(name="member_id")
    private Member member;
}

package com.kh.TotalEx.entity;


import com.kh.TotalEx.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity //JPA Entity 클래스임을 지정, Entity 클래스는 반드시 기본키를 가져야 함.

public class Item {
    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id; //상품코드
    @Column(nullable = false, length = 50)
    private String itemNum; //상품명
    @Column(nullable = false)
    private int price; //가격
    @Column(nullable = false)
    private int stockNumber; //재고 수량
    @Lob //엄청 큰 문자열(2의 10승을 넘어가는 문자열)
    @Column(nullable = false)
    private String itemDetail; // 상품 상세 설명
    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus; //상품 상세 설명
    private LocalDateTime regTime; // 등록 시간
    private LocalDateTime updateTime; // 수정 시간

}

package com.kh.TotalEx.entity;


import com.kh.TotalEx.constant.OrderStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
@Getter
@Setter
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private LocalDateTime regTime;
    private LocalDateTime updateTime;

    // 내가 주인이 아니에용!~! 영속성 전이
    @OneToMany(mappedBy="order",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<OrderItem> orderItemList = new ArrayList<>();
}

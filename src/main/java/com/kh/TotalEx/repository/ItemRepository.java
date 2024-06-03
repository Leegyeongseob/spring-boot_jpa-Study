package com.kh.TotalEx.repository;

import com.kh.TotalEx.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {

}

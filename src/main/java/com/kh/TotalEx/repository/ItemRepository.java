package com.kh.TotalEx.repository;

import com.kh.TotalEx.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ItemRepository extends JpaRepository<Item,Long> {
    List<Item> findByItemNum(String itemNum);
    List<Item> findByItemNumOrItemDetail(String itemNum, String itemDetail);
    List<Item> findByPriceLessThan(Integer price);
    List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);
    //JPQL 검색
    @Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")
    List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);
    // nativeQuery 검색
    @Query(value="select * from Item i where i.item_detail like %:itemDetail% order by i.price desc", nativeQuery= true)
    List<Item> findByItemDetailByNative(@Param("itemDetail") String detail);

}

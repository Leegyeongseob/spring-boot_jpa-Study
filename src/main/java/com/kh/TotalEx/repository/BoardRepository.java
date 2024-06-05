package com.kh.TotalEx.repository;

import com.kh.TotalEx.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {
    
}

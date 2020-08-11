package com.example.repository;

import com.example.entity.ExcelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: xiuchong
 * @Date: 2020/8/10 15:08
 * @Description:
 */
public interface ExcelEntityRepository extends JpaRepository<ExcelEntity,Integer> {
}

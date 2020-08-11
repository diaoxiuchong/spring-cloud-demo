package com.example.service;

import com.example.entity.ExcelEntity;
import com.example.repository.ExcelEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: xiuchong
 * @Date: 2020/8/10 17:58
 * @Description:
 */
@Service
public class ExcelEntityService {

    @Autowired
    private ExcelEntityRepository excelEntityRepository;


    public void doSomething(ExcelEntity excel) {
        ExcelEntity save = excelEntityRepository.save(excel);
        System.out.println(save);

    }
}

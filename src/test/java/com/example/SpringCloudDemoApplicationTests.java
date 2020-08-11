package com.example;

import com.example.common.ExcelUtils;
import com.example.entity.ExcelEntity;
import com.example.repository.ExcelEntityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@SpringBootTest
public class SpringCloudDemoApplicationTests {

    @Autowired
    private ExcelEntityRepository excelEntityRepository;

    @Test
    public void doSomething() {

        FileInputStream fis = null;
        try {
            fis = new FileInputStream("D:\\2007.xlsx");
            Boolean flag = ExcelUtils.readExcel(fis, ExcelEntity.class, excelEntityRepository);

            System.out.println("导入是否成功："+flag);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

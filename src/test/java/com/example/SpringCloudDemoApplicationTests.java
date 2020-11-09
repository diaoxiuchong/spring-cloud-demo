package com.example;

import com.example.common.CardUtil;
import com.example.common.ExcelUtils;
import com.example.entity.ExcelEntity;
import com.example.repository.ExcelEntityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

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

    @Test
    public void Test2() {
        Map<String, String> carInfo = CardUtil.getBirAgeSex("372928199511085213");
        String sex = carInfo.get("sexCode");
        System.out.println(sex);
        String age = carInfo.get("age");
        System.out.println(age);
        String birthday = carInfo.get("birthday");
        System.out.println(birthday);
    }
}

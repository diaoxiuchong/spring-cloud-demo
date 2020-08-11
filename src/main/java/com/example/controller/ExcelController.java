package com.example.controller;

import com.example.common.ExcelUtils;
import com.example.repository.ExcelEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class ExcelController {

    @Autowired
    private ExcelUtils excelUtils;
    @Autowired
    private ExcelEntityRepository excelEntityRepository;

    /**
     * excel导入
     * @param file
     * @return
     * @throws IOException
     */
    @GetMapping("/inputExcel")
    public String inputExcel(@RequestParam("file") MultipartFile file) throws IOException {

        InputStream inputStream = file.getInputStream();
        excelUtils.readExcelPortal(inputStream,excelEntityRepository);

        return "上传成功";
    }

    /**
     * excel导出
     * @param response
     * @return
     */
    @GetMapping("/outputExcel")
    public String outputExcel(HttpServletResponse response) {

        excelUtils.writeExcelPortal(response,excelEntityRepository);

        return "导出成功";
    }
}

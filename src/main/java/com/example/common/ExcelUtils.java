package com.example.common;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.example.entity.ExcelEntity;
import com.example.repository.ExcelEntityRepository;
import org.springframework.stereotype.Component;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ExcelUtils {

    /**
     * 读Excel入口
     */
    public void readExcelPortal(InputStream fis, ExcelEntityRepository excelEntityRepository) {
        //1.读Excel
        //FileInputStream fis = null;
        try {
            //fis = new FileInputStream("D:\\2007.xlsx");
            Boolean flag = ExcelUtils.readExcel(fis, ExcelEntity.class, excelEntityRepository);
            System.out.println("导入是否成功：" + flag);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    /**
     * 导出Excel入口
     */
    public void writeExcelPortal(HttpServletResponse response,ExcelEntityRepository excelEntityRepository) {
        //FileOutputStream fos = null;
        ServletOutputStream outputStream = null;
        try {
            //fos = new FileOutputStream("D:\\export.xlsx");
            outputStream = response.getOutputStream();
            //添加响应头信息
            response.setHeader("Content-disposition", "attachment; filename=" + "export.xlsx");
            response.setContentType("application/msexcel;charset=UTF-8");//设置类型
            response.setHeader("Pragma", "No-cache");//设置头
            response.setHeader("Cache-Control", "no-cache");//设置头
            response.setDateHeader("Expires", 0);//设置日期头

            List<ExcelEntity> list = excelEntityRepository.findAll();

            Boolean flag = ExcelUtils.writeExcel(outputStream, ExcelEntity.class, list);
            System.out.println("导出是否成功：" + flag);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @param is    导入文件输入流
     * @param clazz Excel实体映射类
     * @return
     */
    public static Boolean readExcel(InputStream is, Class clazz, ExcelEntityRepository excelEntityRepository) {

        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(is);
            // 解析每行结果在listener中处理
            AnalysisEventListener listener = new ExcelListener(excelEntityRepository);
            ExcelReader excelReader = EasyExcelFactory.getReader(bis, listener);
            excelReader.read(new Sheet(1, 1, clazz));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    /**
     * @param os    文件输出流
     * @param clazz Excel实体映射类
     * @param data  导出数据
     * @return
     */
    public static Boolean writeExcel(OutputStream os, Class clazz, List<ExcelEntity> data) {
        BufferedOutputStream bos = null;
        try {
            bos = new BufferedOutputStream(os);
            ExcelWriter writer = new ExcelWriter(bos, ExcelTypeEnum.XLSX);
            //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
            Sheet sheet1 = new Sheet(1, 0, clazz);
            sheet1.setSheetName("目录");
            writer.write(data, sheet1);
            writer.finish();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
package com.wfit.dachuang.controller;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

@Controller
@Configuration
@RequestMapping("/")
public class TestController {
    private static Logger logger=Logger.getLogger(TestController.class);
    @Value(value = "${test.message}")
    public String name;
    @RequestMapping("/test")
    @ResponseBody
    public String test(Model model){
        logger.error("error 信息");
        logger.debug("debug 信息");
        logger.info("info 信息");
        logger.info(name);
        return "";
    }
    @RequestMapping("/exportExcel")
    public void exportExcel(HttpServletResponse response) {
        //创建HSSFWorkbook对象
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建HSSFSheet对象
        HSSFSheet sheet = wb.createSheet("sheet0");
        //创建HSSFRow对象
        HSSFRow row = sheet.createRow(0);
        //创建HSSFCell对象
        HSSFCell cell = row.createCell(0);
        //设置单元格的值
        cell.setCellValue("单元格");
        //发送到客户端的响应的内容类型
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        try {
            OutputStream os = response.getOutputStream();
            //下载中文文件名的做法
//            String fileName = URLEncoder.encode("下载Excel", "UTF-8");
//            response.setHeader("Content-disposition","attachment;filename="+fileName+".xls");
            response.setHeader("Content-disposition", "attachment;filename=test.xls");
            wb.write(os);
            os.flush();
            os.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

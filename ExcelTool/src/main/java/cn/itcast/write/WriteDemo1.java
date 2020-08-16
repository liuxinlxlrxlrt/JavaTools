package cn.itcast.write;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteDemo1 {

    public static void main(String[] args) throws IOException {
        //创建工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        //创建工作表
        XSSFSheet sheet = workbook.createSheet("工作表一");
        //创建行
        XSSFRow row=sheet.createRow(0);
        //创建单元格
        row.createCell(0).setCellValue("传智播客");
        row.createCell(1).setCellValue("黑马程序员");
        row.createCell(2).setCellValue("博学谷");

        row=sheet.createRow(1);
        row.createCell(0).setCellValue("传智播客");
        row.createCell(1).setCellValue("黑马程序员");
        row.createCell(2).setCellValue("博学谷");

        //输出流
        FileOutputStream outputStream = new FileOutputStream("D:\\学习\\7_学习总结\\xmind总结\\excel文件\\heima.xlsx");
        workbook.write(outputStream);
        outputStream.flush();
        workbook.close();
        System.out.println("写入成功");
    }
}

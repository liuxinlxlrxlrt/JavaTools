package cn.itcast.read;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

/**
 * 普通for获取excel数据
 */
public class ReadDemo2 {
    public static void main(String[] args) throws IOException {
        //获取工作簿
        XSSFWorkbook workbook = new XSSFWorkbook("D:\\学习\\7_学习总结\\xmind总结\\excel文件\\hello.xlsx");
        //获取工作表
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        //普通for循坏
        //开始索引 0，获取结束索引
        int lastRowNum = sheet.getLastRowNum();
        for(int i=0;i<=lastRowNum;i++){
            XSSFRow row = sheet.getRow(i);
            if(row!=null){
                //获取最后一个单元格的索引
                int lastCellNum = row.getLastCellNum();
                for(int j =0;j<=lastCellNum;j++){
                    //获取单元格
                    XSSFCell cell = row.getCell(j);
                    if(cell!=null){
                        //获取单元格的值
                        String cellValue = cell.getStringCellValue();
                        System.out.println(cellValue);
                    }
                }
            }
        }
        //释放资源
        workbook.close();
    }
}

package cn.itcast.tools.ExcelTool;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * XSSFWorkbook增强for获取excel全部数据
 */
import java.io.IOException;

public class ReadExcelAllDataStrongForTest {
    public static void main(String[] args) throws IOException {
        //获取工作簿
        XSSFWorkbook workbook = new XSSFWorkbook("D:\\学习\\7_学习总结\\xmind总结\\excel文件\\hello.xlsx");
        //获取工作表
        XSSFSheet sheet = workbook.getSheetAt(0);
        //增强for循环
        //获取行
        for (Row row : sheet) {
            //获取单元格
            for (Cell cell : row) {
                //获取单元格中的内容
                String value = cell.getStringCellValue();
                System.out.println(value);
            }
        }
        //释放资源
        workbook.close();
    }

}

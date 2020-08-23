package cn.itcast.tools.ExcelTool;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelData {
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    int rows;
    int columns;
    public String fileName;
    public String sheetName;
    public Object Data[][];
    String sourcePath;

    /**
     * 带参构造方法初始化显示赋值给fileName，sheetName，
     * @param fileName
     * @param sheetName
     */
    public ExcelData(String fileName, String sheetName) {
        this.fileName = fileName;
        this.sheetName = sheetName;
    }

    /**
     * 获取excel文件的绝对路径
     * @return
     * @throws IOException
     */
    public String getSourcePath()throws IOException{
        //仅加一个点“.”，表示当前目录
        File directory = new File(".");
        //D:\javaCode\21_ProjectStorageFolder\TestNG\JavaTools\ExcelTool\src\main\resources
        //getCanonicalPath():获取绝对路径
        sourcePath = directory.getCanonicalPath()+"/src/main/resources/"+
                fileName;
        System.out.println("sourcePath："+sourcePath);
        return sourcePath;
    }

    public Object[][] getData() throws IOException{
        //获取excel文件字节输入流
        FileInputStream fileInputStream = new FileInputStream(getSourcePath());
        //获取excel工作簿对象
        workbook= new XSSFWorkbook(fileInputStream);
        //获取excel工作表对象
        sheet = workbook.getSheet(sheetName);
        //获取第一行，起始编号为0
        XSSFRow Row =sheet.getRow(0);
        if(sheet.equals(null)){
            System.out.println("sheet.equals(null),please check the sheet name~~~");
        }
        //Apache的POI时间格式化器DataFormatter
        DataFormatter formatter = new DataFormatter();
        //获取物理行数，不包括空行（隔行）的情况，编号从1开始
        rows = sheet.getPhysicalNumberOfRows();
        //获取最后一列的编号：编号从0开始
        columns= Row.getLastCellNum();
        //定义object的二维数组，有rows-1个以为数组，每个一位数组有columns个元素
        Data= new Object[rows-1][columns];

        //遍历行
        for(int i=0;i<rows-1;i++){
            //获取行，从第二行开始,第一行为标题，编号从1开始
            XSSFRow row = sheet.getRow(i+1);
            //遍历列
            for(int j=0;j<columns;j++){
                if(row==null) {
                    Data[i][j] = "";
                }else {
                    //获取列，编号从0开始
                    XSSFCell cell=row.getCell(j);
                    if(cell==null){
                        Data[i][j]="";
                    }else {
                        //以字符串的形式返货单元格的格式化值，而不考虑单元格类型，如果无法解析excel格式模式，则将使用默认格式格式化单元格值
                        //当传递Null或者空单元格时，此方法返回空字符串（""），将不计算公式类型单元格中的公式
                        String value = formatter.formatCellValue(cell);
                        //对比字符串的值忽略大小写
                        if(value.equalsIgnoreCase("null"))
                            value=null;
                        //格式化程序以字符串的实行获取所有值，即整数，浮点数所有类型的数据值
                        Data[i][j]=value;
                    }
                }
            }
        }
        return Data;
    }

}

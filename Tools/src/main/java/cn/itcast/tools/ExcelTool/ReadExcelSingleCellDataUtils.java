package cn.itcast.tools.ExcelTool;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class ReadExcelSingleCellDataUtils {

    //日期格式
    private static SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
    public String filePath;
    public String sheetName;

    public ReadExcelSingleCellDataUtils(String filePath, String sheetName) {
        super();
        this.filePath = filePath;
        this.sheetName = sheetName;
    }

    public static String readExcelCellData(String filePath, String sheetName, int rownum, int cellsnum) throws IOException {
        String cellValue = null;
        FileInputStream inputStream = null;
        XSSFWorkbook workbook = null;
        XSSFSheet sheet = null;

        try {
            inputStream = new FileInputStream(new File(filePath));
            workbook = new XSSFWorkbook(inputStream);
            sheet = workbook.getSheet(sheetName);
            XSSFRow xssfRow = sheet.getRow(rownum);
            Cell xssfCell = xssfRow.getCell(cellsnum);
            cellValue = ReadExcelSingleCellDataUtils.getCellValue(xssfCell);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (workbook != null || inputStream != null) {
                workbook.close();
                inputStream.close();
            }
        }
        return cellValue;
    }

    public static void writeDataToExcelOfSingleCell(String filePath, String sheetName, int rownum, int cellsnum, String string) throws IOException {
        FileOutputStream outputStream = null;
        XSSFWorkbook workbook = null;
        XSSFSheet sheet = null;

        try {
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet(sheetName);
            XSSFRow row = sheet.createRow(rownum);
            XSSFCell cell = row.createCell(cellsnum);
            cell.setCellValue(string);

            outputStream = new FileOutputStream(filePath);
            workbook.write(outputStream);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (workbook != null || outputStream != null) {
                workbook.close();
                outputStream.close();
            }
        }
    }

    /**
     * 用来指定读取指定单元格的内容函数
     *
     * @param cell
     * @return
     */
    private static String getCellValue(Cell cell) {
        String cellValue = "null";
        if (cell == null) {
            return cellValue;
        } else {
            try {
                int cellType = cell.getCellType();
                switch (cellType) {
                    case 0:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            cellValue = fmt.format(cell.getDateCellValue());
                        } else {
                            Double d = cell.getNumericCellValue();
                            DecimalFormat df = new DecimalFormat("#.##");
                            cellValue = df.format(d);
                        }
                        break;
                    case 1:
                        cellValue = cell.getStringCellValue();
                        break;
                    case 2:
                        cellValue = "错误";
                        break;
                    case 3:
                        cellValue = cell.getStringCellValue();
                        break;
                    case 4:
                        cellValue = String.valueOf(cell.getBooleanCellValue());
                        break;
                    case 5:
                        cellValue = "错误";
                        break;
                    default:
                        cellValue = "错误";
                }
            } catch (Exception var6) {
                var6.printStackTrace();
            }

            return cellValue;
        }
    }
}

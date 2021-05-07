package cn.itcast.tools.test;

import cn.itcast.tools.Entity.User;
import cn.itcast.tools.ExcelTool.ExcelData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class ExcelDataTest {
    @DataProvider(name = "excel")
    public Object[][] excel() throws IOException {
        ExcelData excelData = new ExcelData("data.xlsx", "Sheet1");
        return excelData.getData();
    }

    @Test(dataProvider = "excel")
    public void excelDataTest(String number, String name, String price, String store) throws IOException {
        User user = new User();
        user.setNumber(number);
        user.setName(name);
        user.setPrice(price);
        user.setStore(store);
        System.out.println("user" + user.toString());
    }
    @Test
    public void excelDataTest1() throws IOException {
        Object[][] objects = new ExcelData("login.xlsx", "Sheet1").getData();

        ;
        for (int i=0;i<objects.length;i++){
           for (int j = 0; j < objects[i].length; j++){
               System.out.print(objects[i][j]+"\n");
           }
        }
    }
}

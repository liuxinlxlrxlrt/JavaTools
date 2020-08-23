package cn.itcast.tools.test;

import cn.itcast.tools.Entity.User;
import cn.itcast.tools.testdata.DataProviderData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class DataProviderTest {
    @DataProvider(name = "testdata")
    public Object[][] testData() throws IOException {
        return new Object[][]{
                {"4", "许龄月", "28", "95"},
                {"5", "梁小冰", "29", "96"},
                {"6", "许晴", "39", "97"}
        };
    }


    @Test(dataProvider = "testdata")
    public void testdata(String number, String name, String price, String store) throws IOException {
        User user = new User();
        user.setNumber(number);
        user.setName(name);
        user.setPrice(price);
        user.setStore(store);
        System.out.println("user testdata" + user.toString());
    }

    @Test(dataProvider = "DataProviderData",dataProviderClass = DataProviderData.class)
    public void dataProviderData(String number, String name, String price, String store)throws IOException{
        User user = new User();
        user.setNumber(number);
        user.setName(name);
        user.setPrice(price);
        user.setStore(store);
        System.out.println("user data" + user.toString());
    }
}

package cn.itcast.tools.testdata;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviderData {
    @DataProvider(name = "DataProviderData")
    public Object[][] data() throws IOException {
        return new Object[][]{
                {"1", "江疏影", "25", "99"},
                {"2", "高圆圆", "26", "100"},
                {"3", "佟丽娅", "27", "101"}
        };
    }
}

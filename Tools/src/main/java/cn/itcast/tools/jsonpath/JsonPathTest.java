package cn.itcast.tools.jsonpath;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jayway.jsonpath.JsonPath;

import java.awt.print.Book;
import java.util.List;

public class JsonPathTest {
    public static void main(String[] args) {
//        JSONObject responseJson= JSON.parseObject(JsonString.jsonString);//调用自定义的jsonTest()方法获得json对象，生成上面的json
        //  获取json中store下book下的所有title值
        List<String> titless = JsonPath.read(JsonString.jsonString, "$.store.book[*].title");
        System.out.println("$.store.book.title \n " + titless);
        System.out.println();

        // 获取json中所有title的值
        List<String> title = JsonPath.read(JsonString.jsonString, "$..title");
        System.out.println("$..title \n" + title);
        System.out.println();

        // 获取json中book数组中包含isbn的所有值
        List<Book> isbn = JsonPath.read(JsonString.jsonString, "$.store.book[?(@.isbn)]");
        System.out.println("$.store.book[?(@.isbn)] \n" + isbn);
        System.out.println();
        // 获取json中book数组中不包含isbn的所有值
        isbn = JsonPath.read(JsonString.jsonString, "$.store.book[?(!@.isbn)]");
        System.out.println("$.store.book[?(!@.isbn)] \n" + isbn);
        System.out.println();


        // 获取json中book数组中price<10的所有值
        List<Double> prices = JsonPath.read(JsonString.jsonString, "$.store.book[?(@.price < 10)].price");
        System.out.println("$.store.book[?(@.price < 10)].price \n" + prices);
        System.out.println();

        // 获取json中book数组中的title等于“高效Java”的对象
        List<Book> titles = JsonPath.read(JsonString.jsonString, "$.store.book[?(@.title == 'The Lord of the Rings')]");
        System.out.println("$.store.book[?(@.title == 'The Lord of the Rings')] \n" + titles);
        System.out.println();

        // 获取json中store下所有price的值
        prices = JsonPath.read(JsonString.jsonString, "$..price");
        System.out.println("$..price \n" + prices);
        System.out.println();

        // 获取json中book数组的前两个区间值
        List<Book> book = JsonPath.read(JsonString.jsonString, "$.store.book[0:4]");
        System.out.println("$.store.book[2:4] \n" + book);
        System.out.println();
        // 获取书个数
        int size = JsonPath.read(JsonString.jsonString, "$.store.book.size()");
        System.out.println("$.store.book.size() \n" + size);
        System.out.println();

        // 获取store中bicycle的颜色
        List<String> color = JsonPath.read(JsonString.jsonString, "$.store..color");
        System.out.println("$.store..color \n" + color.get(0));
    }
}

package cn.itcast.tools.MapTool;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//traversal:遍历
public class TraversalMapUtils {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("熊大", "棕色");
        map.put("熊二", "黄色");
        map.put("光头强", "黄棕色");

        //方法一：在for循环中使用entries实现Map的遍历：最高效的
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("姓名：" + entry.getKey() + "，颜色：" + entry.getValue());
        }

        System.out.println("----------------------------");
        //方法二：在for循环中遍历key或者values，一般适用于只需要map中的key或者value时使用，
        // 在性能上比使用entrySet较好；
        for (String key : map.keySet()) {
            System.out.print("姓名：" + key + "，");
        }
        System.out.println("");
        for (String value : map.values()) {
            System.out.print("颜色：" + value + "，");
        }

        System.out.println("");
        System.out.println("-------------------------------------");
        //方法三：通过Iterator遍历；
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("姓名：" + key + "，颜色：" + value);
        }

        System.out.println("");
        System.out.println("-------------------------------------");
        //方法四：通过键找值遍历，这种方式的效率比较低，因为本身从键取值是耗时的操作；
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.print("颜色：" + value + "，");
        }

    }
}

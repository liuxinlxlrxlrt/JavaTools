package cn.itcast.tools.test;

import cn.itcast.tools.MapTool.MapContainerUtils;

import java.util.HashMap;
import java.util.Map;

public class MapContainerTest {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("liushishi", "好漂亮");
        map.put("jiangpeiyao", 25);
        map.put("fanbingbing", true);
        map.put("lifeier", 99.5);

        Object obj1 = MapContainerUtils.addMapToMapContainer(map).get("liushishi");
        System.out.println("liushishi：" + obj1);
        Object obj2 = MapContainerUtils.addMapToMapContainer(map).get("jiangpeiyao");
        System.out.println("jiangpeiyao：" + obj2);
        Object obj3 = MapContainerUtils.addMapToMapContainer(map).get("fanbingbing");
        System.out.println("fanbingbing：" + obj3);
        Object obj4 = MapContainerUtils.addMapToMapContainer(map).get("lifeier");
        System.out.println("lifeier：" + obj4);

        System.out.println("--------------");

        MapContainerUtils.addKeyValueToMapContainer("yangshutong", false);
        MapContainerUtils.addKeyValueToMapContainer("zhangzilin", 18.5);
        MapContainerUtils.addKeyValueToMapContainer("wanqian", "身材好");
        MapContainerUtils.addKeyValueToMapContainer("zhouxinyu", 88);

        Object obj5 = MapContainerUtils.addMapToMapContainer(map).get("yangshutong");
        System.out.println("yangshutong：" + obj5);
        Object obj6 = MapContainerUtils.addMapToMapContainer(map).get("zhangzilin");
        System.out.println("zhangzilin：" + obj6);
        Object obj7 = MapContainerUtils.addMapToMapContainer(map).get("wanqian");
        System.out.println("wanqian：" + obj7);
        Object obj8 = MapContainerUtils.addMapToMapContainer(map).get("zhouxinyu");
        System.out.println("zhouxinyu：" + obj8);
    }
}

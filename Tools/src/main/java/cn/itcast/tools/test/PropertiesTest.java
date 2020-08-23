package cn.itcast.tools.test;

import cn.itcast.tools.PropertiesTool.PropertiesUtils;

import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

    public static void main(String[] args) throws IOException {

//        //第一种：getClassLoader().getResourceAsStream方式读取配置文件
//        Properties properties1 = PropertiesUtils.getTargetClassesProperties("application.properties");
//        String value1 = properties1.getProperty("test.version");
//        System.out.println("test.version"+value1);
//
//        System.out.println("----------------------------");
//
//        //第一种：getClassLoader().getResourceAsStream方式读取配置文件
//        Properties properties2 = PropertiesUtils.getTargetClassesProperties("config/data-config.properties");
//        String value2 = properties2.getProperty("test.version");
//        System.out.println("test.version"+value2);
//
//
//        System.out.println("----------------------------");
//        String name1 = PropertiesUtils.getValue("application.properties","test.name");
//        String age1 = PropertiesUtils.getValue("config/data-config.properties","test.age");
//        System.out.println("test.name："+name1+"，test.age："+age1);
//
//        System.out.println("----------------------------");
//        // config/data-config如果加上“config”报错“： MissingResourceException: Can't find bundle for base name data-config, locale zh_CN
//        String name2 = PropertiesUtils.getPropertiesValueByreourceBundle("config/data-config","test.name");
//        String age2 = PropertiesUtils.getPropertiesValueByreourceBundle("application","test.age");
//        System.out.println("test.name："+name2+"，test.age："+age2);
//
//        System.out.println("----------------------------");
        String filePath = "D:\\javaCode\\21_ProjectStorageFolder\\TestNG\\JavaTools\\Tools\\src\\main\\resources\\config\\data-config.properties";
//        String version = PropertiesUtils.getPropertiesValueByFileInputStream(filePath).getProperty("test.version").toString();
//        System.out.println("version："+version);

        System.out.println("----------------------------");

        PropertiesUtils.witieValueToPropetites(filePath,"test.port","8888","");
        String port = PropertiesUtils.getPropertiesValueByFileInputStream(filePath).getProperty("test.port").toString();
        System.out.println("port："+port);

    }
}

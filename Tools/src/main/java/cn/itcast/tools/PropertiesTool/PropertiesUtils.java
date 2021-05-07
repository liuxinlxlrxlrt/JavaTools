package cn.itcast.tools.PropertiesTool;

import java.io.*;
import java.security.Permission;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertiesUtils {
    /**
     * 第一种方式：getClassLoader().getResourceAsStream读取配置文件
     *
     * @param prop
     * @return
     */
    public static Properties getTargetClassesProperties(String prop) {
        //Properties，以key=value的键值对的形式运行存储值，key值不能重复
        //因为继承了Hashtable类，以Map的形式进行放置值
        Properties properties = new Properties();
        //resources/application.properties右键，选择copy Ralative path
        InputStream inputStream = PropertiesUtils.class.getClassLoader().getResourceAsStream(prop);

        try {
            //load(InputStream inputStream)：从输入流中读取属性列表（键和元素对）
            //load(Reader reader)：按简单的面向行的格式从输入字符流中读取属性列表键和元素对）
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("请检查配置文件是否正确");
        }
    }

    //获取配置文件中属性列表的元素（键和元素对）
    public static String getValue(String propName, String keyName) {
        Properties properties = getTargetClassesProperties(propName);
        return properties.getProperty(keyName);
    }

    /**
     * 第二种方式：ResourceBundle.getBundle读取配置文件
     * 注意；propName不要带".后缀名"
     *
     * @param propName
     * @param keyName
     * @return
     */
    public static String getPropertiesValueByreourceBundle(String propName, String keyName) {
        String value = "";
        try {
            ResourceBundle bundle = ResourceBundle.getBundle(propName);
            value = bundle.getString(keyName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }


    /**
     * 第三种方式：getPropertiesValueByFileInputStream读取配置文件属性集的value
     * 路径例如：“src/resources/config/xxx.properties
     *
     * @param filePath
     * @return
     */
    public static Properties getPropertiesValueByFileInputStream(String filePath) {
        FileInputStream fileInputStream = null;
        Properties propertiesread = new Properties();

        try {
            fileInputStream = new FileInputStream(filePath);
            propertiesread.load(new InputStreamReader(fileInputStream, "utf-8"));
            return propertiesread;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 写入属性到配置文件中
     *
     * @param filePath
     * @param keyName
     * @param value
     * @param describeinfo
     */
    public static void witieValueToPropetites(String filePath, String keyName, String value, String describeinfo) throws IOException {
        FileOutputStream fileOutputStream = null;
        Properties propertieswrite = new Properties();

        try {
            propertieswrite.setProperty(keyName, value);
            fileOutputStream = new FileOutputStream(filePath, true);
            propertieswrite.store(new OutputStreamWriter(fileOutputStream, "utf-8"), describeinfo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

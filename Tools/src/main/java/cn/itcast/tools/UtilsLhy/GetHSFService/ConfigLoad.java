package cn.itcast.tools.UtilsLhy.GetHSFService;

import cn.itcast.tools.PropertiesTool.PropertiesUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class ConfigLoad {
    private static Logger logger = LoggerFactory.getLogger(ConfigLoad.class);

    public  static Properties load(String deployEnv){
        Properties prop= null;
        if (deployEnv.equalsIgnoreCase("pre1")){
            prop= PropertiesUtils.getTargetClassesProperties("config/pre1.properties");
            logger.info("记载配置文件：pre1.properties");
        }
        if (deployEnv.equalsIgnoreCase("pre2")){
            prop= PropertiesUtils.getTargetClassesProperties("config/pre2.properties");
            logger.info("记载配置文件：pre2.properties");
        }
        if (deployEnv.equalsIgnoreCase("online")){
            prop= PropertiesUtils.getTargetClassesProperties("config/online.properties");
            logger.info("记载配置文件：online.properties");
        }
        return prop;
    }

    public static Properties load(){
        return  load(LoadEnv.getDeployEnv());
    }

    public static Properties loadDefault(){
        return  PropertiesUtils.getTargetClassesProperties("application.properties");
    }

    public static void main(String[] args) {
        Properties properties = ConfigLoad.loadDefault();
        System.out.println(properties.getProperty("hsf.env"));
    }
}

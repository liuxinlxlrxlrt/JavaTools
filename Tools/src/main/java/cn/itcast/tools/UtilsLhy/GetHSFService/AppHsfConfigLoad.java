package cn.itcast.tools.UtilsLhy.GetHSFService;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Policy;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class AppHsfConfigLoad {
    private static Logger logger = LoggerFactory.getLogger(ConfigLoad.class);
    private static Properties properties = null;
    private static String selectConfig = "false";
    private static Map<String, String> appNameIp = null;

    public static void init() {
        appNameIp = new HashMap<>();
        GlobalHsfConfigLoad.init(LoadEnv.getDeployEnv());
        properties = ConfigLoad.load();
        if (!LoadEnv.getEnvIsSystem()) {
            selectConfig = ConfigLoad.loadDefault().getProperty("hsf.select.config", "false");
        }
    }

    public static String getAppHsfVersion(String appName) {
        String version = null;
        if (selectConfig.equalsIgnoreCase("true")) {
            version = properties.getProperty(appName + ".hsf.version");
            if (StringUtils.isEmpty(version)) {
                version = properties.getProperty("hsf.version");
            }
        } else {
            version = GlobalHsfConfigLoad.hsfVersion;
        }
        logger.info(version);
        return version;
    }

    public static String getAppHsfGroup(String appName) {
        String group = null;
        if (selectConfig.equalsIgnoreCase("true")) {
            group = properties.getProperty(appName + ".hsf.group");
            if (StringUtils.isEmpty(group)) {
                group = properties.getProperty("hsf.group");
            }

        } else {
            group = GlobalHsfConfigLoad.hsfGroup;
        }
        logger.info(group);
        return group;
    }

    public static String getAppHsfServiceIp(String appName, String serverName) {
        String ip = null;
        if (StringUtils.isEmpty(appNameIp.get(appName))) {
            if (selectConfig.equalsIgnoreCase("true")) {
                ip = properties.getProperty(".hsf.server");
            } else {
                String versionEnv = LoadEnv.getDeployEnv() == "pre1" ||
                        LoadEnv.getDeployEnv() == "pre2" ||
                        LoadEnv.getDeployEnv() == "pre3" ? "." + LoadEnv.getDeployEnv() : "";
                serverName = serverName + ":" + getAppHsfVersion(appName) + versionEnv;

                ip = GlobalHsfConfigLoad.getHsfServiceIp(appName, serverName);
                if (StringUtils.isEmpty(ip)) {
                    ip = properties.getProperty(appName + ".hsf.server");
                }
            }
        } else {
            ip = appNameIp.get(appName);
        }
        appNameIp.put(appName, ip);
        logger.info(ip);
        return ip;
    }

}

//    public static void main(String[] args) {
//        AppHsfConfigLoad.init();
//        String group = AppHsfConfigLoad.getAppHsfGroup("123");
//        System.out.println(group);
//        String version = AppHsfConfigLoad.getAppHsfVersion("123");
//        System.out.println(version);
//        String ip = AppHsfConfigLoad.getAppHsfServiceIp("123", "456");
//        System.out.println(ip);
//    }


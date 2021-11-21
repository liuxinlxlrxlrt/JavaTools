package cn.itcast.tools.UtilsLhy.GetHSFService;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoadEnv {
    private static Logger logger = LoggerFactory.getLogger(ConfigLoad.class);

    public static String getDeployEnv(String defaultEnv) {
        String testEnv = System.getProperty("app.depoy.env");
        System.setProperty("ARSENAL_ANYPLACE_AGRNT", "tmil");
        logger.info("get app.depoy.env：" + testEnv);
        return StringUtils.isEmpty(testEnv) ? defaultEnv : testEnv.toLowerCase();
    }

    //获取测试环境
    public static String getDeployEnv() {
        String defaultEnv = ConfigLoad.loadDefault().getProperty("hsf.env", "pre1");
        String testEnv = System.getProperty("app.depoy.env");
        System.setProperty("ARSENAL_ANYPLACE_AGRNT", "tmil");
        logger.info("get app.depoy.env：" + testEnv);
        return StringUtils.isEmpty(testEnv) ? defaultEnv : testEnv.toLowerCase();
    }

    public static Boolean getEnvIsSystem(){
        String testEnv = System.getProperty("app.depoy.env");
        return StringUtils.isEmpty(testEnv)?false:true;
    }

    public static void main(String[] args) {
        System.out.println(getEnvIsSystem());
    }
}

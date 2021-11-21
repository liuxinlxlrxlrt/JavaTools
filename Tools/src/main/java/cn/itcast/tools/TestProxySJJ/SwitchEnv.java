package cn.itcast.tools.TestProxySJJ;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SwitchEnv {
    //运行环境
    private Env env;
    //hsf环境
    private String hsfVersion;
    //目标机器
    private String targetIp;
    //目标及其_samrthome
    private String tagetIp_stamrthome;
    //环境名称
    private String envName;

    public SwitchEnv(String envName){
        Properties prop = new Properties();

        if(envName==null){
            envName="pre2";
        }
        switch (envName){
            case "online": {
                InputStream inputStream = SwitchEnv.class.getClassLoader().getResourceAsStream("config/online.properties");

                try {
                    prop.load(inputStream);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                env=Env.ONLINE;
                break;
            }
            case "pre2": {
                InputStream inputStream = SwitchEnv.class.getClassLoader().getResourceAsStream("config/pre2.properties");

                try {
                    prop.load(inputStream);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                env=Env.PREPARE;
                break;
            }
            case "pre1": {
                InputStream inputStream = SwitchEnv.class.getClassLoader().getResourceAsStream("config/pre1.properties");

                try {
                    prop.load(inputStream);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                env=Env.DALIY;
                break;
            }
            default:
                try {
                    throw new Exception("环境变量输入错误");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
        hsfVersion=prop.getProperty("hsfVersion").trim();
        targetIp=prop.getProperty("targetIp").trim();
        tagetIp_stamrthome=prop.getProperty("tagetIp_stamrthome").trim();
        this.envName=envName;
    }

    public Env getEnv() {
        return env;
    }

    public String getHsfVersion() {
        return hsfVersion;
    }

    public String getTargetIp() {
        return targetIp;
    }

    public String getTagetIp_stamrthome() {
        return tagetIp_stamrthome;
    }

    public String getEnvName() {
        return envName;
    }
}

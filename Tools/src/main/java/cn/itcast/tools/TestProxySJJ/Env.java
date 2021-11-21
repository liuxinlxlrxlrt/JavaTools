package cn.itcast.tools.TestProxySJJ;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public enum Env {
    DALIY("123","123","123","123","123"),
    PREPARE("123","123","123","123","123"),
    ONLINE("123","123","123","123","123");

    private static Map<Env, List<String>> multiEnvMap = new HashMap<Env, List<String>>();
    private static String currentEnv;
    private String value;
    private String topServerUrl;
    private String topKey;
    private String topSecret;
    private String anoneEnv;
    private static Map<String,Env> pool;

    Env(String value, String topDomain, String topKey, String topSecret, String anoneEnv) {
        this.value = value;
        this.topServerUrl = String.format("http://%s/top/router/rest",topDomain);
        this.topKey = topKey;
        this.topSecret = topSecret;
        this.anoneEnv = anoneEnv;
    }

    private Env(String value, String topDomain, String topKey, String topSecret) {
        this(value,topDomain,topKey,topSecret,"");
    }

    public static Map<Env, List<String>> getMultiEnvMap() {
        return multiEnvMap;
    }

    public static void setMultiEnvMap(Map<Env, List<String>> multiEnvMap) {
        Env.multiEnvMap = multiEnvMap;
    }

    public static Env getCurrentEnv() {
        currentEnv=getCurrentEnvTag();
        return index(currentEnv);
    }

    public static void setCurrentEnv(Env env) {
        if (env!=null){
            currentEnv=env.getValue();
        }
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTopServerUrl() {
        return topServerUrl;
    }

    public void setTopServerUrl(String topServerUrl) {
        this.topServerUrl = topServerUrl;
    }

    public String getTopKey() {
        return topKey;
    }

    public void setTopKey(String topKey) {
        this.topKey = topKey;
    }

    public String getTopSecret() {
        return topSecret;
    }

    public void setTopSecret(String topSecret) {
        this.topSecret = topSecret;
    }

    public String getAnoneEnv() {
        return anoneEnv;
    }

    public void setAnoneEnv(String anoneEnv) {
        this.anoneEnv = anoneEnv;
    }

    public static Map<String, Env> getPool() {
        return pool;
    }

    public static void setPool(Map<String, Env> pool) {
        Env.pool = pool;
    }

    public static String getCurrentEnvTag(){
        if (currentEnv==null){
            try {
                String sysEnv =(String) System.getenv().get("YKQA_ENV");
                String configEnv= null;


                try {
                    ResourceBundle resourceBundle =ResourceBundle.getBundle("application");
                    configEnv=resourceBundle.getString("env").toLowerCase();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (sysEnv!=null){
                    currentEnv=sysEnv;
                }else if (configEnv!=null){
                    currentEnv=configEnv;
                }else {
                    currentEnv="daliy";
                }
            } catch (Exception e) {
                System.out.println("getCurrentEnv出错，切换到日常环境");
                currentEnv="daliy";
            }
        }
        return currentEnv;
    }

    public static Env index(String desc){
        if (StringUtils.isBlank(desc)){
            return null;
        }else if (null!=pool.get(StringUtils.trim(desc))){
            return (Env) pool.get(StringUtils.trim(desc));
        }else {
            Iterator var1= multiEnvMap.keySet().iterator();
            while (var1.hasNext()){
                Env env = (Env) var1.next();
                List<String> multiEnvConfig =multiEnvMap.get(env);
                Iterator var4 = multiEnvConfig.iterator();
                while (var4.hasNext()){
                    String envConfig =(String) var4.next();
                    if (envConfig.equalsIgnoreCase(StringUtils.trim(desc))){
                        return env;
                    }
                }
            }
            return null;
        }
    }
}

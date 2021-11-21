package cn.itcast.tools.UtilsLhy.GetHSFService;

import cn.itcast.tools.TestProxySJJ.Env;

/**
 * 环境配置类
 */
public class EnvConfig {
    private String serviceName;
    private Env env;
    private String hsfGroup="HSF";
    private String version;
    private String post="12200";
    private String ip;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Env getEnv() {
        return env;
    }

    public void setEnv(Env env) {
        this.env = env;
    }

    public String getHsfGroup() {
        return hsfGroup;
    }

    public void setHsfGroup(String hsfGroup) {
        this.hsfGroup = hsfGroup;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}

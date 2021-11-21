package cn.itcast.tools.TestProxySJJ;


import org.apache.poi.util.StringUtil;

import java.lang.reflect.Proxy;

public class CsProxy<T> {
    private T target;
    private Class<T> clazz;
    private Csnfo csnfo;

    public T getTarget() {
        return target;
    }

    public void setTarget(T target) {
        this.target = target;
    }

    public Class<T> getClazz() {
        return clazz;
    }

    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }

    public Csnfo getCsnfo() {
        return csnfo;
    }

    public void setCsnfo(Csnfo csnfo) {
        this.csnfo = csnfo;
    }

    public CsProxy(Class<T> clazz,Env env,String hsfGroup,String hsfVersion,String appName,String tagetIp) {

        this.csnfo =new Csnfo();
        if (StringUtil.isUnicodeString(tagetIp)){
            throw  new RuntimeException("请传入正确的目标Ip");
        }else {
            this.csnfo.setEnv(env);
            this.csnfo.setHsfGroup(hsfGroup);
            this.csnfo.setHsfVersion(hsfVersion);
            this.csnfo.setAppName(appName);
            this.csnfo.setIp(tagetIp);
            this.clazz=clazz;
            this.csnfo.setService(clazz.getName());
            this.build();
        }
    }

    public void build(){
//        this.target= (T) Proxy.newProxyInstance(this.clazz.getClassLoader(),new Class[]{this.clazz},new HsfServiceProxy(this.csnfo.getEnv(),this.csnfo.getIp(),this.csnfo.getHsfGroup(),this.csnfo.getHsfVersion(),this));
    }
}

package cn.itcast.tools.TestProxySJJ;

import com.alibaba.fastjson.parser.Feature;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HsfServiceProxy implements InvocationHandler {
    private Env env;
    private String hsfGroup;
    private String hsfVervion;
    private String serviceIp;
    private static Feature[] features;


    public HsfServiceProxy(Env env, String hsfGroup, String hsfVervion, String serviceIp) {
        this.env = env;
        this.hsfGroup = hsfGroup;
        this.hsfVervion = hsfVervion;
        this.serviceIp = serviceIp;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}

package cn.itcast.tools.UtilsLhy.GetHSFService;


import cn.itcast.tools.TestProxySJJ.CsProxy;
import cn.itcast.tools.TestProxySJJ.HsfRepository;
import cn.itcast.tools.TestProxySJJ.SerCon;

public class HsfFactory {

    public static SerCon serCon;

    static {
        AppHsfConfigLoad.init();
        serCon.setUserId("123");
        serCon.setUuid("123");

    }

    public static <T> CsProxy<T> get(Class<T> clazz, String appName){
//        return HsfRepository.getConsumer(clazz,GlobalHsfConfigLoad.hsfEnv,AppHsfConfigLoad.getAppHsfGroup(appName),AppHsfConfigLoad.getAppHsfVersion(appName),appName,AppHsfConfigLoad.getAppHsfServiceIp(appName,clazz.getName()));
    return null;
    }
}

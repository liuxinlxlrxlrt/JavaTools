package cn.itcast.tools.UtilsLhy.GetHSFService;

import cn.itcast.tools.TestProxySJJ.Env;
import cn.itcast.tools.UtilsLhy.GetHSFService.other.HttpRepository;
import cn.itcast.tools.UtilsLhy.GetHSFService.other.HttpResponseBase;
import cn.itcast.tools.UtilsLhy.GetHSFService.other.SSOHttpApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GlobalHsfConfigLoad {
    private static Logger logger = LoggerFactory.getLogger(GlobalHsfConfigLoad.class);
    public static String hsfGroup = "HSF";
    public static String hsfVersion = "1.0.0";
    public static Env hsfEnv;

  public static void init(String deployEnv){
      setHsfEnv(deployEnv);
      setHsfVserion(deployEnv);
  }

    public static void setHsfVserion(String deployEnv) {
        switch (deployEnv) {
            case "pre1":
                hsfVersion = hsfVersion + "pre1";
                break;
            case "pre2":
                hsfVersion = hsfVersion + "pre2";
                break;
            case "pre3":
                hsfVersion = hsfVersion + "pre3";
                break;
        }
    }

    public static void setHsfEnv(String deployEnv) {
        String env = deployEnv.toLowerCase();
        switch (env) {
            case "online":
                Env.setCurrentEnv(Env.ONLINE);
                hsfEnv = Env.getCurrentEnv();
                break;
            case "pre2":
                Env.setCurrentEnv(Env.PREPARE);
                hsfEnv = Env.getCurrentEnv();
                break;
            case "pre1":
                Env.setCurrentEnv(Env.DALIY);
                hsfEnv = Env.getCurrentEnv();
                break;
            default:
                Env.setCurrentEnv(Env.PREPARE);
                hsfEnv = Env.getCurrentEnv();
                break;
        }
    }

    public static String getHsfServiceIp(String appName,String serverName){
        SSOHttpApi ssoHttpApi = HttpRepository.getSSOApi("123");
        String url= String.format("http://hsf.alibaba-inc.com/hsfops/serviceDetail.htm?envType=pre&dataId=%s&appName=%s",serverName,appName);
//        HttpResponseBasehttpResponseBase = ssoHttpApi.get(url);
        String body=new HttpResponseBase().getResponse();
        Matcher m1 = Pattern.compile("[<td><a href=\\\"*]>[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}").matcher(body);
        String ip=null;
        if (m1.find()){
            ip=m1.group();
        }else {
            System.out.println("IP不存在");
        }
        Matcher m2 = null;
        try {
            m2=Pattern.compile("[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}").matcher(ip);
        } catch (Exception e) {
            logger.debug(">>>没有获取到IP信息"+e);
            return ip = null;
        }
        if (m2.find()){
            ip =m2.group();
        } else  {
            System.out.println("IP不存在");
        }
        return ip;
    }

}

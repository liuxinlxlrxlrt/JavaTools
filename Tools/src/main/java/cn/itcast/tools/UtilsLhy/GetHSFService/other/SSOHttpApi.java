package cn.itcast.tools.UtilsLhy.GetHSFService.other;

public class SSOHttpApi {
    private SSOLoginHttpRequest ss;
    private UserParamater user;
    private boolean isDebug =false;
    private boolean isShadow = false;
    private String appCode;

    public SSOHttpApi( UserParamater user, boolean isShadow, String appCode) {
        this.ss = new SSOLoginHttpRequest();
        this.user = user;
        this.isShadow = isShadow;
        this.appCode = appCode;
    }

    public String get(String url){
        return url;
    }
}

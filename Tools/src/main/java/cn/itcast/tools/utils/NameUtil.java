package cn.itcast.tools.utils;

import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 * 随机生成汉字，随机生成数字
 */
public class NameUtil {
    /**
     * 获取随机数
     * @param len
     * @return
     */
    public static  String getLetter(int len){
        return RandomUtils.getRandomString(len);
    }

    public static Long getRandomLong(int len) {
        int rs = (int) ((Math.random() * 9 + 1) * Math.pow(10, len - 1));
        return Long.valueOf(String.valueOf(rs));
    }

    /**
     * 获取指定个数的汉字
     * @param len
     * @return
     */
    public static String getRandomString(int len){
        StringBuilder str = new StringBuilder();
        for (int i=0;0<=len;i++){
            str.append(getRandomString());
        }
        return String.valueOf(str);
    }

    public static String getRandomString(){
        String str="";
        int highPos;
        int lowPos;
        Random random = new Random();
        highPos= (176+Math.abs(random.nextInt(39)));
        lowPos=(161+Math.abs(random.nextInt(93)));

        byte[] bytes = new byte[2];
        bytes[0]= (Integer.valueOf(highPos)).byteValue();
        bytes[1]=(Integer.valueOf(lowPos)).byteValue();

        try {
            str=new String(bytes,"GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }


}

package cn.itcast.tools.utils;

import java.io.UnsupportedEncodingException;
import java.util.Random;

public class TestNGUtils {

    //    1.获取指定个数的随机汉字
    private static Random random = new Random();
    private static int UNICODE_START = 19968;
    private static int UNICODE_END = 40864;

    public static char getChineseChar() {
        return (char) (UNICODE_START + random.nextInt(UNICODE_END - UNICODE_START));
    }

    public static String getChineseWord(int len) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < len; ++i) {
            char str = getChineseChar();
            res.append(str);
        }
        return res.toString();
    }


    public static String getRandomChinese(int len) {
        String chineseResult = "";
        for (int i = 0; i < len; i++) {
            String string = null;
            Random random = new Random();
            int hightPos = (176 + Math.abs(random.nextInt(39)));
            int lowPos = (161 + Math.abs(random.nextInt(93)));
            byte[] byt = new byte[20];
            byt[0] = (new Integer(hightPos).byteValue());
            byt[1] = (new Integer(lowPos).byteValue());

            try {
                string = new String(byt, "GBK");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            chineseResult += string;

        }
        return chineseResult;
    }


    //    2、随机生成指定位数的数字

    public static String getRandomNumber(int len) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            stringBuilder.append(random.nextInt(10));
        }

        return stringBuilder.toString();
    }

    //    生成email
    public static String str = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static  final String[] email_suffix="@gmail.com,@yahoo.com,@sohu.com,@sina.com，@yeah.net,@126.com,@gmail.com,@163.com,@qq.com,@msn.com".split(",");
    public static String getRandomEail(int min, int max) {
        int len = getNumber(min, max);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < len; i++) {
            int num = (int) (Math.random() * str.length());
            stringBuffer.append(str.charAt(num));
        }
        stringBuffer.append(email_suffix[(int)(Math.random()*email_suffix.length)]);
        return   stringBuffer.toString();
    }

    public static int getNumber(int start, int end) {
        return (int) (Math.random() * (end - start + 1) + start);
    }

    //生成手机号码
    private static String[] tel="134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");

    public static String getPhoneNum(){
        int index=getNumber(0,tel.length-1);
        String first=tel[index];
        String second=String.valueOf(getNumber(1,888)+10000).substring(1);
        String third=String.valueOf(getNumber(1,9100)+10000).substring(1);
        return first+second+third;
    }

    public static void main(String[] args) {
//        String randomChinese = getRandomChinese(900);
//        System.out.println(randomChinese);
//
//        String chineseWord = getChineseWord(900);
//        System.out.println(chineseWord);
//        String randomNumber = getRandomNumber(50);
//        System.out.println(randomNumber);

        String randomEail = getRandomEail(1, 9);
        System.out.println(randomEail);

        String phoneNum = getPhoneNum();
        System.out.println(phoneNum);
    }


}

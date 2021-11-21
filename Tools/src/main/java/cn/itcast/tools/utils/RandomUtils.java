package cn.itcast.tools.utils;

import java.util.*;

public class RandomUtils {
    private static Random random = new Random();
    private static int UNICODE_START = 19968;
    private static int UNICODE_END = 40864;

    public RandomUtils() {
    }



    public static long getLong() {
        return random.nextLong();
    }

    public static long getLongMoreThanZero() {
        long res;
        for (res = random.nextLong(); res <= 0L; res = random.nextLong()) {
        }
        return res;
    }

    /**
     * 获取 res%n的余数
     *
     * @param n
     * @return
     */
    public static long getLongLessThan(long n) {
        long res = random.nextLong();
        return res % n;
    }

    public static long getLongMoreThanZeroLessThan(long n) {
        long res;
        for (res = random.nextLong(); res <= 0L; res = getLongLessThan(n)) {
        }
        return res;
    }


    public static long getLongBetween(long n, long m) {
        if (m <= n) {
            return n;
        } else {
            long res = getLongMoreThanZero();
            return n + res % (m - n);
        }
    }

    public static int getInteger() {
        return random.nextInt();
    }

    public static int getIntegerMoreThanZero() {
        int res;
        for (res = random.nextInt(); res <= 0; res = random.nextInt()) {
        }
        return res;
    }

    public static int getIntegerLessThan(int n) {
        long res = random.nextLong();
        return (int) (res % n);
    }

    public static int getIntegerMoreThanZeroLessThan(int n) {
        long res;
        for (res = random.nextInt(n); res == 0; res = getIntegerLessThan(n)) {
        }
        return (int) res;
    }


    public static int getIntegerBetween(int n, int m) {
        if (m <= n) {
            return n;
        } else {
            long res = getIntegerMoreThanZero();
            return (int) (n + res % (m - n));
        }
    }


    private static char getChar(int[] arg) {
        int size = arg.length;
        int c = random.nextInt(size / 2);
        c *= 2;
        return (char) getIntegerBetween(arg[c], arg[c + 1]);
    }

    private static String getString(int n, int[] arg) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            res.append(getChar(arg));
        }
        return res.toString();
    }

    public static String getStringWithCharacter(int n) {
        int[] arg = new int[]{97, 123, 65, 91};
        return getString(n, arg);
    }

    public static String getStringWithNumber(int n) {
        int[] arg = new int[]{48, 58};
        return getString(n, arg);
    }

    public static String getStringWithNumAndChar(int n) {
        int[] arg = new int[]{97, 123, 65, 91, 48, 58};
        return getString(n, arg);
    }

    /**
     * 获取指定个数的随机数
     * @param length
     * @return
     */
    public static String getRandomString(int length) {
        String str = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer buffer = new StringBuffer(str);
        StringBuffer sb = new StringBuffer(str);
        Random random = new Random();
        int range = buffer.length();

        for (int i = 0; i < length; i++) {
            sb.append(buffer.charAt(random.nextInt(range)));
        }
        return sb.toString();
    }

    public static String getStringShortenTan(int n){
        int len = getIntegerMoreThanZeroLessThan(n);
        return getStringWithCharacter(len);
    }

    public static String getStringWithNumAndCharShortenTan(int n){
        int len = getIntegerMoreThanZeroLessThan(n);
        return getStringWithNumAndChar(len);
    }

    public static String getStringWithNumAndCharBetween(int n,int m){
        int len = getIntegerBetween(n,m);
        return getStringWithNumAndChar(len);
    }

    public static String getStringWithPrefix(int n,String prefix){

        int len = prefix.length();
        if(n<=len){
            return  prefix;
        }else {
            len = n-len;
            StringBuilder res = new StringBuilder(prefix);
            res.append(getStringWithCharacter(len));
            return res.toString();
        }
    }

    public static String getStringWithSuffix(int n,String suffix){

        int len = suffix.length();
        if(n<=len){
            return  suffix;
        }else {
            len = n-len;
            StringBuilder res = new StringBuilder();
            res.append(getStringWithCharacter(len));
            res.append(suffix);
            return res.toString();
        }
    }

    public static String getStringWithBoth(int n,String prefix,String suffix){

        int len = prefix.length()+suffix.length();
        StringBuilder res = new StringBuilder(prefix);
        if(n<=len){
            return  res.append(suffix).toString();
        }else {
            len = n-len;
            res.append(getStringWithCharacter(len));
            res.append(suffix);
            return res.toString();
        }
    }

    public static char getChineseChar(){
        return (char) (UNICODE_START+random.nextInt(UNICODE_END-UNICODE_START));
    }

    public static String getChineseWord(int len){
        StringBuilder res = new StringBuilder();

        for(int i=0;i<len;++i){
            char str = getChineseChar();
            res.append(str);
        }
        return res.toString();
    }
    public static String getChineseWordWithPrefix(int n,String prefix){

        int len = prefix.length();
        if(n<=len){
            return  prefix;
        }else {
            len = n-len;
            StringBuilder res = new StringBuilder(prefix);
            res.append(getChineseWord(len));
            return res.toString();
        }
    }

    public static String getChineseWordWithSuffix(int n,String suffix){

        int len = suffix.length();
        if(n<=len){
            return  suffix;
        }else {
            len = n-len;
            StringBuilder res = new StringBuilder();
            res.append(getChineseWord(len));
            res.append(suffix);
            return res.toString();
        }
    }


    public static boolean getBoolean(){
        return getIntegerMoreThanZeroLessThan(3)==1;
    }

    public static String getStringByUUID(){
        return UUID.randomUUID().toString();
    }

    public static Collection<Integer> getRandomCollection(int min,int max,int n){
        Set<Integer> res = new HashSet<Integer>();
        int mx =max;
        int mn = min;
        int i;
        if(n ==max+1-min){
            for (i=1;i<=n;++i){
                res.add(i);
            }
            return res;
        }else {
            for (i=1;i<n;++i){
                int v =getIntegerBetween(mn,mx);
                if (v==mx){
                    --mx;
                }
                if (v==mn){
                    ++mn;
                }
                while (res.contains(v)){
                    v=getIntegerBetween(mn,mx);
                    if (v==mx){
                        mx=v;
                    }
                    if (v==mn){
                        mn=v;
                    }
                }
                res.add(v);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        String chineseWord = getChineseWord(90);
        System.out.println(chineseWord);
    }
}

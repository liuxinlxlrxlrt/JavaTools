package cn.itcast.tools.count;

/**
 * 计算从0加到100
 */
public class TestAdd1To100 {
    //    public static void main(String[] args) {
//        int sum=0;
//        int count=100;
//        for (int i=0;i<=count;i++){
//            sum+=i;
//        }
//        System.out.println(sum);
//    }
    public static void main(String[] args) {
        int sum = 0;
        int count = 100;
        sum = (count + 1) * 100 / 2;
        System.out.println(sum);

    }
}

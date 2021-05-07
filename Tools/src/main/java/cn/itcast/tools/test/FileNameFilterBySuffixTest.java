package cn.itcast.tools.test;

import cn.itcast.tools.OthersTool.FileNameFilterBySuffix;

import java.io.File;

public class FileNameFilterBySuffixTest {
    public static void main(String[] args) {
        /**
         * list（）和listFiles（）方法区别：
         * 1.返回值类型不同：前者为String数组，后者为File对象数组
         * 2.数组中元素内容不同：前者为string类型的【文件名】（包含后缀名），
         * 后者为File对象类型的【完整路径】
         */
        File file = new File("D:\\学习\\7_学习总结\\xmind总结\\excel文件");
        FileNameFilterBySuffix filter1 = new FileNameFilterBySuffix(".xls");
        String[] files1 = file.list(filter1);
        for (String f1 : files1) {
            System.out.println(f1);
        }
        System.out.println("-------------------");
        FileNameFilterBySuffix filter2 = new FileNameFilterBySuffix(".xlsx");
        String[] files2 = file.list(filter2);
        for (String f2 : files2) {
            System.out.println(f2);
        }
    }
}

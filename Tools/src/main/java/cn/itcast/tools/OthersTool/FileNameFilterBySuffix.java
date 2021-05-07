package cn.itcast.tools.OthersTool;

import java.io.File;
import java.io.FilenameFilter;

//文件名过滤器
public class FileNameFilterBySuffix implements FilenameFilter {

    //suffix为需要过滤的条件，比如如果suffix=".jpg"，则只能返回后缀为jpg的文件
    private String suffix;

    public FileNameFilterBySuffix(String suffix) {
        super();
        this.suffix = suffix;
    }

    //dir表示文件的当前目录，name表示文件名；

    public boolean accept(File dir, String name) {
        return name.endsWith(suffix);
    }
}




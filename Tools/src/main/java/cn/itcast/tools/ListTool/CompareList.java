package cn.itcast.tools.ListTool;

import java.util.List;

public class CompareList {

    public static boolean isListEqual(List l1, List l2){
        if(l1==l2){
            return true;
        }
        if(null==l1&&null==l2){
            return false;
        }
        if(null==l1||null==l2){
            return false;
        }
        if(l1.size()!=l2.size()){
            return false;
        }

        for(Object o :l1){
            if(!l2.contains(o)){
                return false;
            }
        }

        for(Object o:l2){
            if(!l1.contains(o)){
                return false;
            }
        }
        return true;
    }
}

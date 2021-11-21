package cn.itcast.tools.UtilsLhy.UTil;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AssertUtil {
    public static void AssertNotNull(Object obj,String... ignoreArrr){
        Class clazz = obj.getClass();
        PropertyDescriptor[] pds = new PropertyDescriptor[0];
        List<String> ignoreList = new ArrayList<>();
        if (ignoreArrr!=null&&ignoreArrr.length>0){
            ignoreList= Arrays.asList(ignoreArrr);
        }

        try {
            pds= Introspector.getBeanInfo(clazz,Object.class).getPropertyDescriptors();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (PropertyDescriptor pd : pds) {
            String name = pd.getName();
            if (ignoreList.contains(name)){
                continue;
            }
            Method readMethod = pd.getReadMethod();
            Object value=null;
            try {
                value=readMethod.invoke(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

    }
}

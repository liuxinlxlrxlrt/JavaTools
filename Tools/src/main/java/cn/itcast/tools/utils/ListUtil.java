package cn.itcast.tools.utils;


import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Logger;

/**
 * 判断list集合中是否包含某个字符串
 */
public class ListUtil {
    private static Logger logger = (Logger) Logger.getLogger(String.valueOf(ListUtil.class));

    public Boolean containsExpectStr(Object obj, String target, String expect) {
        boolean hasTargetStr = false;

        if (obj instanceof List) {
            logger.info("集合大小为：" + ((List) obj).size());
            for (Object o : (List) obj) {
                Class cls = o.getClass();
                target = target.substring(0, 1).toUpperCase() + target.substring(1);
                Method method;

                try {
                    if (cls.isPrimitive()) {
                        logger.info("查询的泛型是基本类型");
                    } else {
                        method = cls.getDeclaredMethod("get" + target);
                        String source = method.invoke(o).toString();
                        if (source.equals(expect)) {
                            hasTargetStr = true;
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
        return hasTargetStr;
    }

}

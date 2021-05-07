package cn.itcast.tools.MapTool;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPath;

import java.util.HashMap;
import java.util.Map;

public class MapContainerUtils {
    //定义一个map容器
    private static Map<String, Object> mapContainer = new HashMap<String, Object>();

    /**
     * 添加key和value到mapContainer
     *
     * @param key
     * @param obj
     * @return
     */
    public static Map<String, Object> addKeyValueToMapContainer(String key, Object obj) {
        if (key == null || key.equals("") || obj == null || obj.equals("")) {
            throw new RuntimeException("key或者value为空或者null");
        }
        mapContainer.put(key, obj);
        return mapContainer;
    }

    /**
     * 添加map到mapContainer
     *
     * @param map
     * @return
     */
    public static Map<String, Object> addMapToMapContainer(Map<String, Object> map) {
        if (map == null || map.equals("")) {
            throw new RuntimeException("map为空或者null");
        }
        mapContainer.putAll(map);
        return mapContainer;
    }

    /**
     * 通过JSONPATH获取value的值
     *
     * @param key
     * @return
     */
    public static Object getValue(String key) {
        if (key == null || key.equals("")) {
            throw new RuntimeException("map为空或者null");
        }
        Object obj = JSONPath.read(JSON.toJSONString(mapContainer), "$." + key + "");
        return obj;
    }
}

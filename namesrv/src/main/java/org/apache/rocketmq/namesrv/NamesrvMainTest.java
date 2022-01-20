package org.apache.rocketmq.namesrv;

import com.alibaba.fastjson.JSONObject;
import org.apache.rocketmq.namesrv.kvconfig.KVConfigSerializeWrapper;

import java.util.HashMap;

/**
 * @author zxin
 * @date 2022-01-05 10:38
 */
public class NamesrvMainTest {
    public static void main(String[] args) {
        HashMap<String/* Namespace */, HashMap<String/* Key */, String/* Value */>> configTable = new HashMap<>();
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("name", "zxin");
        configTable.put("namespace1",stringStringHashMap);
        KVConfigSerializeWrapper kvConfigSerializeWrapper = new KVConfigSerializeWrapper();
        kvConfigSerializeWrapper.setConfigTable(configTable);
        String s = JSONObject.toJSONString(kvConfigSerializeWrapper);
        System.out.println(s);

    }
}

package test.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/30.
 */
public class T1
{
    public static void main(String[] args) {
        Map<String, Integer> maps = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            maps.put("key" + i, i * 5);
        }
//        for (maps.Entry<String,Integer> :
//             ) {
//
//        }

        for (Map.Entry<String, Integer> entry : maps.entrySet()) {
        System.out.println(entry.getKey());
        System.out.println(entry.getValue());
    }
    }
}

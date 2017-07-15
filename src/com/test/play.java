package com.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by major on 2016/12/10.
 */
public class Play {

    public void play() {
        Map<String, String> map1 = new HashMap<>();
        map1.put("k1", "v1");
        map1.put("k2","v2");

        Map<String, String> map2 = new HashMap<>(map1);
        map1.replace("k1", "v one");
        map1.replace("k2", "v two");

        map1.forEach((k, v)->{
            System.out.println(k + ":" + v );
        });
        System.out.println();
        map2.forEach((k, v)->{
            System.out.println(k + ":" + v );
        });

    }

    public static void main(String[] args) {
        Play p = new Play();
        p.play();
    }

}

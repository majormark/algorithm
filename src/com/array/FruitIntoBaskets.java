package com.array;

import java.util.HashMap;
import java.util.Map;

// 904. Fruit Into Baskets
public class FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        if (fruits == null || fruits.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        HashMap<Integer, Integer> m = new HashMap<>();
        int len = 0;
        while (left <= right && right < fruits.length) {
            m.put(fruits[right], m.getOrDefault(fruits[right], 0) + 1);
            while (m.size() > 2) {
                m.put(fruits[left], m.get(fruits[left]) - 1);
                if (m.get(fruits[left]) == 0) {
                    m.remove(fruits[left]);
                }
                left++;
            }
            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }




    public static void main(String[] args) {
        System.out.println(new FruitIntoBaskets().totalFruit(new int[]{1,0,1,1,4,1,1,1,1,1}));
    }
}

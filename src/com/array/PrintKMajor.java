package com.array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 在数组中找到出现次数大于N/k的数
 */
public class PrintKMajor {
    public void printHalfMajor(int[] arr) {
        int times = 0;
        int cand = 0;
        for (int i = 0; i < arr.length; i++) {
            if (times == 0) {
                cand = arr[i];
                times = 1;
            } else if (cand == arr[i]) {
                times++;
            } else {
                times--;
            }
        }
        times = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == cand) {
                times++;
            }
        }
        if (times > arr.length / 2) {
            System.out.println(cand);
        } else {
            System.out.println("no such number.");
        }
    }

    public void printKMajor(int[] arr, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (m.containsKey(arr[i])) {
                m.put(arr[i], m.get(arr[i]) + 1);
            } else {
                if (m.size() == k - 1) {
                    allCandsMinus(m);
                } else {
                    m.put(arr[i], 1);
                }
            }
        }
        HashMap<Integer, Integer> reals = getReals(arr, m);
        boolean print = false;
        for (Map.Entry<Integer, Integer> entry : reals.entrySet()) {
            if (entry.getValue() > arr.length / k) {
                System.out.println(entry.getKey());
                print = true;
            }
        }
        if (!print) {
            System.out.println("no such number");
        }
    }

    public HashMap<Integer, Integer> getReals(int[] arr, HashMap<Integer, Integer> cands) {
        HashMap<Integer, Integer> reals = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (cands.containsKey(arr[i])) {
                if (reals.containsKey(arr[i])) {
                    reals.put(arr[i], reals.get(arr[i]) + 1);
                } else {
                    reals.put(arr[i], 1);
                }
            }
        }
        return reals;
    }

    public void allCandsMinus(HashMap<Integer, Integer> m) {
        List<Integer> removeList = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            if (entry.getValue() == 1) {
                removeList.add(entry.getKey());
            }
            entry.setValue(entry.getValue() - 1);
        }
        for (int i = 0; i < removeList.size(); i++) {
            m.remove(m.get(removeList.get(i)));
        }
    }

}

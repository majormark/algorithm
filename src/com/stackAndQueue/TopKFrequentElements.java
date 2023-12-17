package com.stackAndQueue;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//347. Top K Frequent Elements
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }
        int[] heap = new int[k];
        int idx = 0;
        for (Integer value : countMap.values()) {
            if (idx < k) {
                heapInsert(heap, idx, value);
            } else if (heap[0] < value) {
                heap[0] = value;
                heapify(heap, 0, k);
            }
            idx++;
        }
        int[] res = new int[k];
        idx = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() >= heap[0]) {
                res[idx++] = entry.getKey();
            }
            if (idx == k) break;
        }
        return res;

    }

    public void heapify(int[] heap, int idx, int size) {
        int child;
        for (; idx * 2 + 1 < size; idx = child) {
            child = idx * 2 + 1;
            if (child + 1 < size && heap[child + 1] < heap[child]) child++;
            if (heap[child] < heap[idx]) {
                swap(heap, idx, child);
            } else {
                break;
            }
        }
    }

    public void heapInsert(int[] heap, int idx, int num) {
        heap[idx] = num;
        while (heap[(idx - 1) / 2] > heap[idx]) {
            swap(heap, (idx - 1) / 2, idx);
            idx = (idx - 1) / 2;
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

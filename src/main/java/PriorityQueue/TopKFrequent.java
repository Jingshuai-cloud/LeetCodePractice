package PriorityQueue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    public static void main(String[] args) {
        int[] nums = {1,1,1,3,4,4,3,4,5,0};
        int k = 3;
        int[] result = topKelementHeep(nums, k);
    }

    private static int[] topKelementHeep(int[] nums, int k) {
        int[] result = new int[3];
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(nums, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int key = entry.getKey(); int count = entry.getValue();
            if (pq.size() == k) {
                if (pq.peek()[1] < count) {
                    pq.poll();
                    pq.add(new int[] {key, count});
                }
            }else {
                pq.add(new int[] {key, count});
            }
        }
        return result;
    }
}

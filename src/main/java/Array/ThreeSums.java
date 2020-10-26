package Array;

import java.util.*;

public class ThreeSums {
    public static void main(String[] args) {
        int nums[] = {-1,0,1,2,-1,-4};
        List result = threeSumsBruteForce(nums);
        List result2 = threeSumHashTable(nums);
        List result3 = threeSumDoublePonter(nums);
        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
    }

    private static List threeSumDoublePonter(int[] nums) {
        Arrays.sort(nums);
        HashSet result = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                int sum = -(nums[left] + nums[right]);
                if (nums[i] == sum) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                }
                if (nums[i] > sum)
                    right--;
                else
                    left++;
            }
        }
        return new ArrayList(result);
    }

    private static List threeSumHashTable(int[] nums) {
        HashSet result = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            HashMap hashMap = new HashMap();
            for (int j = i; j < nums.length; j++) {
                if (hashMap.containsKey(target - nums[j])){
                    result.add(Arrays.asList(nums[i], nums[j], target - nums[j]));
                }
                hashMap.put(nums[j], nums[j]);
            }
        }

        return new ArrayList(result);
    }

    private static List threeSumsBruteForce(int[] nums) {
        Arrays.sort(nums);
        HashSet hashSet = new HashSet();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++ ) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        hashSet.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return new ArrayList(hashSet);
    }
}

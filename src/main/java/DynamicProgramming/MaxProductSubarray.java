package DynamicProgramming;

public class MaxProductSubarray {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4,-2};
        int res = dynamicProgramming(nums);
        System.out.println(res);
    }

    //Time O(n) Space O(1)
    private static int dynamicProgramming(int[] nums) {
        int ans = Integer.MIN_VALUE, max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(max, max * nums[i]);
            min = Math.min(min, min * nums[i]);
            ans = Math.max(ans, max);
        }
        return ans;
    }
}

package DynamicProgramming;

public class MaximumSubArray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int res = dynamicProgramming(nums);
        System.out.println(res);

    }

    //Time O(n) Space O(1)
    private static int dynamicProgramming(int[] nums) {
        int pre = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (pre > 0)
                pre = pre + nums[i];
            else
                pre = nums[i];
            max = Math.max(max, pre);
        }
        return max;
    }
}

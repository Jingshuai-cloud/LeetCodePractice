package Array;

import java.util.HashMap;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3,4,4};
        System.out.println(removeDuplicates2(nums));
        HashMap<Integer,Integer> hashMap = new HashMap();


    }

    //double pointer
    public static int removeDuplicates(int[] nums){
        int j = 0;
        if(nums.length == 0) return 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[j]){
                j++;
                nums[j] = nums[i];
            }
        }
        return j+1 ;
    }

    // count k
    public static int removeDuplicates2(int[] nums) {
        int count = 0;
        int len = nums.length;
        for (int i = 1; i< len; i++) {
            if (nums[i] == nums [i-1]) count++;
            else {
                nums[i-count] = nums[i];
            }
        }
        return len - count;
    }
}

package Array;

public class Practice {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3,4,4};
        System.out.println(removeDuplicates(nums));
    }

    private static int removeDuplicates(int[] nums) {
        int j = 0;
        for(int i = 1; i< nums.length; i++){
            if(nums[i] != nums[j]){
               j++;
               nums[j] = nums[i];
            }
        }
        return j+1;
    }

}

package Array;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0,1,0,2,4};
        int[] result = moveZeros2(nums);
        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
    }

    public static int[] moveZeros(int[] nums){
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[j] = nums[i];
                if(i != j){
                    nums[i] = 0;
                }
                j++;
            }
        }
        return nums;
    }
    //optimization
    public static int[] moveZeros2(int[] nums){
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                if(i > j){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j++] = temp;
                }
            }
        }
        return nums;
    }

}

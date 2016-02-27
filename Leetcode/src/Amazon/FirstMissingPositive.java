package Amazon;

public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        // put the element where it should be
        // 1 -> index 0
        // nums[i] --> nums[nums[i] - 1]
        if(nums == null || nums.length == 0){
            return 1;
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);    
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            if(i + 1 != nums[i]){
                return i + 1;
            }
        }
        return nums.length + 1;
    }
    
    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void main(String[] args){
    	int[] nums = {-1, 4, 2, 1, 9, 10};
    	firstMissingPositive(nums);
    }
}

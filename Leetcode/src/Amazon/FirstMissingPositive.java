package Amazon;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        // put the element where it should be
        // 1 -> index 0
        // nums[i] --> nums[nums[i] - 1]
        if(nums == null || nums.length == 0){
            return 1;
        }
        for(int i = 0; i < nums.length; i++){
            while(nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i] - 1]){
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
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

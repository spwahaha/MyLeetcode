package FB;

public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int posi = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i - 1]){
                nums[posi++] = nums[i];
            }
        }
        
        return posi;
    }
}

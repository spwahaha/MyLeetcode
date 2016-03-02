package FB;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int posi = 0;
        int i = 0;
        for(i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[posi++] = nums[i];
            }
        }
        
        for(; posi < nums.length; posi++){
            nums[posi] = 0;
        }
    }
}

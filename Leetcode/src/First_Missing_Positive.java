
public class First_Missing_Positive {
    public static int firstMissingPositive(int[] nums) {

        int n = nums.length;
        for(int i = 0; i < nums.length; i++){
            int cnt = 1000;
            while(nums[i] > 0 && nums[i] - 1 != i && nums[i] <= n && cnt > 0){
                swap(nums, nums[i] - 1, i);
                cnt--;
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0) return i + 1;
            if(nums[i] - 1 != i) return i + 1; 
        }
        return nums.length + 1;
    }
    
    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void main(String[] args){
    	int[] nums = {2, 1};
    	System.out.println(firstMissingPositive(nums));
    }
}

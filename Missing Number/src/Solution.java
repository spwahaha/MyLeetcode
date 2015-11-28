import java.util.Arrays;

public class Solution {
	 public int missingNumber(int[] nums) {
       Arrays.sort(nums);
       int i = 0;
       for(i=0;i<nums.length;i++){
           if(nums[i]!=i){
               return i;
           }
       }
       return nums.length;
   }
	 
	 public static void main(String[] args){
		 int[] nums = {0,1,3};
		 Solution so = new Solution();
		 System.out.println(so.missingNumber(nums));
	 }
	 
	 
}

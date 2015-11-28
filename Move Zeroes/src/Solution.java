
public class Solution {
    public void moveZeroes(int[] nums) {
    	int head = 0;
    	
    	for(int i = 0;i<nums.length;i++){
    		if(nums[i]==0){
    			// find the next non-zero entry and exchange it with the zero
    			for(int j = Math.max(head, i);j<nums.length;j++){
    				if(nums[j]!=0){
    					head = j;
    					break;
    				}
    			}
    			if(head!=0){
        			int temp = nums[i];
        			nums[i] = nums[head];
        			nums[head] = temp;
    			}

    		}
    	}
    }
    
    public static void main(String[] args){
    	int[] nums = {0,0,1};
    	Solution so = new Solution();
    	so.moveZeroes(nums);
    	for(int i = 0; i < nums.length; i++){
    		System.out.println(nums[i]);
    	}
    }
    
}

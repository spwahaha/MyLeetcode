import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
    	List<Integer> resul = new ArrayList();
    	if(nums==null||nums.length==0) return resul;
    	if(nums.length==1){
    		resul.add(nums[0]);
    		return resul;
    	}
    	// more voting algorithm
    	int m1 = nums[0];
    	int m2 = 0;
    	
    	int c1 = 1;
    	int c2 = 0;
    	
    	for(int i=1;i<nums.length;i++){
    		int x = nums[i];
    		if(x==m1) c1++;
    		else if(x == m2) c2++;
    		else if(c1==0){
    			m1 = x;
    			c1++;
    		}else if(c2==0){
    			m2 = x;
    			c2++;
    		}else{
    			c1--;
    			c2--;
    		}
    	}
    	
    	c1 = 0; c2 = 0;
    	for(int i=0;i<nums.length;i++){
    		if(m1==nums[i]) c1++;
    		else if(m2 == nums[i] ) c2++;
    	}
    	if(c1>nums.length/3) resul.add(m1);
    	if(c2>nums.length/3) resul.add(m2);
    	
    	return resul;
    }
    
    public static void main(String[] args){
    	int[] nums = {0,1,2,3,4,4,4,4,4};
    	Solution so = new Solution();
    	System.out.println(so.majorityElement(nums));
    }
    
}

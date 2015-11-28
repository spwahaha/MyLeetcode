import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums){
    	if(nums.length==0) return new ArrayList<String>();
    	List<String> result= new ArrayList<String>();
    	if(nums.length==1){
    		result.add(nums[0]+"");
    		return result;
    	}
    	int start = nums[0];
    	int end = 0;
    	for(int i=0;i<nums.length-1;i++){
    		if(nums[i+1]!=nums[i]+1){
    			end = nums[i];
    			if(end-start>0){
        			result.add(start+"->"+end);
        		}else{
        			result.add(""+start);
        		}
    			start = nums[i+1];
    		}
    	}
    	end = nums[nums.length-1];
    	if(start == end){
    		result.add(""+start);
    	}else{
    		result.add(start+"->"+end);
    	}
    	return result;
    }
    
    public static void main(String[] args){
    	Solution so = new Solution();
    	int[] nums = {0,1,2,3,5,6,8,9};
    	System.out.println(so.summaryRanges(nums));
    }
}

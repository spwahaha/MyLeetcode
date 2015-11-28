import java.util.ArrayList;
import java.util.Hashtable;

public class Solution {
    public static int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < nums.length;i++){
        	if(list.contains((Integer)nums[i]))
        		list.remove((Integer)nums[i]);
        	else list.add((Integer)nums[i]);
        }
        res[0] = list.get(0);
        res[1] = list.get(1);
        return res;
    }
    
    public static void main(String[] args){
    	int[] nums1 = {0,0,1,3,3,4,5,5};
    	int[] res = singleNumber(nums1);
    	for(int i:res)
    		System.out.println(i);
    }
}

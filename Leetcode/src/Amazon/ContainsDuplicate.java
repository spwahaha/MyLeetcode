package Amazon;

import java.util.HashSet;
import java.util.TreeSet;

public class ContainsDuplicate {
	
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int num : nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }
	
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k){
                set.remove(nums[i - k - 1]);
            }
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
    
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length == 0 || k < 0 || t < 0) return false;
        TreeSet<Long> set = new TreeSet<Long>();
        for(int i = 0; i < nums.length; i++){
            if(i > k){
                set.remove((long)nums[i - (k + 1)]);
            }
            Long higher = set.ceiling((long)nums[i]);
            Long lower = set.floor((long)nums[i]);
            if(higher != null && higher - nums[i] <= t){
                return true;
            }
            if(lower != null && nums[i] - lower <= t){
                return true;
            }
            set.add((long)nums[i]);
        }
        return false;
    }
}



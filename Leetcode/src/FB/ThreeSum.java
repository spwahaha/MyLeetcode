package FB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3){
            return res;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(i != 0 && nums[i] == nums[i - 1]){
                 continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                if(left != i + 1 && nums[left] == nums[left - 1]){
                    left++;
                }else if(right != nums.length - 1 && nums[right] == nums[right + 1]){
                    right--;
                }else{
                    int sum = nums[i] + nums[left] + nums[right];
                    if(sum < 0){
                        left++;
                    }else if(sum > 0){
                        right--;
                    }else{
                        List<Integer> list=  new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);
                        left++;
                    }
                }
            }
        }
        return res;
    }
}

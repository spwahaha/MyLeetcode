package FB;

import java.util.HashMap;
import java.util.Map;

public class TaskSchedule {
	// order out put time slot
	public static int taskSchedule(int[] nums, int interval) {
        if(nums == null || nums.length == 0){
        	return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int time = 0;
        for(int num : nums){
        	if(!map.containsKey(num) || map.get(num) <= time){
        		time++;
        	}else{
        		time = map.get(num);
        	}
        	map.put(num, time + interval + 1);
        }
        return time;
    }
    
	// order, output schedule
    public static String taskSchedule2(int[] nums, int interval) {
        if(nums == null || nums.length == 0){
        	return "";
        }
        StringBuilder sb = new StringBuilder();
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int time = 0;
        for(int num : nums){
        	if(!map.containsKey(num) || map.get(num) <= time){
        		sb.append(""+num);
        		time++;
        	}else{
        		time++;
        		int diff = map.get(num) - time;
        		String space = "";
        		for(; time < map.get(num); time++){
        			space +="_";
        		}
        		time = map.get(num);
        		sb.append(space).append(num);
        	}
        	map.put(num, time + interval + 1);
        }
        return sb.toString();
    }
    
    /*
     * task unorder and output the time slot
     * (1): 5 4 _ _ _ 5 4 _ _ _ 5 4 _ _ _ 5 4 empty slot cann't be filled all
     * 		time = (interval + 1) * (maxFre - 1) + countOfMax
     * (2): 5 4 3 2 1 5 4 3 2 1 5 4 6 9 0 5 4 all the empty slot can be filled
     * 		time = length of the array
     * 	 
     */
    public static int taskScheduleUnorder(int[] nums, int interval) {
    	if(nums == null || nums.length == 0){
    		return 0;
    	}
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	int maxFre = 0;
    	int countOfMax = 0;
    	for(int num : nums){
    		map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
    		if(maxFre == map.get(num)){
    			countOfMax++;
    		}else if(maxFre < map.get(num)){
    			maxFre = map.get(num);
    			countOfMax = 1;
    		}
    	}
    	return Math.max(nums.length, (interval + 1) * (maxFre - 1) + countOfMax);
    }
    
    
    
    
    public static void main(String[] args){
    	int[] nums = {1,2,3,1,2,4};
    	int[] nums2 = {5,4,3,2,1,6,5,4,3,2,1,6,5,4,5,6,4,11,12};
    	System.out.println(taskSchedule(nums,3));
    	System.out.println(taskScheduleUnorder(nums2, 3));
    }
}

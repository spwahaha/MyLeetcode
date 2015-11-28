import java.util.HashMap;

public class Solution2 {
    public static int numTrees(int n) {
    	// if withour a hashmap, then the time complexity is high
    	// so, we need to a hashtable to get the numTrees(n) immediately 
    	// instead of recursing to get it.
    	// However, also kind of like the dp,  Totally dp
    	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    	map.put(0, 1);
    	map.put(1, 1);
    	helper(n,map);
    	return map.get(n);

    }
    
    private static int helper(int n, HashMap<Integer, Integer> map) {
		// TODO Auto-generated method stub
    	if(map.containsKey(n))
    		return map.get(n);
//    	if(n<=1) return 1;
    	int left = 0;
    	int right = 0;
    	int sum = 0;
    	for(int i = 1; i <= n;i++){
    		left = helper(i-1,map);
    		right = helper(n - i,map);
    		sum += left * right;
    	}
    	map.put(n, sum);
    	return sum;
	}

	public static void main(String[] args){
    	System.out.print(numTrees(4));
    }
}

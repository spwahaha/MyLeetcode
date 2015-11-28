
public class Solution {
    public int climbStairs(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int[] ways = new int[n];
        ways[0] = 1;
        ways[1] = 2;
        for(int i = 2; i < n; i++){
        	ways[i] = ways[i-1] + ways[i-2];
        }
        	
        return ways[n-1];
    }
    
	public static void main(String[] args){
		Solution so = new Solution();
		System.out.println(so.climbStairs(5));
	}
}

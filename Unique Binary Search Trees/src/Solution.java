
public class Solution {
    public static int numTrees(int n) {
    	if(n == 1) return 1;
    	// the top node can be 1~n
    	// the two children node can be 1~i, i+1~n
    	// for each node, the possible tree can be 
    	// G[n] = G[0]*G[n-1]+...+G[i]*G[n-i-1] + G[i+1]*G[n-i-2]+....+G[n-1]*G[0]
        int[] res = new int[n+1];
        res[0] = 1;
        res[1] = 1;
        for(int i = 2; i <= n; i++){
        	for(int j = 0; j < i; j++)
        		res[i] += res[j] * res[i-j-1];
        }
        return res[n];
    }
    
    public static void main(String[] args){
    	System.out.print(numTrees(4));
    }
}

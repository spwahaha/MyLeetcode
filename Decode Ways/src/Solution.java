
public class Solution {
	public static int numDecodings(String s) {
		if(s.length()==0||s.charAt(0)=='0') return 0;
		int[] dp = new int[s.length()+1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i =2; i < s.length()+1;i++){
			int num = Integer.parseInt(s.substring(i-2,i));
			int twoStepBehind = (num<=26&&num>9)?dp[i-2]:0;
			int oneStepBehind = (Integer.parseInt(s.substring(i-1,i))!=0)?dp[i-1]:0;
			dp[i] = oneStepBehind+twoStepBehind;
		}
        
        return dp[s.length()];
    }
	
	
	public static void main(String[] args){
		System.out.println(numDecodings("1231037"));
	}
}

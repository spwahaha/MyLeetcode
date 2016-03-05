package FB;

public class DecodeWays {
	/*
	 * Using DP, 123 based on ways(1) + ways(12)
	 * ways[i] = ways[i - 1] + ways[i - 2] with specific situation
	 */
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0'){
            return 0;
        }
        int[] ways = new int[s.length() + 1];
        ways[0] = 1;
        ways[1] = 1;
        for(int i = 2; i < s.length() + 1; i++){
            char c1 = s.charAt(i - 1);
            int val1 = c1 == '0' ? 0 : ways[i - 1];
            char c2 = s.charAt(i - 2);
            int val2 = ways[i - 2];
            if(c2 == '0' || c2 > '2' || (c2 == '2' && c1 > '6')){
                val2 = 0;
            }
            ways[i] = val1 + val2;
        }
        return ways[s.length()];
    }
}

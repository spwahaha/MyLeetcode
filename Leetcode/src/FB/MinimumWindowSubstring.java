package FB;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        int[] requires = new int[256];
        boolean[] has = new boolean[256];
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            has[c] = true;
            requires[c]++;
        }
        int min = Integer.MAX_VALUE;
        String res = "";
        int i = 0;
        int j = 0;
        int count = t.length();
        while(i <= s.length() && j < s.length()){
            if(count > 0){
                if(i == s.length()){
                    break;
                }
                char c = s.charAt(i);
                requires[c]--;
                if(has[c] && requires[c] >= 0){
                    count--;
                }
                i++;
            }else{
                if(i - j< min){
                    min = i - j;
                    res = s.substring(j,i);
                }
                char c = s.charAt(j);
                requires[c]++;
                if(has[c] && requires[c] > 0){
                    count++;
                }
                j++;
            }
        }
        return res;
    }
	
	public static void main(String[] args){
		System.out.println(minWindow("a","a"));
	}
}

package Zappos;

import java.util.HashSet;

public class countPalindrome {
	public static int countPal(String s){
		HashSet<String> set = new HashSet<String>();
		for(int i = 0; i < s.length(); i++){
			for(int j = i + 1; j <= s.length(); j++){
				String sub = s.substring(i,j);
				if(isPalindrome(sub)){
					set.add(sub);
					System.out.println(sub);
				}
			}
		}
		return set.size();
	}
	
    static int palindrome(String str) {
        if(str == null) return 0;
        HashSet<String> set = new HashSet<String>();
        HashSet<String> visited = new HashSet<String>();
        int cnt = 0;
        for(int i = 0; i < str.length(); i++){
            for(int j = 0; (i - j) >= 0 && (i + j) < str.length();j++){
                if(str.charAt(i - j) == str.charAt(i + j)){
                    set.add(str.substring(i - j, i + j + 1));
                }else{
                    break;
                }
            }
            for(int j = 1; (i - j + 1) >= 0 && (i + j) < str.length(); j++){
                if(str.charAt(i - j + 1) == str.charAt(i + j)){
                    set.add(str.substring(i - j + 1, i + j + 1));
                }else{
                    break;
                }
            }
        }
        return set.size();
    }
	
	private static boolean isPalindrome(String s){
		StringBuilder sb = new StringBuilder(s);
		String l2r = sb.toString();
		String r2l = sb.reverse().toString();
		return l2r.equals(r2l);
	}
	
	public static void main(String[] args){
		System.out.println(palindrome("aabaa"));		
	}
}

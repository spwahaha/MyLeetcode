package arraysAndStrings;

import java.util.Arrays;

public class CheckPermutation {
	public static boolean checkPermutation(String s1, String s2){
		if(s1.length()!=s2.length()) return false;
		s1 = sort(s1);
		s2 = sort(s2);
		return s1.equals(s2);
	}
	
	private static String sort(String s){
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	
	public static boolean checkPermutation_1(String s1, String s2){
		if(s1.length()!=s2.length()) return false;
		// check all the character has the same count
		int[] content = new int[128];
		for(int i = 0; i < s1.length(); i++){
			char c = s1.charAt(i);
			content[c]++;
		}
		
		for(int i = 0; i < s2.length(); i++){
			char c = s2.charAt(i);
			content[c]--;
			if(content[c] < 0)
				return false;
		}
		
		return true;
	}
	
	
	public static void main(String[] args){
		System.out.println(checkPermutation("abc","cba"));
		System.out.println(checkPermutation(" abc","abc"));
		System.out.println(checkPermutation("abc","bbc"));
		
		System.out.println(checkPermutation_1("abc","cba"));
		System.out.println(checkPermutation_1(" abc","abc"));
		System.out.println(checkPermutation_1("abc","bbc"));
		System.out.println(checkPermutation_1("aac","bbc"));
	}
}

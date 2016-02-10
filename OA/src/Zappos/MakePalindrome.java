package Zappos;

public class MakePalindrome {
	public static int transfer(String str){
		int res = 0;
		int left = 0;
		int right = str.length() - 1;
		while(left <= right){
			char c1 = str.charAt(left);
			char c2 = str.charAt(right);
			res += Math.abs(c1 - c2);
			left++;
			right--;
		}
		
		return res;
	}
	
	public static void main(String[] args){
		System.out.println(transfer("abcd"));
	}
}

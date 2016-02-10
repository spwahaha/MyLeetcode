
public class PalindromeString {
	static int frontIndex = 0;
	public static boolean isPalindrome1(String s){
		return isPalindrome1(s, 0);
	}
	
	private static boolean isPalindrome1(String s, int index){
		if(s == null || s.length() == 0){
			return false;
		}
		if(index == s.length() - 1){
			char front = s.charAt(frontIndex);
			char back = s.charAt(s.length() - 1);
			return front == back;
		}
		
		boolean othersPalindrome = isPalindrome1(s, index + 1);
		if(frontIndex >= s.length() / 2) return othersPalindrome;
		frontIndex++;
		if(!othersPalindrome) return false;
		else{
			return s.charAt(frontIndex) == s.charAt(index);
		}
	}
	
	public static boolean isPalindrome2(String s){
		int i = 0;
		int j = s.length() - 1;
		while(i < j){
			char front = s.charAt(i++);
			char back = s.charAt(j--);
			if(front != back){
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPalindrome3(String s){
		StringBuilder sb = new StringBuilder(s);
		return sb.toString().equals(sb.reverse().toString());
	} 
	
	public static void main(String[] args){
		String s = "abbs";
		System.out.println(isPalindrome1(s));
		System.out.println(isPalindrome2(s));
		System.out.println(isPalindrome3(s));
	}
}

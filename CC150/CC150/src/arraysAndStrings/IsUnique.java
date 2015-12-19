package arraysAndStrings;

public class IsUnique {
	public static boolean isUnique(String s){
		// Assume that it's ascii code, whose length is 128
		if(s.length() > 128) return false;
		boolean[] charSet = new boolean[128];
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(charSet[c]){
				return false;
			}
			charSet[c] = true;
		}
		return true;
	}
	
	public static void main(String[] args){
		System.out.println(isUnique("abcdefg"));
		System.out.println(isUnique("  "));
		System.out.println(isUnique(" aa"));
	}
}

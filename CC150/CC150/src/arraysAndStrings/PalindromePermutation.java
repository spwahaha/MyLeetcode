package arraysAndStrings;

public class PalindromePermutation {
	// we should clear this is case sensitive or insensitive
	// we implement case insensitive
	public static boolean isPalPer(String s){
		int cnt = 0;
		int[] table = new int['z'-'a'+1];
		for(int i = 0; i < s.length(); i++){
			int num = getCharNumber(s.charAt(i));
			if(num!=-1){
				table[num]++;
				if(table[num] % 2 == 1){
					cnt++;
				}else{
					cnt--;
				}
			}
		}
		
		return cnt <= 1;
	}
	
	private static int getCharNumber(char c){
		// case insensitive, so 'A' 'a' should be the same number
		if(c <= 'z' && c >='a'){
			return c - 'a';
		}
		if(c <= 'Z' && c >= 'A'){
			return c - 'A';
		}
		return -1;
	}
	
	public static void main(String[] args){
		System.out.println(isPalPer("Tact Coa"));
		System.out.println(isPalPer("Tacc coa"));
	}
}

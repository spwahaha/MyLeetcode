
public class LongestCommonSequence {
	public static String maxCommonLenght(String s1, String s2){
		int max = 0;
		int posi = 0;
		int[][] f = new int[s1.length() + 1][s2.length() + 1];
		for(int i = 1; i <= s1.length(); i++){
			for(int j = 1; j <= s2.length(); j++){
				char c1 = s1.charAt(i - 1);
				char c2 = s2.charAt(j - 1);
				if(c1 == c2){
					f[i][j] = f[i - 1][j - 1] + 1;
					if(f[i][j] > max){
						max = Math.max(max, f[i][j]);
						posi = i;
					}
				}else{
					f[i][j] = 0;
				}
			}
		}
		return s1.substring(posi - max, posi);
//		return max;
	}
	
	public static void main(String[] args){
		System.out.println(maxCommonLenght("abcde", "bacab"));
	}
}

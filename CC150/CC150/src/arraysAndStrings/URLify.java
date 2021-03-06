package arraysAndStrings;

public class URLify {
	public static String urlify(String s, int n){
		
		int cnt = 0;
		for(int i = 0; i < n; i++){
			if(s.charAt(i) == ' '){
				cnt++;
			}
		}
		int newLength = n + 2 * cnt;
		char[] content = new char[newLength];
		for(int i = n-1; i >=0; i--){
			char c = s.charAt(i);
			if(c == ' '){
				content[newLength-1] = '0';
				content[newLength-2] = '2';
				content[newLength-3] = '%';
				newLength -=3;
			}else{
				content[newLength-1] = c;
				newLength--;
			}
		}
		
		return new String(content);
		
	}
	
	public static void main(String[] args){
		System.out.println(urlify("Mr John Smith  ", 13));
	}
}

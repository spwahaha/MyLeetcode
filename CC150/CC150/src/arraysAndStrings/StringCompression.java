package arraysAndStrings;

public class StringCompression {
	
	public static String StrCompression(String str){
//		int finalLength = getFinalLength(str);
//		if(finalLength >= str.length()) return str;
		StringBuilder sb = new StringBuilder();
		char c = str.charAt(0);
		int cnt = 1;
		for(int i = 1; i < str.length(); i++){
			char next = str.charAt(i);
			if(c==next){
				cnt++;
			}else{
				sb.append(c);
				sb.append(cnt);
				c = next;
				cnt=1;
			}
		}
		
		sb.append(c);
		sb.append(cnt);
		
		return sb.toString().length() < str.length() ? sb.toString():str;
//		return sb.toString();
	}

	
	public static void main(String[] args){
		System.out.println(StrCompression("aabcccccaaa"));
	}
	
}

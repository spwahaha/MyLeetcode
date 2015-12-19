import java.io.BufferedReader;

public class Problems {
	
	public static void main(String[] args){
		char[] str = {'A','A','C','D','E','A','A'};
		removeDuplicates(str);
		System.out.println();
	}
	
	public static boolean isUniqueChars(String str){
		boolean[] check = new boolean[256];
		for(int i = 0;i < str.length();i++){
			int val = str.charAt(i);
			if(check[val]){
				return false;
			}
			check[val] = true;;
		}
		
		return true;
	}
	
	public static void removeDuplicates(char[] str) {
		if(str==null){
			return;
		}
		int len = str.length;
		if(len<2) return;
		
		int tail = 1;
		
		for(int i = 1; i<len; i++){
			int j;
			for(j = 0; j<tail;j++){
				if(str[i]==str[j]) break;
			}
			if (j == tail) {
				str[tail] = str[i];
				tail++;
			}
		}
		str[tail] = 0;
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
	}

}


public class Reverse_Words_in_a_String {
	public static String reverse(String s){
		if(s==null) return s;
		System.out.println(s.length());
		String[] strs = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for(int i = strs.length-1; i >= 0; i--){
			if(strs[i].equals("")) continue;
			sb.append(strs[i]);
			sb.append(" ");
		}
		String res = sb.toString().trim();
		System.out.println(res.length());
		return res;
	}
	
	public static void main(String[] args){
		System.out.println(reverseWords("  the "));
	}
	
	
	
	 public static String reverseWords(String s) {
	        if(s==null) return s;
	        return reverse(s.toCharArray()).trim();
	    }
	    
	    private static String reverse(char[] words){
	        for(int i = 0; i < words.length/2; i++){
	            char temp = words[i];
	            words[i] = words[words.length-i-1];
	            words[words.length-i-1] = temp;
	        }
	        int i = 0;
	        int j = 0;
	        while(true){
	            while(i<words.length && words[i]==' ') i++;
	            j=i;
	            while(j<words.length && words[j]!=' ') j++;
	            j--;
	            if(i>=words.length-1) break;
	            reverse(words, i,j);
	            i=j+1;
	        }
	        int posi = 1;
	        for(i = 1; i < words.length; i++){
	            if(words[i]==words[posi-1]&&words[posi-1]==' ') continue;
	            words[posi] = words[i];
	            posi++;
	        }
	        return new String(words, 0, posi);
	    }
	    
	    private static void reverse(char[] words, int l, int h){
	        for(int i = 0; i <=(h-l)/2; i++){
	            char temp = words[l+i];
	            words[l+i] = words[h-i];
	            words[h-i] = temp;
	        }
	    }
}

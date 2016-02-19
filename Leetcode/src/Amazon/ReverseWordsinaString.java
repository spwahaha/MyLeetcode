package Amazon;

public class ReverseWordsinaString {
	public String reverseWords(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        return reverse(s.toCharArray());
    }
    
    private String reverse(char[] words){
        reverse(words, 0, words.length - 1);
        int i = 0;
        int j = 0;
        while(true){
            while(i < words.length && words[i] == ' '){
                i++;
            }
            j = i;
            while(j < words.length && words[j] != ' '){
                j++;
            }
            j--;
            System.out.println(i);
            if(i >= words.length - 1){
                break;
            }
            reverse(words, i, j);
            i = j + 1;
        }
        
        int posi = 1;
        for(i = 1; i < words.length; i++){
            if(words[posi - 1] == ' ' && words[i] == ' '){
                continue;
            }
            words[posi] = words[i];
            posi++;
        }
        
        String res = new String(words);
        return res.substring(0, posi).trim();
    }
    
    private void reverse(char[] words, int i, int j){
        while(i < j){
            char temp = words[i];
            words[i] = words[j];
            words[j] = temp;
            i++;
            j--;
        }
    }
    
    
    
    public String reverseWords2(String s) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = strs.length - 1; i >= 0; i--){
            String str = strs[i];
            if(str != null && str.length() > 0){
                sb.append(" ");
                sb.append(str);
            }
        }
        return sb.toString().trim();
    }
}

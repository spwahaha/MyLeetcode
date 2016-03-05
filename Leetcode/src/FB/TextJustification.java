package FB;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        if(words == null || words.length == 0){
            return res;
        }
        int l = 0;
        int k = 0;
        for(int i = 0; i < words.length; i += k){
            k = 0; 
            l = 0;
            for(; (i + k < words.length) && (l + words[i + k].length()) <= (maxWidth - k); k++){
                l += words[i + k].length();
            }
            String temp = words[i];
            for(int j = 0; j < k - 1; j++){
                if(i + k >= words.length) temp +=" ";
                else{
                    String space = "";
                    for(int p = 0; p < (maxWidth - l) / (k - 1); p++){
                        space += " ";
                    }
                    if(j < (maxWidth - l) % (k - 1)){
                        space += " ";
                    }
                    temp += space;
                }
                temp += words[i + j + 1];
            }
            String space = "";
            for(int p = 0; p < maxWidth - temp.length(); p++){
                space += " ";
            }
            temp += space;
            res.add(temp);
        }
        return res;
        
    }
	
	public static void main(String[] args){
		String[] strs = {"This", "is", "an", "example", "of", "text", "justification."};
		String[] strs2 = {""};
		String[] strs3 = {"What","must","be","shall","be."};
		List<String> list = fullJustify(strs3, 12); 
		for(String str : list)
			System.out.println(str);
	}
}

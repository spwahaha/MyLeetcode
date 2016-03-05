package FB;

public class CountandSay {
    public String countAndSay(int n) {
        if(n < 1) return "";
        String s = "1";
        for(int i = 1; i < n; i++){
            int index = 1;
            char c = s.charAt(0);
            StringBuilder sb = new StringBuilder();
            for(int j = 1; j < s.length(); j++){
                if(s.charAt(j) != s.charAt(j - 1)){
                    sb.append(index);
                    sb.append(c);
                    index = 1;
                    c = s.charAt(j);
                }else{
                    index++;
                }
            }
            sb.append(index);
            sb.append(c);
            s =sb.toString();
        }
        return s;
    }
}

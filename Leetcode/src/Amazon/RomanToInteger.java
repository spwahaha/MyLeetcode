package Amazon;

import java.util.HashMap;

public class RomanToInteger {
    public int romanToInt(String s) {
        if(s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int sum = map.get(s.charAt(s.length() - 1));
        for(int i = s.length() - 2; i >= 0; i--){
            int behind = map.get(s.charAt(i + 1));
            int now = map.get(s.charAt(i));
            if(behind <= now){
                sum += now;
            }else{
                sum -= now;
            }
        }
        
        return sum;
    }
}

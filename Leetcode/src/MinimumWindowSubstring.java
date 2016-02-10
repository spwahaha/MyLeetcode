import java.util.HashMap;
import java.util.HashSet;

public class MinimumWindowSubstring {
	public static String minWindow(String s, String t) {
        int minLen = Integer.MAX_VALUE;
        String minString = "";
        int p1 = 0;
        int p2 = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        HashMap<Character, Integer> standard = new HashMap<Character, Integer>();
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            int times = 1;
            if(standard.containsKey(c)){
                times = standard.get(c) + 1;
            }
            standard.put(c, times);
        }
        HashSet<Character> set = new HashSet<Character>();
        HashMap<Character,Integer> reminder = new HashMap<Character,Integer>();
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            set.add(c);
            int times = reminder.containsKey(c) ? reminder.get(c) : 0;
            times++;
            reminder.put(c, times);
        }
        while(p1 < s.length()){
            char c = s.charAt(p1);
            if(set.contains(c)){
                int times = (map.get(c) == null ? 0 : map.get(c)) + 1;
                map.put(c, times);
                if(reminder.containsKey(c)){
                    times = reminder.get(c);
                    if(times == 1) reminder.remove(c);
                    else reminder.put(c, times - 1);
                }
            }
            c = s.charAt(p2);
            int times = map.get(c) == null ? 0 : map.get(c);
            while((!set.contains(c) || (standard.containsKey(c) && (times > standard.get(c)))) && p2 < p1){
                if(times > 1){
                    map.put(c, times - 1);
                }
                p2++;
                c = s.charAt(p2);
                times = map.get(c) == null ? 0 : map.get(c);
            }
            if(reminder.size() == 0){
                if(p1 - p2 < minLen){
                    minLen = p1 - p2 + 1;
                    minString = s.substring(p2, p1 + 1);
                }
            }
            p1++;
        }
        return minString;
    }
	
	public static void main(String[] args){
		System.out.println(minWindow("aa", "aa"));
	}
}

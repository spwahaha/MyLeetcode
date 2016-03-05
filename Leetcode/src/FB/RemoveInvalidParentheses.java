package FB;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class RemoveInvalidParentheses {
	
	//DFS
	public static List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null){
            return res;
        }
        int parNum = getParNum(s);
        helper(res, 0, 0, s, "", parNum, new HashSet<String>());
        return res;
    }
    
    private static int getParNum(String s){
        int cnt = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                left++;
            }else if(c == ')'){
                if(left > 0){
                    left--;
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    
    private static void helper(List<String> res, int left, int right, String s, String cur, int parNum, HashSet<String> set){
        if(s.equals("")){
            if(left == right && left == parNum && !set.contains(cur)){
                res.add(cur);
                set.add(cur);
            }
            return;
        }
        
        char c = s.charAt(0);
        if(c == '('){
            helper(res, left + 1, right, s.substring(1), cur + "(", parNum, set);
            helper(res, left, right, s.substring(1), cur, parNum,set);
        }else if(c == ')'){
            if(left > right){
                helper(res, left, right + 1, s.substring(1), cur + ")", parNum, set);
            }
            helper(res, left, right, s.substring(1), cur, parNum, set);
        }else{
            helper(res, left, right, s.substring(1), cur + c, parNum, set);
        }
    }
    
    
    //BFS
    public static List<String> removeInvalidParentheses2(String s) {
        List<String> res = new ArrayList<String>();
        Queue<String> q = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        q.add(s);
        visited.add(s);
        boolean found = false;
        while(!q.isEmpty()){
            String cur = q.poll();
            if(isValid(cur)){
                res.add(cur);
                found = true;
            }
            if(found){
                continue;
            }
            
            for(int i = 0; i < cur.length(); i++){
                char c = cur.charAt(i);
                if(c != '(' && c != ')'){
                    continue;
                }
                String temp = cur.substring(0,i) + cur.substring(i + 1, cur.length());
                if(!visited.contains(temp)){
                    q.add(temp);
                    visited.add(temp);
                }
            }
        }
        
        return res;
    }
    
    private static boolean isValid(String s){
        int left = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                left++;
            }else if(c == ')'){
                if(left == 0) return false;
                left--;
            }
        }
        return left==0;
    }
    
    public static void main(String[] args){
    	System.out.println(removeInvalidParentheses(")(f"));
    	System.out.println(removeInvalidParentheses2(")(f"));
    }
}

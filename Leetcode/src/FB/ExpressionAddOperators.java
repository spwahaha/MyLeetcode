package FB;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ExpressionAddOperators {
    static class Pair{
        String expr;
        long val;
        public Pair(String expr, long val){
            this.expr = expr;
            this.val = val;
        }
    }
    // not accepted solution
    public static List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        addHelper(res, num, target, 0, new HashSet<String>());
        return res;
    }
    
    private static List<Pair> addHelper(List<String> res, String num, long target, int level, HashSet<String> visited){
//        System.out.println(num);
    	List<Pair> list = new ArrayList<Pair>();
        if(num.length() == 1){
        	list.add(new Pair(num, Long.parseLong(num)));
            return list;
        }else{
            for(int i = 1; i < num.length(); i++){
                String left = num.substring(0, i);
                String right = num.substring(i, num.length());
                List<Pair> val1s = addHelper(res, left, target, level + 1, visited);
                List<Pair> val2s = addHelper(res, right, target, level + 1, visited);
                for(Pair val1 : val1s){
                    for(Pair val2 : val2s){
                        Pair[] pairs = new Pair[3];
                        if(val1.val + val2.val <= Integer.MAX_VALUE){
                        	pairs[0] = new Pair(val1.expr + "+" + val2.expr, val1.val + val2.val);
                        }
                        if(val1.val - val2.val >= Integer.MIN_VALUE){
                        	pairs[1] = new Pair(val1.expr + "-" + val2.expr, val1.val - val2.val);
                        }
                        if(Long.parseLong(num) <= Integer.MAX_VALUE){
                        	if(num.length() < 2 || (num.charAt(0) != '0')){
                        		pairs[2] = new Pair(num, Long.parseLong(num));
                        	}
                        }
                        if(level == 0){
                        	for(Pair p : pairs){
                        		if(p != null && p.val == target && !visited.contains(p.expr)){
                        			res.add(p.expr);
                        			visited.add(p.expr);
                        		}
                        			
                        	}
                        }
                        for(Pair p : pairs){
                        	if(p != null){
                        		list.add(p);
                        	}
                        }
                    }  
                }
            }
            return list;
        }
    }
    
    //accepted solution
    public static List<String> addOperators2(String num, int target) {
    	List<String> res = new ArrayList<String>();
    	dfs(res, num, "", 0, 0, target);
    	return res;
    }
    
    private static void dfs(List<String> res, String num, String sofar, long last, long cur, int target){
    	if(num.length() == 0){
    		if(cur == target){
    			res.add(sofar);
    		}
    		return;
    	}
    	
    	for(int i = 1; i <= num.length(); i++){
    		String valS = num.substring(0, i);
    		if(valS.length() > 1 && valS.charAt(0) == '0'){
    			continue;
    		}
    		long val = Long.parseLong(valS);
    		if(val > Integer.MAX_VALUE || val < 0){
    			continue;
    		}
    		if(sofar.length() > 0){
        		dfs(res, num.substring(i), sofar + "+" + val, val, cur + val, target);
        		dfs(res, num.substring(i), sofar + "-" + val, -val, cur - val, target);
        		dfs(res, num.substring(i), sofar + "*" + val, last * val, (cur - last) + (last*val), target);    			
    		}else{
    			dfs(res, num.substring(i), ""+val, val, val,target);
    		}	
    	}
    }

    
    
    
    
    public static void main(String[] args){
    	System.out.println(addOperators2("232", 8));
    	System.out.println(addOperators2("123", 6));
    	System.out.println(addOperators2("105", 5));
    	System.out.println(addOperators2("00", 0));
    	System.out.println(addOperators2("3456237490", 9191));
    }
}

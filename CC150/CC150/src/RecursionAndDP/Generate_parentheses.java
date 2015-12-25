package RecursionAndDP;

import java.util.ArrayList;
import java.util.List;

public class Generate_parentheses {
	public static List<String> generateParentheses(int n){
		List<String> res = new ArrayList<String>();
		generate(res, n, n, "");
		return res;
	}
	
	private static void generate(List<String> res, int left, int right, String temp){
		if(left==0 && right==0){
			res.add(temp);
			return;
		}
		if(left > right){
			return;
		}
		
		if(left > 0){
			generate(res, left-1, right, temp+"(");
		}
		
		if(right > 0){
			generate(res, left, right -1, temp+")");
		}
		
	}
	
	public static void main(String[] args){
		System.out.println(generateParentheses(3));
	}
}

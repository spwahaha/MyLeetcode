package Medium;

import java.util.ArrayList;
import java.util.List;

public class Generat_Parentheses {
	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
	    generate(res, n, n, "");
	    return res;
	}
	
	private static void generate(List<String> res, int left, int right, String temp){
		System.out.println(temp);
		if(left == 0&& right ==0){
			res.add(temp);
			return;
		}
		if(left > right){
			return;
		}
		System.out.println(temp);
		if(left > 0){
			generate(res, left -1, right, temp+"(");
		}
		System.out.println(temp);
		if(right >0){
			generate(res, left, right-1, temp+")");
		}
		System.out.println(temp);
//		System.out.println("left: " + (3 - left) + "right: " + (3- right));


		
	}
	
	public static void main(String[] args){
		System.out.println(generateParenthesis(3));
		}
}

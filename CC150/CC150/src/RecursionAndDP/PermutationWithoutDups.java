package RecursionAndDP;

import java.util.ArrayList;

public class PermutationWithoutDups {
	/**
	 * My own solution, backtracking method and use contains to 
	 * get rid of the duplicates
	 * @param str
	 * @return
	 */
	public static ArrayList<String> getPerms(String str){
		ArrayList<String> res = new ArrayList<String>();
		helper(res, str,"");
		return res;
	}
	
	private static void helper(ArrayList<String> res, String str, String temp){
		if(temp.length() == str.length()){
			res.add(temp);
			return;
		}
		
		for(int i = 0; i < str.length(); i++){
			if(temp.contains(""+str.charAt(i))) continue;
			helper(res, str, temp + str.charAt(i));
		}
	}
	
	public static ArrayList<String> getPerms2(String str){
		ArrayList<String> res = new ArrayList<String>();
		helper2(res, "", str);
		return res;
	}
	
	
	private static void helper2(ArrayList<String> res, String prefix, String reminder) {
		// TODO Auto-generated method stub
		if(reminder.length() == 0) {
			res.add(prefix);
			return;
		}
		
		for(int i = 0; i < reminder.length(); i++){
			String before = reminder.substring(0,i);
			String after = reminder.substring(i+1, reminder.length());
			helper2(res, prefix+reminder.charAt(i), before+after);
		}
	}

	public static void main(String[] args){
		System.out.println(getPerms("abc"));
	}
}	

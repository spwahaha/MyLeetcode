package arraysAndStrings;

public class StringRotation {
	public static boolean isRotation(String s1, String s2){
	if(s1==null || s2 == null || s1.length()!=s2.length()) 
		return false;
	
		s1 = s1 + s1;
		return s1.contains(s2);
	}
	
	public static void main(String[] args){
		System.out.println(isRotation("waterbottle", "erbottlewat"));
	}
}

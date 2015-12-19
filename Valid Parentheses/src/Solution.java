import java.util.Stack;

public class Solution {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
        	if(stack.isEmpty()){
        		stack.push(s.charAt(i));
        	}else{
            	Character peek = stack.peek();
            	if(valid(peek,s.charAt(i))){
            		stack.pop();
            	}else{
            		stack.push(s.charAt(i));
            	}
        	}
        }
        return stack.isEmpty();
    }

	private static boolean valid(Character one, char two) {
		// TODO Auto-generated method stub
		if((one=='{'&&two=='}')||(one=='('&&two==')')
				||(one=='['&&two==']'))
			return true;
		return false;
	}
	
	public static void main(String[] args){
		assert isValid("()()()")==true;
		assert isValid("()[]{}")==false;
		assert isValid("([)]") == false;
		assert isValid("(]") == false;
		assert isValid("[") == false;

	}
}
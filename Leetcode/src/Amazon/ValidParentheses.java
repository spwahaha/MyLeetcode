package Amazon;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }else{
                    char last = stack.pop();
                    if(!valid(last, c)){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
    
    private boolean valid(char left, char right){
        if(left == '(' && right == ')') return true;
        if(left == '[' && right == ']') return true;
        if(left == '{' && right == '}') return true;
        return false;
    }
}

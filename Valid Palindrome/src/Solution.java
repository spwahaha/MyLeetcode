public class Solution {
    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        return new StringBuilder(s).reverse().toString().equals(s);
    }
    
    public static void main(String[] args){
    	System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
public class Solution {
    public static boolean isPalindrome(int x) {
    	if(x < 0)
    		return false;
    	if(x < 10)
    		return true;
    	int size = 0;
    	int[] arr = new int[10];
    	int i = 0;
    	while(x>0){
    		arr[i] = x % 10;
    		x = x / 10;
    		i++;
    		size++;
    	}
    	
    	for(i = 0; i <size; i++){
    		if(arr[i] != arr[size-1-i])
    			return false;
    	}
    	return true;
    	
    }
    
    public static void main(String[] args){
    	System.out.print(isPalindrome(1234321));
    }
    
    
}
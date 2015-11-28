
public class Solution {
    public boolean isUgly(int num) {
        if(num<=0){
            return false;
        }
        if(num==1){
		return true;
        }
	
	while(num%2==0||num%3==0||num%5==0){
		if(num%2==0){
			num = num/2;
		}
		if(num%3==0){
			num = num/3;
		}
		if(num%5==0){
			num=num/5;
		}
	}
	if(num!=1){
		return false;
	}
	return true;
    }
    
    
    public static void main(String[] args){
    	Solution so = new Solution();
    	System.out.println(so.isUgly(5));

    }
}

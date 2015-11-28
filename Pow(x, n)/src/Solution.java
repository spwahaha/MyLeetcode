
public class Solution {
    public static double myPow(double x, int n) {
        if(n==-1){
        	return 1/x;
        }
    	if(n==0)
    		return 1;
    	if(n==1){
            return x;
        }      if(n%2==1){
        	double temp = myPow(x,n/2);
        	return x*temp*temp;
        }
        else if(n%2==0){
        	double temp = myPow(x,n/2);
        	return temp*temp;
        }else{
            double temp = myPow(x,n/2);
            return 1/x*temp*temp;
        }

    }
    
    public static void main(String[] args){
    	double a = 34.00515;
    	int b = -3;
    	System.out.println(Math.pow(a, b));
    	System.out.print(myPow(a,b));

    }
}

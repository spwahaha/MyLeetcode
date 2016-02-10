
public class SqrtX {
    public static int mySqrt(int x) {
        if(x <= 1) return x; 
        int h = x;
        int l = 0;
        while(l<=h){
            long mid = l + (h-l)/2;
            long val = (mid * mid);
            if(val == x) return (int)mid;
            else if(val > x){
                h = (int)(mid - 1);
            }else{
                l = (int)(mid + 1);
            }
        }
        return l-1;
    }
    
    public static void main(String[] args){
    	System.out.println(mySqrt(2147395599));
    }
}

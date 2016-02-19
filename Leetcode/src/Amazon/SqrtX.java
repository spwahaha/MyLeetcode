package Amazon;

public class SqrtX {
    public int mySqrt(int x) {
        if(x < 0){
            return -1;
        }
        long start = 0;
        long end = x;
        while(start <= end){
            long mid = start + (end - start) / 2;
            if(mid * mid == (long)x){
                return (int)mid;
            }else if(mid * mid < (long)x && (mid + 1) * (mid + 1) > (long)x){
                return (int)mid;
            }else if(mid * mid < (long)x){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
}

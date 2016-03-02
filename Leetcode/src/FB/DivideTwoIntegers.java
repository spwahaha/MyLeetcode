package FB;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(divisor == 0){
            return Integer.MAX_VALUE;
        }
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean nega = (dividend > 0) ^ (divisor > 0);
        long dvd = dividend;
        long dvs = divisor;
        dvd = Math.abs(dvd);
        dvs = Math.abs(dvs);
        int res = 0;
        while(dvd >= dvs){
            long temp = dvs;
            int times = 1;
            while(dvd >= (temp << 1)){
                temp <<= 1;
                times <<= 1;
            }
            dvd -= temp;
            res += times;
        }
        return nega ? -res : res;
    }
}

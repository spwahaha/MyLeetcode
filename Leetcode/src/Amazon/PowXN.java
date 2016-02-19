package Amazon;

public class PowXN {
    public double myPow(double x, int n) {
        boolean posi = n >= 0;
        n = Math.abs(n);
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return posi ? x : 1 / x;
        }
        double res = 0;
        if(n % 2 == 0){
            res = myPow(x * x, n / 2);
        }else{
            res = x * myPow(x * x, n / 2);
        }
        return posi ? res : 1 / res;
    }
}

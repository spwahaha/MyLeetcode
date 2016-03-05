package FB;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int car = 0;
        for(int i = digits.length - 1; i >= 0; i--){
            int num = 0;
            if(i == digits.length - 1){
                num = digits[i] + 1;
            }else{
                num = digits[i] + car;
            }
            digits[i] = num % 10;
            car = num / 10;
        }
        if(car == 1){
            int[] res = new int[digits.length + 1];
            res[0] = car;
            for(int i = 0; i < digits.length; i++){
                res[i + 1] = digits[i];
            }
            return res;
        }else{
            return digits;
        }
    }
    
    /*
     * another clever way, when we need to add one more digits? 
     * when the original number is like 999, 99
     * we just need to get a new array and the first element is 1, else is 0
     */
    
    public int[] plusOne2(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] == 9){
                digits[i] = 0;
            }else{
                digits[i]++;
                return digits;
            }
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
    
}

package Amazon;

public class IntegerToRoman {
    public String intToRoman(int num) {
        String[] M = new String[10];
        String temp = "";
        for(int i = 0; i < 10; i++){
            M[i] = temp;
            temp +="M";
        }
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        
        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
    }
}

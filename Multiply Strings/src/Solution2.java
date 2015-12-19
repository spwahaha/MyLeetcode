public class Solution2 {
    public static String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m+n];
        
        for(int i = m-1; i>=0; i--){
        	int n1 = num1.charAt(i)-'0';
            for(int j = n-1; j >=0; j--){
            	int n2 = num2.charAt(j) - '0';
            	res[i + j + 1] += (n1 * n2) % 10;
            	res[i + j] += (n1*n2)/10;
            }
        }
        
        for(int i = m + n-1;i>0; i--){
        	int temp = res[i];
        	res[i] = temp%10;
        	res[i-1] +=temp/10;
        }
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(; i<m+n;i++){
        	if(res[i]!=0)
        		break;
        }
        for(; i < m+n;i++)
        	sb.append(res[i]);
        
        if(sb.toString().equals(""))
        	sb.append(0);
        return sb.toString();
    }
    
    
	public static void main(String[] args){
		System.out.println(multiply("123","456"));
	}
}
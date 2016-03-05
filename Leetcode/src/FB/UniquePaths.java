package FB;

public class UniquePaths {
	
	// O(m*n) space
    public int uniquePaths1(int m, int n) {
        int[][] f = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0){
                    f[i][j] = 1;
                }else if(j == 0){
                    f[i][j] = 1;
                }else{
                    f[i][j] = f[i][j - 1] + f[i - 1][j];
                }
            }
        }
        return f[m - 1][n - 1];
    }
	
	// O(m) space
    public static int uniquePaths2(int m, int n) {
        int[] f = new int[m];
        for(int i = 0; i < m; i++){
            f[i] = 1;
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                f[j] += f[j - 1];
            }
        }
        return f[m - 1];
    }
    
    // math
    public static int uniquePaths(int m, int n) {
        //C(m + n - 2, m - 1)
        long res = 1;
        if(m < n){
            int temp = m;
            m = n;
            n = temp;
        }
        // m >= n
        int i = 1;
        int j = m + n - 2;
        while(i < n){
            res *= j;
            res /= i;
            j--;
            i++;
        }
        return (int)res;
    }
    
    public static void main(String[] args){
    	System.out.println(uniquePaths2(3,2));
    	System.out.println(uniquePaths(3,2));
    }
}

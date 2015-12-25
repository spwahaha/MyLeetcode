
public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        if(m<2 || n<2) return 1;
        
        
        int[][] res = new int[m][n];
        for(int i = 0; i < m; i++){
            res[i][n-1] = 1;
        }
        
        for(int i = 0; i < n; i++){
            res[m-1][i] = 1;
        }
        
        for(int i = m-2; i>=0;i--){
            for(int j = n-2; j>=0;j--){
                res[i][j] = res[i+1][j] + res[i][j+1];
            }
        }
        
        return res[0][0];
    }
    
    public static void main(String[] args){
    	System.out.println(uniquePaths(2,2));
    }
    
}

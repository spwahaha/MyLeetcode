
public class Solution {
    public static int maximalSquare(char[][] matrix) {
        int len = matrix.length;
        if(len==0) return 0;
        int len2 = matrix[0].length;
        int[][] res = new int[len+1][len2+1];
        int max = 0;
        for(int i = 0; i<len;i++){
        	for(int j = 0; j <len2; j++){
        		if(matrix[i][j]=='1'){
        			res[i+1][j+1] = Math.min(Math.min(res[i][j+1], res[i][j]), res[i+1][j]) + 1;
        			max = Math.max(max, res[i+1][j+1]);
        		}
        	}
        }
        return max*max;
    }
    
    public static void main(String[] args){
    	char [][] nums = {{'1','1','1','1','0'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','0'}};
    	System.out.println(maximalSquare(nums));
    }
}

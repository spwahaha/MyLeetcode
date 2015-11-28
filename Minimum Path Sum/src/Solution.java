
public class Solution {
	public static int minPathSum(int[][] grid){
		int m = grid.length;
		int n = grid[0].length;
		
		int[][] sum = new int[m][n];
		sum[0][0] = grid[0][0];
		for(int i = 1;i<m;i++){
			sum[i][0] = sum[i-1][0] + grid[i][0];
		}
		
		for(int j = 1; j < n; j++){
			sum[0][j] = sum[0][j-1] + grid[0][j];
		}
		for(int i = 1; i < m ;i++){
			for(int j = 1; j < n;j++){
				sum[i][j] = Math.min(sum[i-1][j], sum[i][j-1]) + grid[i][j];
			}
		}
		
		return sum[m-1][n-1];
	}
	
	public static void main(String[] args){
		int[][] nums = {{2,3,4,7,6},{1,2,3,4,5},{6,1,0,1,1},{2,3,2,3,2}};
		System.out.println(minPathSum(nums));
	}
}

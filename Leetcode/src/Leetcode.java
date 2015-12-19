import java.util.Arrays;
import java.util.List;

public class Leetcode{
	public static void main(String[] args){
		
		Solution sol = new Solution();
		int[][] nums1 ={{0,0},{1,0}};
		int[][] nums2 = {{1}};
		int[][] nums = {{0,1,2,3,4},{5,6,7,8,9},{10,11,12,13,14},{15,16,17,18,19}};
		char[][] board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};

		               
		            		   //		int[][] nums = {{1,1}};
//		int[][] matrix = {{1,1,1,1},{1,1,1,0},{1,1,1,1}};
//		int[][] matrix = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
//		boolean[][] maze = {{false,true,true},{true,false,true},{true,true,true}};
//		sol.rotate(nums);
//		for(int i=0;i<nums1.length;i++){
//			System.out.println(nums1[i]);
//		}
		
		for(int i = 0; i < nums1.length;i++){
			System.out.println(nums1[i]);
		}
		System.out.println(sol.uniquePathWithObstacles(nums1));
		
	}
}
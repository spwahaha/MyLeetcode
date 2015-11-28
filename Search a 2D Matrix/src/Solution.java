public class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {
    	int start = 0;
    	int end = matrix.length*matrix[0].length-1;
    	
    	int mid = 0;
    	while(start<=end){
    		int i=0,j=0;
    		mid = start+(end-start)/2;
        		i = mid/(matrix[0].length);
        		j = mid%(matrix[0].length);
    		System.out.println(i+"?"+j);
    		if(matrix[i][j]<target){ 
    			start = mid+1;
    		}
    		if(matrix[i][j]>target){ 
    			end = mid-1; 
    		}
    		if(matrix[i][j]==target){
    			return true;
    		}
    	}
    	
    	return false;
    }
    
    public static void main(String[] args){
    	int[][] nums = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
    	System.out.println(searchMatrix(nums,9));
    	
    }
}
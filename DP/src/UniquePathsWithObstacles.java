
public class UniquePathsWithObstacles {
	  public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
      	int[][] nums = obstacleGrid;
        
	        int m = nums.length;
	        int n = nums[0].length;
	        if(m==1&&n==1){
	            if(nums[0][0] == 0) return 1;
	            else return 0;
	        }
	        if(nums[m-1][n-1] == 1 || nums[0][0] == 1) return 0;
	        
	        if(nums.length == 1 || nums[0].length==1){
	            for(int i = 0; i < nums[0].length;i++){
	                if(nums[0][i] == 1){
	                    return 0;
	                }
	            }
	            for(int i = 0; i < nums.length;i++){
	                if(nums[i][0] == 1){
	                    return 0;
	                }
	            }
	            return 1;
	        }
	        
	        boolean block = false;
	        for(int r = m-2; r >=0; r--){
	            if(nums[r][n-1] == 1){
	            	nums[r][n-1] = -1;
	                block = true;
	                continue;
	            }
	            if(block){
	                nums[r][n-1] = 0;
	            }else{
	                nums[r][n-1] = 1;
	            }
	        }
	        block = false;
	        for(int c = n-2; c >=0; c--){
	             if(nums[m-1][c] == 1){
	            	nums[m-1][c] = -1;
	                block = true;
	                continue;
	            }
	            if(block){
	                nums[m-1][c] = 0;
	            }else{
	                nums[m-1][c] = 1;
	            }
	            
	        }
	        
	        for(int r = m-2; r >=0; r--){
	            for(int c= n-2; c >=0; c--){
	                if(nums[r][c] == 1) {
	                   nums[r][c] = -1;
	                }else if(nums[r][c]!=-1){
	                	 nums[r][c] = Math.max(nums[r+1][c],0) + Math.max(nums[r][c+1],0);
	                }
	            }
	        }
	        
	        return Math.max(nums[0][0],0);
	    }
	  
	  public static void main(String[] args){
		  int[][] nums = {{0,0},{1,1},{0,0}};
		  System.out.println(uniquePathsWithObstacles(nums));
	  }
}

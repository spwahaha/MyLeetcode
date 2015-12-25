package RecursionAndDP;

public class PaintFill {
	// dfs
	static boolean paintFill(int[][] nums, int r, int c, int nNum){
		if(nums[r][c] == nNum) return false;
		return helper(nums, r, c, nums[r][c], nNum);
	}
	
	private static boolean helper(int[][] nums, int r, int c, int oNum, int nNum){
		if(r<0 || r >=nums.length || c < 0 || c >= nums[0].length){
			return false;
		}
		
		if(nums[r][c] == oNum){
			nums[r][c] = nNum;
			helper(nums, r, c-1, oNum, nNum);
			helper(nums, r, c+1, oNum, nNum);
			helper(nums, r-1, c, oNum, nNum);
			helper(nums, r+1, c, oNum, nNum);
		}
		return true;
	}
	
	
	public static void main(String[] args){
		int[][] nums = {{0, 0, 1, 2},
					{0, 1, 1, 1},
					{0, 2, 1, 1},
					{0, 0, 0, 0}};
					
		paintFill(nums, 0, 2, 0);
		for(int r = 0; r < nums.length; r++){
			for(int c = 0; c < nums[0].length; c++){
				System.out.print(nums[r][c]);
			}
			System.out.println();
		}
	}
	
	
}

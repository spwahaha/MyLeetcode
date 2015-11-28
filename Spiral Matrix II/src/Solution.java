public class Solution {
    //evenly divide a square into 4 part, 
	//eg, if the side length is 4;
	// we walk 3 step each time and then change the direction
	public static int[][] generateMatrix(int n) {
		int[][] nums = new int[n][n];
		if(n==0) return nums;
		gene(nums, 0,0,n,1);
		return nums;
    }

	private static void gene(int[][] nums, int i, int j, int length, int start) {
		// TODO Auto-generated method stub
		if(length==1){
			nums[i][j] = start;
		}else {
			//left-right
			int step = length;
			while(step>1){
				nums[i][j++] = start;
				start++;
				step--;
			}
			step = length;
			while(step>1){
				nums[i++][j] = start;
				start++;
				step--;
			}
			step = length;
			while(step>1){
				nums[i][j--] = start;
				start++;
				step--;
			}
			step = length;
			while(step>1){
				nums[i--][j] = start;
				start++;
				step--;
			}
			if(length>2)
				gene(nums, i + 1, j + 1, length - 2, start);;
		}
	}
	
	public static void main(String[] args){
		int[][] nums = generateMatrix(3);
		System.out.println("2");
	}
	
	
}
package SortingandSearching;

public class SortedMatrixSearch {
	
	public static int[] search(int[][] nums, int target){
		int[] res = new int[2];
		if(nums == null || nums.length==0) return res;
		int r = nums.length;
		int c = nums[0].length;
		return search(nums, target, 0, r * c -1);
	}
	
	private static int[] search(int[][] nums, int target, int start, int end){
		int[] res = new int[2];
		while(start <= end){
			int mid = start + (end - start)/2;
			int r = mid/nums[0].length;
			int c = mid%nums[0].length;
			if(nums[r][c] == target){
				res[0] = r;
				res[1] = c;
				return res;
			}
			if(nums[r][c] < target){
				start = mid+1;
			}else{
				end = mid-1;
			}
		}
		
		return res;
	}
	
	
	public static void main(String[] args){
		int[][] nums = {{0,1,2,3},
						{4,5,6,7},
						{8,9,10,11},
						{12,13,14,15},
						{16,17,18,19}};
						
		int[] res = search(nums, 100);
		for(int i = 0; i < res.length; i++){
			System.out.print(res[i] + "   ");
		}
		
	}
}

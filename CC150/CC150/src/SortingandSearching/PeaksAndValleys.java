package SortingandSearching;

public class PeaksAndValleys {
	public static void sortPeakandValley(int[] nums){
		for(int i = 1; i < nums.length; i+=2){
			int bigIndex = getBiggestIndex(nums, i-1, i, i+1);
			if(bigIndex != i){
				swap(nums, i, bigIndex);
			}
		}
	}
	
	private static int getBiggestIndex(int[] nums, int a, int b, int c){
		int va = a>=0 && a<nums.length?nums[a]:Integer.MIN_VALUE;
		int vb = nums[b];
		int vc = c < nums.length?nums[c]:Integer.MIN_VALUE;
		
		int max = Math.max(va, Math.max(vb, vc));
		if(max == va) return a;
		if(max == vb) return b;
		return c;
	}
	
	private static void swap(int[] nums, int a, int b){
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
	
	public static void main(String[] args){
		int[] nums = {5, 8, 6, 2, 3, 4, 6};
		sortPeakandValley(nums);
		for(int i = 0; i < nums.length; i++){
			System.out.print(nums[i] + "  ");
		}
	}
}


public class ProductofArrayExceptSelf {
	public static int[] productExceptSelf(int[] nums){
		if(nums==null) return nums;
		int[] res = new int[nums.length];
		int left = 1;
		// res[i] saves the product of nums[0]~nums[i-1];
		// left at i, is the product nums[0]~nums[i-1], then multiple nums[i]
		// so left after i is the product of nums[0]~nums[i];
		for(int i = 0; i < nums.length; i++){
			res[i] = left;
			left *=nums[i];
		}
		
		int right = 1;
		// res[i] stores the product of nums[0]~nums[i-1];
		// right stores the product of nums[length-1] ~ nums[i+1] at beginning
		// so, res[i] = res[i] * right is all product except res[i]
		// then update right
		for(int i = nums.length-1; i>=0;i--){
			res[i] *= right;
			right *= nums[i];
		}
		return res;
	}
	
	public static void main(String[] args){
		int[] nums = {1,2,3,4,5,0};
		nums = productExceptSelf(nums);
		for(int i = 0; i < nums.length; i++){
			System.out.print(nums[i] + "   ");
		}
	}
}

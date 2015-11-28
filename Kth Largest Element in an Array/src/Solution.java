public class Solution {
    public static int findKthLargest(int[] nums, int k) {
        return nums[find(nums,0,nums.length-1,k)];
    }

	private static int find(int[] nums, int lo, int hi, int k) {
		// TODO Auto-generated method stub
		// based on quciksort, if the pivot is the kth one, return
		// if not, sort according the the pivot position and k
		int pivot = partition(nums,lo,hi);
		if(pivot==nums.length-k)  return pivot;
		else if(pivot<nums.length-k) return find(nums,pivot+1,hi,k);
		else  return find(nums,lo,pivot-1,k);
	}

	private static int partition(int[] nums, int lo, int hi) {
		// TODO Auto-generated method stub
		int pivot = nums[lo];
		int i = lo+1;
		int j = hi;
		while(true){
			while(i<hi&&nums[i]<pivot)
				i++;
			while(j>lo&&nums[j]>pivot)
				j--;
			if(i>=j)
				break;
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
		
		int temp = nums[lo];
		nums[lo] = nums[j];
		nums[j] = temp;
		return j;
	}
	
	public static void main(String[] args){
		int[] a = {7,6,5,4,3,2,1};
		System.out.println(findKthLargest(a,4));
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i]+",");
		}
	}
    
    
}
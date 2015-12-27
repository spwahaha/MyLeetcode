package SortingandSearching;

public class SortedMerge {
	public static void merge(int[] nums1, int m, int[] nums2, int n){
		int index = m + n - 1;
		int n1 = m-1;
		int n2 = n-1;
		while(index >=0){
			if(n1<0||(n2>=0&&nums2[n2] > nums1[n1])){
				nums1[index] = nums2[n2];
				n2--;
			}else{
				nums1[index] = nums1[n1];
				n1--;
			}
			index--;
		}
	}
	
	public static void main(String[] args){
		int[] nums1 = {1,2,3,4,5,0,0,0,0,0,0,0,0};
		int[] nums2 = {6,7,8,9};
		merge(nums1, 5, nums2, 4);
		for(int i = 0; i < nums1.length; i++){
			System.out.print(nums1[i]+"     ");
		}
	}
}

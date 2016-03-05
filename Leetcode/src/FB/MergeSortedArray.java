package FB;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int posi = m + n - 1;
        while(i >= 0 && j >= 0){
            if(nums1[i] > nums2[j]){
                nums1[posi--] = nums1[i--];
            }else{
                nums1[posi--] = nums2[j--];
            }
        }
        /*
         * if i have put all the element of nums1, some elements in nums2 
         * are left we need to put the rest, if we have put all the elements in nums2
         * the rest element in nums1 can just keep in there position
         */
        if(j >= 0){
            while(j >= 0){
                nums1[posi--] = nums2[j--];
            }
        }
    }
}

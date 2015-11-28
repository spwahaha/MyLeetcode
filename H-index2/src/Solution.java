public class Solution {
    public static int hIndex(int[] citations) {
        
        int len = citations.length;
        int l = 0;
        int h = len-1;
        while(l<=h){
        	int mid = (h+l)/2;
        	int validlen = len-mid;
        	if(validlen == citations[mid])
        		return validlen;
        	else if(validlen < citations[mid]){
        		h = mid - 1;
        	}else{
        		l = mid + 1;
        	}
        }
        return len - (h + 1);
    }
    
    public static void main(String[] args){
    	int[] nums = {0};
    	System.out.print(hIndex(nums));
    }
}
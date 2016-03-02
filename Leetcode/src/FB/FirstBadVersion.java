package FB;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(isBadVersion(mid)){
                if(mid == start || !isBadVersion(mid - 1)){
                    return mid;
                }else{
                    end = mid - 1;
                }
            }else{
                start = mid + 1;
            }
        }
        
        return -1;
    }
    
    private boolean isBadVersion(int n){
    	return true;
    }
}

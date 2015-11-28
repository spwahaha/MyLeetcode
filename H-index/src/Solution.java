import java.util.Arrays;

public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        for(int i = 0; i<citations.length; i++){
        	if(len<=citations[i])
        	    return len;
        	else
        	    len--;    
        }
        return len;
    }
}
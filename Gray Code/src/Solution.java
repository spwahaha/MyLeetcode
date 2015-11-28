import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> grayCode(int n) {
            if(n==0){
    		List<Integer> a = new ArrayList<Integer>();
    		a.add(0);
    		return a;
    	}
    	
    	List<Integer> last_r = grayCode(n-1);
    	
    	List<Integer> res = new ArrayList<Integer>(last_r);
    	for(int i = last_r.size()-1;i>=0;i--){
    		int cur = last_r.get(i) + (int)Math.pow(2,n-1);
    		res.add(cur);
    	}
    	
    	return res;
    }
}
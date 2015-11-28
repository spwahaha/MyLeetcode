import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public static List<Integer> grayCode(int n) {
		List<Integer> res = new ArrayList<Integer>();	
    		res.add(0);
    	for(int i = 0; i < n; i++){
    		int size = res.size();
    		for(int j = size-1; j >=0; j--){
    			res.add(res.get(j)+(1<<i));
    		}
    	}
    	return res;
    }
    
    public static void main(String[] args){
    	System.out.println(grayCode(2));
    }
    
    
}
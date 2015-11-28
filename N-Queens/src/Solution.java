import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
    	if(n <1) return null;
    	List<String> list = new ArrayList<String>();
		StringBuilder line = new StringBuilder();;
		for(int j = 0;j<n;j++){
			line.append(".");
		}
		// we should use array to store the status of the board and 
		// for example, col means the status of all column, 
		// means it's already has a queen or not. if this col[i] has not queen,
		// then we can put one here, otherwise, we can't.
		// this saves time!!!really!!
    	helper(res,list,0,n,line,new boolean[n],new boolean[n], new boolean[2*n-1],new boolean[2*n-1]);
    	System.out.println(res.size());
    	return res;
    }
    
    private void helper(List<List<String>> res,
    		List<String> list, int level,int n,StringBuilder line,
    		boolean[] col, boolean [] row, boolean[] dia1, boolean[] dia2){
    	if(level == n){
   			res.add(new ArrayList<String>(list));
    		return;
    	}
    	for(int i = 0;i<n;i++){
    		StringBuilder newline = new StringBuilder(line);;
    		newline.replace(i, i+1, "Q");
    		
    		if(valid(list,level,i,col,row,dia1,dia2,n)) {	
    			col[i] = true;
        		row[level] = true;
        		dia1[Math.abs(level-(n-1))+Math.abs(i-0)] = true;
        		dia2[i+level] = true;
        		
    			list.add(newline.toString());
        		helper(res, list, level+1,n,line,col,row,dia1,dia2);
    			list.remove(list.size()-1);
    			
    			col[i] = false;
        		row[level] = false;
        		dia1[Math.abs(level-(n-1))+Math.abs(i-0)] = false;
        		dia2[i+level] = false;
    		}

    	}
    }
    
    private boolean valid(List<String> list,int level,int r,
    		boolean[] col, boolean [] row, boolean[] dia1, boolean[] dia2,int n){
    	
		return (!col[r]&&!row[level]&&!dia1[Math.abs(level-(n-1))+Math.abs(r-0)] &&!dia2[r+level]);

    }
    
    public static void main(String[] args){
    	Solution so = new Solution();
    	System.out.println(so.solveNQueens(1));
    }
}

package RecursionAndDP;

import java.util.ArrayList;

public class NQueens {
	
	public static ArrayList<Integer[]> solveNQueens(int n){
		ArrayList<Integer[]> res = new ArrayList<Integer[]>();
		Integer[] col = new Integer[n];
		solve(res, col, 0, n);
		return res;
	}
	
	private static void solve(ArrayList<Integer[]> res, Integer[] col, int r, int n){
		if(r == n){
			res.add(col.clone());
			return;
		}
		
		for(int i = 0; i < n; i++){
			col[r] = i; 
			if(valid(col, r)){
				solve(res, col, r+1, n);
			}
		}
	}
	
	private static boolean valid(Integer[] col, int r1){
		int col1 = col[r1];
		for(int r2 = 0; r2 < r1; r2++){
			int col2 = col[r2];
			if(col1 == col2){
				return false;
			}
			
			int colDiff = Math.abs(col1 - col2);
			int rowDiff = Math.abs(r1 - r2);
			if(colDiff == rowDiff){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		ArrayList<Integer[]> res = solveNQueens(4);
		System.out.println(2);
	}

}

public class Solution {
	// my code is so ugly
    public static void gameOfLife(int[][] board) {
        // we use 2 bits to present the state transition
    	// xy means from y -> x
    	//eg, 01:live-die 00:die-die 10:die-live 11:live-live
    	// first get all the transition state
    	int m = board.length;
    	int n = board[0].length;
    	for(int i = 0; i < m; i++){
    		for(int j = 0; j < n; j++){
    			int val= value(board,i-1,j-1,m,n) + value(board,i-1,j,m,n) 
    							+ value(board,i-1,j+1,m,n) + value(board,i,j-1,m,n)
    							+value(board,i,j+1,m,n)  + value(board,i+1,j-1,m,n) 
    							+ value(board,i+1,j,m,n) + value(board,i+1,j+1,m,n);
    					//transi(board,i,j);
    			if(val<2){
    				//die	
    			}
    			if(val == 2 || val == 3){
    				//live
    				//3 die-live
    				if(val==2){
    					if((board[i][j]&1)==1)// judge based on this states
    						board[i][j] = 3;
    					else
    						board[i][j] = 0;
    				}else{
        				if((board[i][j]&1)==1){
        					board[i][j] = 3;
        				}else
        					board[i][j] = 2;
    				}
    			}
    			if(val>3){
    				//die	
    			}
    		}
    	}
    	
    	for(int i = 0; i < m; i++){
    		for(int j = 0; j < n; j++){
    			board[i][j] = (board[i][j]&2)>>1; // get the next state
    		}
    	}
    	
    	
    }

	private static int value(int[][] nums,int i, int j, int m, int n) {
		// TODO Auto-generated method stub
		// 1,2,3
		// 4,*,5
		// 6,7,8
		if(i < 0 || i > m-1 || j < 0 || j > n-1)
			return 0;
		else return (nums[i][j]&1);
		
	}
	
	public static void main(String[] args){
		int[][] nums = {{1,1},{1,0}};
		gameOfLife(nums);
		System.out.print("asd");
	}
	
}
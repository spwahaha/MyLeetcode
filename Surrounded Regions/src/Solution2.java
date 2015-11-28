import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    public void solve1(char[][] board) {
        if(board==null) return;
        int m = board.length;
        if(m==0) return;
        int n = board[0].length;
        boolean visited[][] = new boolean[m][n];

    	for(int i = 0; i < m;i++){
    		if(board[i][0]=='O'&&!visited[i][0])
				helper(board,i,0,visited,m,n);
    	}
    	for(int i = 0; i < m;i++){
    		if(board[i][n-1]=='O'&&!visited[i][n-1])
				helper(board,i,n-1,visited,m,n);
    	}
    	for(int i = 0; i < n;i++){
    		if(board[0][i]=='O'&&!visited[0][i])
				helper(board,0,i,visited,m,n);
    	}
    	for(int i = 0; i < n;i++){
    		if(board[m-1][i]=='O'&&!visited[m-1][i])
				helper(board,m-1,i,visited,m,n);
    	}
    	for(int i = 0; i < m ; i ++){
    		for(int j = 0; j <n; j++){
    			if(board[i][j]=='O')
    				board[i][j]='X';
    			if(board[i][j]=='1')
    				board[i][j]='O';
    		}
    	}
    }  	
 
    private void helper(char[][] board, int i, int j, boolean[][] visited,int m,int n) {
    	visited[i][j] = true;
    	board[i][j] = '1';
    	// DFS notice the boundary, if i set i-1>0 then stackoverflow may happen
    	// if i set i-1>=1, then the next time the solver would come the dfs
    	// and stack won't have some much burden
		if(i-1>=1&&board[i-1][j]=='O'&&!visited[i-1][j]){
			helper(board,i-1,j,visited,m,n);
		}
		if(j-1>=1&&board[i][j-1]=='O'&&!visited[i][j-1]){
			helper(board,i,j-1,visited,m,n);
		}
		if(i+1<m-1&&board[i+1][j]=='O'&&!visited[i+1][j]){
			helper(board,i+1,j,visited,m,n);
		}
		if(j+1<n-1&&board[i][j+1]=='O'&&!visited[i][j+1]){
			helper(board,i,j+1,visited,m,n);
		}
	}
    
	public static void main(String[] args){
    	char[][] grid= {{'X','X','X','X'},
    					{'X','O','O','X'},
    					{'X','X','O','X'},
    					{'X','O','X','X'}};
    	char[][] grid2= {{'X','X','X','X'},
				{'X','X','X','X'},
				{'X','X','X','X'},
				{'X','O','X','X'}};
    	char[][] grid3= {{'O','X','X','O','X'},
    					{'X','O','O','X','O'},
    					{'X','O','X','O','X'},
    					{'O','X','O','O','O'},
    					{'X','X','O','X','O'}};
    	char[][] grid4 = {{'O','X','X','O','X'},
    					{'O','O','O','O','O'},
    					{'O','O','O','O','O'},
    					{'O','O','O','O','O'},
    					{'O','O','O','O','O'}};
    	Solution2 sl = new Solution2();
    	sl.solve1(grid3);
    	
    	System.out.println("sa");
    }
}

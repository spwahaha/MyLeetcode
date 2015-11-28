import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public void solve(char[][] board) {
        if(board==null) return;
        int m = board.length;
        if(m==0) return;
        int n = board[0].length;
        boolean[][] isVisited  =new boolean[m][n];
        for(int i = 0; i < m; i++){
        	for(int j = 0; j < n; j++){
        		if(board[i][j]=='O'){
        			if(i!=m-1&&j!=n-1&&i!=0&&j!=0&&!isVisited[i][j])
        				// this means we found a new entrance
        				// the new entrance must not on the edge and has not been visited
        				helper(isVisited, board, i, j);
        		}
        	}
        }
    }
    
    private void helper(boolean[][] isVisited, char[][] board, int i, int j){
    	Queue<Integer> q1 = new LinkedList<Integer>();
    	Queue<Integer> q2 = new LinkedList<Integer>();
    	Queue<Integer> q3 = new LinkedList<Integer>();
    	Queue<Integer> q4 = new LinkedList<Integer>();
    	// can be changed to Queue<Integer[]>
    	q1.offer(i);
    	q2.offer(j);
    	q3.offer(i);
    	q4.offer(j);
    	
    	isVisited[i][j] = true;
    	
    	int len1 = board.length;
    	int len2 = board[0].length;
    	
    	boolean flag = false;
    	// bfs and flag means whether this region includes edge
    	while(!q1.isEmpty()){
    		int size = q1.size();
    		for(int k = 0; k < size; k++){
    			int m = q1.poll();
    			int n = q2.poll();

    			if(m-1>=0&&board[m-1][n]=='O'&&!isVisited[m-1][n]){
    				isVisited[m-1][n] = true;
    				q1.offer(m-1);
    				q2.offer(n);
    				q3.offer(m-1);
    				q4.offer(n);
    				if(m-1==0||m-1==len1-1||n==0||n==len2-1)
    					flag = true;
    			}
    			
    			if(m+1<len1&&board[m+1][n]=='O'&&!isVisited[m+1][n]){
    				isVisited[m+1][n] = true;
    				q1.offer(m+1);
    				q2.offer(n);
    				q3.offer(m+1);
    				q4.offer(n);
    				if(m+1==0||m+1==len1-1||n==0||n==len2-1)
    					flag = true;
    			}
    			if(n-1>=0&&board[m][n-1]=='O'&&!isVisited[m][n-1]){
    				isVisited[m][n-1] = true;
    				q1.offer(m);
    				q2.offer(n-1);
    				q3.offer(m);
    				q4.offer(n-1);
    				if(m==0||m==len1-1||n-1==0||n-1==len2-1)
    					flag = true;
    			}
    			if(n+1<len2&&board[m][n+1]=='O'&&!isVisited[m][n+1]){
    				isVisited[m][n+1] = true;
    				q1.offer(m);
    				q2.offer(n+1);
    				q3.offer(m);
    				q4.offer(n+1);
    				if(m==0||m==len1-1||n+1==0||n+1==len2-1)
    					flag = true;
    			}
    			
    		}
    	}
    	if(!flag){
    		while(!q3.isEmpty()){
    			int m = q3.poll();
    			int n = q4.poll();
    			board[m][n] = 'X';
    		}
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
    	char[][] grid4 = {};
    	Solution sl = new Solution();
    	sl.solve(grid3);
    	System.out.println("sa");
    }
}

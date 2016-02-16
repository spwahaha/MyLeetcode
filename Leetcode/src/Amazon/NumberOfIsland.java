package Amazon;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland {
	
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
//                    dfs(grid, i, j);
                    bfs(grid, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    // dfs
    private void dfs(char[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);   
    }
    
    private void bfs(char[][] grid, int i, int j){
    	int m = grid.length;
    	int n = grid[0].length;
    	Queue<Integer> row = new LinkedList<Integer>();
    	Queue<Integer> col = new LinkedList<Integer>();
    	row.add(i);
    	col.add(j);
    	grid[i][j] = '0';
    	while(!row.isEmpty()){
    		int r = row.poll();
    		int c = col.poll();
    		if(r - 1 >= 0 && grid[r - 1][c] == '1'){
    			grid[r - 1][c] = '0';
    			row.add(r - 1);
    			col.add(c);
    		}
    		if(r + 1 < m && grid[r + 1][c] == '1'){
    			grid[r + 1][c] = '0';
    			row.add(r + 1);
    			col.add(c);
    		}
    		if(c - 1 >= 0 && grid[r][c - 1] == '1'){
    			grid[r][c - 1] = '0';
    			row.add(r);
    			col.add(c - 1);
    		}
    		if(c + 1 < n && grid[r][c + 1] == '1'){
    			grid[r][c + 1] = '0';
    			row.add(r);
    			col.add(c + 1);
    		}
    		
    	}
    }
}

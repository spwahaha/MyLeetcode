import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int numIslands(char[][] grid) {
    	if(grid==null) return 0;
    	int m = grid.length;
    	if(m==0) return 0;
    	int n = grid[0].length;
    	int number = 0;
        boolean[][] isVisited = new boolean[m][n];
        for(int i = 0; i <m;i++){
        	for(int j = 0; j <n;j++){
        		if(!isVisited[i][j]&&grid[i][j]=='1'){
        			// this means we find a new island
        			// then we make all the elements of this island visited=true 
        			helper(isVisited,grid,i,j);
        			number++;
        		}
        	}
        }
        return number++;
    }
    
    private void helper(boolean[][] isVisited, char[][] grid, int i, int j){
    	Queue<Integer> q1 = new LinkedList<Integer>();
    	Queue<Integer> q2 = new LinkedList<Integer>();
    	isVisited[i][j] = true;
    	// we use BFS to find the area of one island
    	q1.offer(i);
    	q2.offer(j);
    	while(!q1.isEmpty()){
    		int size = q1.size();
    		for(int k = 0;k<size;k++){
    			int p = q1.poll();
    			int q = q2.poll();
    			if(p-1>=0&&grid[p-1][q]=='1'&&!isVisited[p-1][q]){
    				isVisited[p-1][q] = true;
    				q1.offer(p-1);
    				q2.offer(q);
    			}
    			if(p+1<grid.length&&grid[p+1][q]=='1'&&!isVisited[p+1][q]){
    				isVisited[p+1][q] = true;
    				q1.offer(p+1);
    				q2.offer(q);
    			}
    			if(q-1>=0&&grid[p][q-1]=='1'&&!isVisited[p][q-1]){
    				isVisited[p][q-1] = true;
    				q1.offer(p);
    				q2.offer(q-1);
    			}
    			if(q+1<grid[0].length&&grid[p][q+1]=='1'&&!isVisited[p][q+1]){
    				isVisited[p][q+1] = true;
    				q1.offer(p);
    				q2.offer(q+1);
    			}
    		}
    	}

    }
    
    public static void main(String[] args){
    	char[][] grid= {{'1','1','1','1','0'},
    				{'1','1','0','1','0'},
    				{'1','1','0','0','0'},
    				{'0','0','0','0','0'}
    				};
    	char[][] grid2= {{'1','1','0','0','0'},
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'}
				};
    	char[][] grid3 = {};
    	Solution sl = new Solution();
    	System.out.println(sl.numIslands(grid3));
    }
}

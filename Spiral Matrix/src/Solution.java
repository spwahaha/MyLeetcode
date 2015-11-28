import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> list = new ArrayList<Integer>();
    	int m = matrix.length;
    	int n = matrix[0].length;
		gene(matrix, 0,0,m,n,list);
    	return new ArrayList<Integer>();
    }

	private void gene(int[][] nums, int i, int j, int length, List<Integer> list) {
		// TODO Auto-generated method stub
		if(length==1){
			list.add(nums[i][j]);
		}else {
			//left-right
			int step = length;
			while(step>1){
				list.add(nums[i][j++]);
				step--;
			}
			step = length;
			while(step>1){
				list.add(nums[i++][j]);
				step--;
			}
			step = length;
			while(step>1){
				list.add(nums[i][j--]);
				step--;
			}
			step = length;
			while(step>1){
				list.add(nums[i--][j]);
				step--;
			}
			if(length>2)
				gene(nums, i + 1, j + 1, length - 2,list);;
		}
	}
	
	public static void main(String[] args){
		
	}
	
}

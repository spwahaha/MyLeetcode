package arraysAndStrings;

public class RotateMatrix {
	
	public static void rotate(int[][] matrix){
		int n = matrix.length;
		for(int i = 0; i < n/2; i++){
//			int 
			for(int j = i; j < n-i-1; j++){
				int offset = j-i;
				int left = i;
				int top = i;
				int right = n-i-1;
				int bottom = n-i-1;
				
				int num = matrix[top][j];
				matrix[top][j] = matrix[bottom-offset][left];
				matrix[bottom-offset][left] = matrix[bottom][right-offset];
				matrix[bottom][right-offset] = matrix[top+offset][right];
				matrix[top+offset][right] = num;
				
			}
		}
	}
	
	public static void main(String[] args){
		int[][] mat = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}
					,{16,17,18,19,20},{21,22,23,24,25}};
//		int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
		for(int i = 0; i < mat.length;i++){
			for(int j = 0; j < mat[0].length; j++){
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		rotate(mat);
		System.out.println();
		for(int i = 0; i < mat.length;i++){
			for(int j = 0; j < mat[0].length; j++){
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
}

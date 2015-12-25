import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	 public static List<Integer> spiralOrder(int[][] matrix) {
	        List<Integer> res = new ArrayList<Integer>();
	        int m = matrix.length;
	        if(matrix == null || m == 0) return res;
	        int n = matrix[0].length;
	        int index = 0;
	        int p = m;
	        int q = n;
	        
	        
	        while(m>1&&n>1){
	            
	            for(int i = index; i < q-index-1; i++){
	                res.add(matrix[index][i]);                
	            }
	            for(int i = index; i < p-index-1; i++){
	                res.add(matrix[i][q-index-1]);
	            }
	            
	            for(int i = q-index-1; i>index; i--){
	                res.add(matrix[p-index-1][i]);
	            }
	            
	            for(int i = p-index-1; i>index; i--){
	                res.add(matrix[i][index]);
	            }
	            
	            m -=2;
	            n -=2;
	            index++;
	        }
	        
	        if(m==1){
	            for(int i = index; i < index + n; i++){
	                res.add(matrix[index][i]);
	            }
	            return res;
	        }
	        
	        if(n==1){
	            for(int i = index; i < index + m; i++){
	                res.add(matrix[i][index]);
	            }
	            return res;
	        }
	        
	        return res;  
	    }
	 
	 public static void main(String[] args){
		 int[][] nums = {{1,2,3,4},
				 		 {5,6,7,8},
				 		 {9,10,11,12},
				 		 {12,14,15,16}};
		 System.out.println(spiralOrder(nums));
	 }
}

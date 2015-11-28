public class Solution1 {
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    	// calculate the area separately,
    	// the subtract the common area;
    	
    	int area1 = (C - A) * (D - B);
    	int area2 = (G - E) * (H - F);
        int common = 0;
        // no intersection
        if(!(D <= F || B >= H || C <= E || G <= A))
        	common = (Math.min(C, G) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));
        
        return area1 + area2 - common;

    }
    
    public static void main(String args[]){
    	System.out.print(computeArea(-2,-2,2,2,-2,-2,2,2));
    }
}
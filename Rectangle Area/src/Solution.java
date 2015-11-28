public class Solution {
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    	// this program calculate the common area, not what the question want!!!
    	// read question carefully!!
        if(E < A && G > C && F < B && H > D ){
        	if((C-A) * (D - B) == 0) 
        		return (G - E) * (H - F);
        	else return((D-A)*(C-B));
        }
        if(E > A && G < C && F > B && H < D ){
        	if((G - E) * (H - F) == 0)
        		return (C-A) * (D - B);
        	else   	return ((G - E)*( H - F));
        }
        
        if(F > D || B > H || E > C || G < A)
        	return 0;
        
        int top1 = Math.max(G,H);
        int top2 = Math.min(G, H);
        int top3 = Math.max(B, F);
        int top4 = Math.min(B, F);
        int left1 = Math.min(A, E);
        int left2 = Math.max(A, E);
        int left3 = Math.min(C, G);
        int left4 = Math.max(C, G);
        int res = (top1 - top4) * (left4 - left1);
        res -= (G - E) * (H - F);
        res -= (C - A) * (D - B);
        res -= (top1 - top2) * (left2 - left1);
        res -= (top3 - top4) * (left4 - left3);
        return Math.abs(res);
    }
    
    public static void main(String args[]){
    	System.out.print(computeArea(0,0,0,0,-1,-1,1,1));
    }
}
package RecursionAndDP;

public class TripleStep {
	public static int countSteps(int n){
		if(n < 3) return n;
		int[] res = new int[n+1];
		res[1] = 1;
		res[2] = 2;
		res[3] = 1 + 1 + 2;
		for(int i = 4; i < n+1; i++){
			res[i] = res[i-1] + res[i-2] + res[i-3];
		}
		
		return res[n];
	}
	
	public static void main(String[] args){
		System.out.println(countSteps(4));
	}
}

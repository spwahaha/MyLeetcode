package RecursionAndDP;

public class Coints {
	public static int makeChange(int n){
		int[] cents = {25, 10, 5, 1};
		int[][] map = new int[n+1][cents.length];
		int res = make(cents, n, 0,map);
		return res;
	}
	
	private static int make(int[] cents,int amount,int index, int[][] map){
		if(map[amount][index]>0){
			return map[amount][index];
		}
		
		if(index >= cents.length-1){
			map[amount][index] = 1;
			return map[amount][index];
		}

		int ways = 0;
		for(int i = 0; cents[index] * i <= amount; i++){
			ways += make(cents, amount - cents[index] * i, index+1, map);
		}
		map[amount][index] = ways;
		return ways;
	}
	
	public static void main(String[] args){
		System.out.println(makeChange(15));
		
	}
}

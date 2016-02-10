package Zappos;

public class Chocolate {
	public static int makeChocolate(int n){
		if(n < 1) return 0;
		int res = (n / 2) * (n - n / 2);
		return res;
	}
	
	public static void main(String[] args){
		for(int i = 0; i < 10; i++){
			System.out.println(makeChocolate(i));
		}
	}
}

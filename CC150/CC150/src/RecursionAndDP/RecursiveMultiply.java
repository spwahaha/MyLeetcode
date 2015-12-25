package RecursionAndDP;

public class RecursiveMultiply {
	public static int multiply(int m, int n){
		if(n == 0) return 0;
		if(n == 1) return m;
		if(n == -1) return -m;
		int res = multiply(m, n>>1);
		if(n%2 == 0){
			return res << 1;
		}else{
			return (res<<1) + m;
		}

	}
	
	public static void main(String[] args){
		System.out.println(multiply(-3,-2));
	}
}

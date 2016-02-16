package Amazon;

public class CountOne {
	public static int count(int n){
		int i = 0;
		int cnt = 0;
		while(i < 32){
			cnt += (n >> i) & 1;
		}
		return cnt;
	}
	
	public static void main(String[] args){
		for(int i = -15; i < 16; i++){
			assert Integer.bitCount(i) == count(i);
		}
	}
}

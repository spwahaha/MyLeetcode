
public class RootSquare {
	public static float square(float n){
		float ep = 0.00001f;
		float x = n;
		float y = 1f;
		while(Math.abs(x-y)>ep){
			x = (x + y) / 2;
			y = n / x;
		}
		return x;
	}
	
	public static void main(String[] args){
		System.out.println(square(0.5f));
	}
}

package Zappos;

public class Path {
	public static boolean possiblePath(int startx, int starty, int endx, int endy){
		if(startx > endx || starty > endy){
			return false;
		}
		if(startx == endx && starty == endy){
			return true;
		}
		if(possiblePath(startx, startx + starty, endx, endy)){
			return true;
		}
		if(possiblePath(startx + starty, starty, endx, endy)){
			return true;
		}
		return false;
	}
	
	public static boolean possiblePath2(int startx, int starty, int endx, int endy){
		if(startx > endx || starty > endy){
			return false;
		}
		if(startx == endx && starty == endy){
			return true;
		}
		
		int gcd1 = gcd(startx, starty);
		int gcd2 = gcd(endx, endy);
		return gcd1 == gcd2;
	}
	
	private static int gcd(int a, int b){
		if(b == 0) return a;
		return gcd(b, a % b);
	}
	
	public static void main(String[] args){
		System.out.println(possiblePath(1, 4, 5,9));
		System.out.println(possiblePath2(1, 4, 5,9));
		System.out.println(gcd(12, 8));
	}
}

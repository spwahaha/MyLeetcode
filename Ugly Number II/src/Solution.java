import java.util.ArrayList;
import java.util.List;

public class Solution {
	 public static int nthUglyNumber(int n) {
		 if(n<1) return 0;
		 
		 List<Integer> list = new ArrayList<Integer>();
		 list.add(1);
		 n--;
		 int a = 0;
		 int b = 0;
		 int c = 0;
		 
		 while(n>0){
			 int next = Math.min(list.get(a)*2, Math.min(list.get(b)*3, list.get(c)*5));
			 list.add(next);
			 if(next == list.get(a)*2) a++;
			 if(next == list.get(b)*3) b++;
			 if(next == list.get(c)*5) c++;
			 n--;
		 }
		 return list.get(list.size()-1);
	 }
	 
	 public static void main(String[] args){
		 System.out.println(nthUglyNumber(10));
	 }
}


public class ShellSort {
	public static Comparable[] shellSort(Comparable[] a){
		int len = a.length;
		int h = 1;
		while(h<len/3) h = 3*h+1;
		while(h>=1){
			for(int i = 0; i < len; i ++){
				for(int j = i;j-h>=0&&a[j].compareTo(a[j-h])<0;j-=h){
					Comparable temp = a[j];
					a[j] = a[j-h];
					a[j-h] = temp;
				}
			}
			h/=3;
		}
		return a;
		
	}
	
	public static void main(String[] args){
		Integer[] a = {2,8,4,53,1,-2,9,-3,1,22};
		System.out.println(shellSort(a));
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i]+",");
		}
	}
}

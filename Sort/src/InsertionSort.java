
public class InsertionSort {
	public static Comparable[] insertionSort(Comparable[] a){
		int len = a.length;
		for(int i = 1; i < len;i++){
			for(int j = i; j > 0&&(a[j].compareTo(a[j-1])<0); j--){
					Comparable temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
			}
		}
		return a;
	}
	
	public static void main(String[] args){
		Integer[] a = {2,8,4,53,1,-2,9};
		System.out.println(insertionSort(a));
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i]+",");
		}
	}
}

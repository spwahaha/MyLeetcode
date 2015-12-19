
public class SelectionSort {
	public static Comparable[] selectionSort(Comparable[] a){
		int len = a.length;
		for(int i = 0; i < len;i++){
			int minIndex = i;
			for(int j = i; j < len; j++){
				if(a[j].compareTo(a[minIndex])<0){
					minIndex = j;
				}
			}
			Comparable temp = a[i];
			a[i] = a[minIndex];
			a[minIndex] = temp;
		}
		return a;
	}
	
	
	public static void main(String[] args){
		Integer[] a = {2,8,4,53,1,-2,9};
		System.out.println(selectionSort(a));
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i]+",");
		}
	}
}

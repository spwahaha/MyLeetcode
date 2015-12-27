
public class QuickSort {
	public static void quickSort(Comparable[] a){
		int len =  a.length;	
		int low = 0;
		int hi = len-1;
		quickSort(a,low,hi);
	}
	
	private static void quickSort(Comparable[] a,int lo,int hi){

		if(lo<=hi){
			int pivot = partition(a,lo,hi);
			quickSort(a,lo,pivot-1);
			quickSort(a,pivot+1,hi);
		}
	}
	
	private static int partition(Comparable[] a, int lo, int hi){
		Comparable pivot = a[lo];
		int i = lo+1;
		int j = hi;
		while(true){
			while(i<hi&&a[i].compareTo(pivot)<0)
				i++;
			while(j>lo&&a[j].compareTo(pivot)>0)
				j--;
			if(i>=j) break;
			Comparable temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		Comparable temp = a[lo];
		a[lo] = a[j];
		a[j] = temp;	
		return  j;
	}
	
	public static void main(String[] args){
//		Comparable[] a = {68,2,53,4,1,1,9,9,-2,3,3,-1,-1,22};
		Comparable[] a = {5,5};

		quickSort(a);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i]+",");
		}
	}
}

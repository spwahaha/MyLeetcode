
public class MergeSort {
	public static void mergeSort(Comparable[] a){
		int i = 0;
		int j = a.length-1;
		sort(a,i,j);
	}
	
	private static void sort(Comparable[] a, int i, int j){
		if(j<=i)
			return ;
		int mid = i+(j-i)/2;
		sort(a,i,mid);
		sort(a,mid+1,j);
		merge(a,i,mid,j);
	}
	
	private static void merge(Comparable[] a, int lo,int mid, int hi ){
		Comparable[] aux = new Comparable[a.length];
		for(int k = 0; k < aux.length;k++){
			aux[k] = a[k];
		}
		int m = lo;
		int i = lo;
		int j = mid+1;
		
		while(m<=hi){
			if(i>mid) a[m++] = aux[j];
			else if(j>hi) a[m++] = aux[i];
			else if(aux[i].compareTo(aux[j])<0)
				a[m++] = aux[i++];
			else a[m++] = aux[j++];	
		}
	}
	
	public static void main(String[] args){
		Comparable[] a = {8,2,53,4,1,9,-2,3,-1,22};
		mergeSort(a);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i]+",");
		}
	}
	
	
}

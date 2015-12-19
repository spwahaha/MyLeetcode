
public class Heapsort {
	
	public static void sort(Comparable[] a){
		int N = a.length;
		for(int k = N/2;k>=1;k--){
			sink(a,k,N);
		}
		
		while(N>1){
			exch(a,1,N--);
			sink(a,1,N);
		}
	}
	
	private static void exch(Comparable[] com, int i,
			int j){
		Comparable temp = com[i-1];
		com[i-1] = com[j-1];
		com[j-1] = temp;
	}
	
	private static void sink(Comparable[] com, int k, int N){
		while(2*k<N){
			int j = 2*k;
			if(j<N&&less(com,j,j+1)) j++;
			if(!less(com,k,j)) break;
			exch(com,k,j);
			k = j;
		}
	}
	
	private void swim(Comparable[] com, int k){
		while(k>1&&less(com,k,k/2)){
			exch(com,k,k/2);
			k = k/2;
		}
	}
	
	private static boolean less(Comparable[] com,int i, int j){
		return com[i-1].compareTo(com[j-1])<0;
	}
	
	public static void main(String[] args){
		Integer[] a = {2,1,4,5,6,3,3,0};
		sort(a);
		for(int i =0; i < a.length; i++){
			System.out.println(a[i]);
		}
	}
}

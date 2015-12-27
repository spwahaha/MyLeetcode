package SortingandSearching;

public class NosizeSearch {
	
	static class Listy{
		int size;
		int[] array;
		public Listy(){
			this.size = 0;
			array = new int[10];
		}
		
		public int elementAt(int i){
			if(i-1 >= size){
				return -1; 
			}
			return array[i];
		}
		
		public void add(int n){
			array[size++] = n;
		}
	}
	
	public static int search(Listy list, int n){
		int index = 1;
		while(list.elementAt(index)!=-1 && list.elementAt(index) < n){
			index = index * 2;
		}
		
		return search(list, index/2, index, n);
	}
	
	private static int search(Listy list, int start, int end, int n){
		
		while(start <= end){
			int mid = (start + end)/2;
			int val = list.elementAt(mid);
			if(val == n) return mid;
			if(val == -1 || val > n){
				end = mid-1;
			}else{
				start = mid + 1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args){
		Listy list = new Listy();
		for(int i= 0; i < 6; i++){
			list.add(i);
		}
		System.out.println(list.elementAt(7));
		System.out.println(search(list, 4));
		
	}
}

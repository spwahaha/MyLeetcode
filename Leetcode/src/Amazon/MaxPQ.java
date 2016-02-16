package Amazon;

public class MaxPQ<Key extends Comparable<Key>>{
	private Key[] pq;
	private int N = 0;
	public MaxPQ(int maxN){
		pq = (Key[]) new Comparable[maxN + 1];
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public int size(){
		return N;
	}
	
	public void insert(Key v){
		pq[++N] = v;
		swim(N);
	}
	
	public Key delMax(){
		Key max = pq[1];
		exch(1, N--);
		pq[N + 1] = null;
		sink(1);
		return max;
	}
	
	private void swim(int k){
		while(k > 1 && less(k/2, k)){
			exch(k / 2, k);
			k = k / 2;
		}
	}
	
	private void sink(int k){
		while(2 * k <= N){
			int j = 2 * k;
			if(j < N && less(j, j + 1)) j++;
			if(!less(k, j)) break;
			exch(j, k);
			k = j;
		}
	}
	
	private boolean less(int j, int k){
		return pq[j].compareTo(pq[k]) < 0;
	}
	
	private void exch(int j, int k){
		Key temp = pq[j];
		pq[j] = pq[k];
		pq[k] = temp;
	}
	
	public static void main(String[] args){
		MaxPQ pq = new MaxPQ<Integer>(15);
		for(int i = 0; i < 10; i++){
			if(i % 2 == 0){
				pq.insert(i);
			}else{
				pq.insert(-i);
			}
		}
		
		while(!pq.isEmpty()){
			System.out.print(pq.delMax() + ",");
		}
	}
}

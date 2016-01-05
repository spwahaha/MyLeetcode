import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSorted {
	class Element{
		public int element;
		public int arrIndex;
		public int index;
		
		public Element(int element, int arrIndex, int index){
			this.element = element;
			this.arrIndex = arrIndex;
			this.index = index;
		}
	}
	
	class ElementSort implements Comparator<Element>{
		public int compare(Element e1, Element e2){
			return e1.element - e2.element;
		}
	}
	
	public int[] sort(int n, int k, int[][] arr){
		int[] res = new int[n*k];
		PriorityQueue<Element> pq = new PriorityQueue<Element>(k,new ElementSort());
		for(int i = 0; i < k; i++){
			pq.add(new Element(arr[i][0], i, 0));
		}
		int index = 0;
		while(!pq.isEmpty()){
			Element ele = pq.poll();
			res[index] = ele.element;
			
			if(ele.index+1<n){
				pq.add(new Element(arr[ele.arrIndex][ele.index+1], ele.arrIndex, ele.index+1));
			}
			index++;
		}
		return res;
	}
	
	
	public static void main(String[] args){
		MergeKSorted merge = new MergeKSorted();
		int[][] nums = {{1,3,5,7},{2,4,6,8},{1,2,3,4}};
		int[] res = merge.sort(4,3,nums);
		for(int i=0; i < res.length; i++){
			System.out.print(res[i] + "  ");
		}
	}
}

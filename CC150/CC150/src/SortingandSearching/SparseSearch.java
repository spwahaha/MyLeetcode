package SortingandSearching;

public class SparseSearch {
	
	public static int search(String[] strs, String str){
		if(strs == null || str == null) return -1;
		return search(strs, str, 0, strs.length);
	}
	
	private static int search(String[] strs, String str, int start, int end){
		
		while(start <= end){
			int mid = (start + end)/2;
			
			if(strs[mid].isEmpty()){
				int left = mid - 1;
				int right = mid +1;
				while(true){
					if(left>=start && !strs[left].isEmpty()){
						mid = left;
						break;
					}
					if(right <= end && !strs[right].isEmpty()){
						mid = right;
						break;
					}
					left--;
					right++;
				}
			}
			
			int comp = strs[mid].compareTo(str);
			
			if(comp == 0){
				return mid;
			}
			if(comp > 0){
				end = mid -1;
			}else{
				start = mid + 1;
			}
			
		}
		
		return -1;
	}
	
	public static void main(String[] args){
		String[] strs = {"", "abc", "", "", "", "cba", "", "", "def"};
		System.out.println(search(strs, "cba"));
	}
}

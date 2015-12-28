package SortingandSearching;

public class RankFromStream {
	
	public RankNode root;
	
	public void track(int n){
		if(root == null){
			root = new RankNode(n);
		}else{
			root.insert(n);
		}
	}
	
	public int getRankFromNumber(int number){
		return root.getRank(number);
	}
	
	static class RankNode{
		public RankNode left;
		public RankNode right;
		public int leftSize;
		public int val;
		
		public RankNode(int val){
			this.val = val;
		}
		
		public void insert(int n){
			if(n <= this.val){
				if(this.left == null){
					this.left = new RankNode(n);
				}else{
					this.left.insert(n);
				}
				this.leftSize++;
			}else{
				if(this.right == null){
					this.right = new RankNode(n);
				}else{
					this.right.insert(n);
				}
			}
		}
		
		public int getRank(int n){
			if(n == val){
				return this.leftSize;
			}
			
			if(n < val){
				if(this.left == null) return -1;
				else return this.left.getRank(n);
			}else{
				if(this.right == null) return -1;
				return this.leftSize + 1 + this.right.getRank(n);
			}

		}
				
	}
	
	public static void main(String[] args){
		RankFromStream n0 = new RankFromStream();
		int[] nums = {5,1,4,4,5,9,7,13,3};
		for(int i = 0; i < nums.length; i++){
			n0.track(nums[i]);
		}
		
		System.out.println(n0.getRankFromNumber(1));
		System.out.println(n0.getRankFromNumber(3));
		System.out.println(n0.getRankFromNumber(4));
		
	}
	
}

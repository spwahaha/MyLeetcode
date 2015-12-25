package TreesAndGraphs;

import java.util.Random;

public class RandomNode {
	/**
	 * construct a binary search tree class, support getRandomNode() method,
	 * return a random node from the tree
	 */
	public static class TreeNode{
		private int data;
		public TreeNode left;
		public TreeNode right;
		private int size;
		
		public TreeNode(int n){
			this.data = n;
			this.size = 0;
		}
		
		public void insert(int n){
			if(n <= data){
				if(left == null){
					left = new TreeNode(n);
				}else{
					left.insert(n);
				}
			}else{
				if(right == null){
					right = new TreeNode(n);
				}else{
					right.insert(n);
				}
			}
			size++;
		}
	
		public TreeNode find(int n){
			if(this==null) return null;
			if(data == n){
				return this;
			}else if(data < n){
				if(left==null){
					return null;
				}else{
					return left.find(n);
				}
			}else{
				if(right == null){
					return null;
				}else{
					return right.find(n);
				}
			}
		}
		
		public int data(){
			return this.data;
		}
		
		public int size(){
			return this.size;
		}
		
		/**
		 * first kind of random Node, call create new random() multiple times
		 * 
		 * return a random node in the tree
		 * @return random node
		 */
		public TreeNode getRandomNode(){
			Random rand = new Random();
			int index = rand.nextInt(size);
			int leftSize = this.left==null?0:this.left.size();
			if(index == leftSize){
				return this;
			}else if(index < leftSize){
				return this.left.getRandomNode();
			}else{
				return this.right.getRandomNode();
			} 
		}
		
		public TreeNode getRandomNode2(){
			if(this==null) return null;
			Random rand = new Random();
			int index = rand.nextInt(this.size());
			return getIthNode(index);
		}

		private TreeNode getIthNode(int index) {
			// TODO Auto-generated method stub
			int leftSize = left==null?0:left.size();
			if(index == leftSize){
				return this;
			}else if(index < leftSize){
				return getIthNode(index);
			}else {
				return getIthNode(index - (leftSize+1));
			}
		}	
	}
	
	public static void main(String[] args){
		TreeNode n0 = new TreeNode(5);
		for(int i = 0; i < 10; i++){
			n0.insert(i);
		}	
		System.out.println(n0.getRandomNode().data);
	}
}

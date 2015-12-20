package TreesAndGraphs;

public class MinimalTree {
	public static TreeNode createMinimalTree(int[] array){
		return createHelper(array,0,array.length-1);
	}
	
	private static TreeNode createHelper(int[] array, int begin, int end){
		if(end < begin){
			return  null;
		}
		
		int mid = begin + (end - begin)/2;
		TreeNode root = new TreeNode(array[mid]);
		root.left = createHelper(array, begin, mid-1);
		root.right = createHelper(array, mid+1, end);
		return root;
	}
	
	public static void inorder(TreeNode root){
		if(root == null) return;
		inorder(root.left);
		System.out.print(root.val + "   ");
		inorder(root.right);
	}
	
	public static void main(String[] args){
		int[] nums = {1,2,3,4,5,6};
		TreeNode root = createMinimalTree(nums);
		inorder(root);
	}
}

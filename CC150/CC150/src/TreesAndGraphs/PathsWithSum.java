package TreesAndGraphs;

import java.util.Hashtable;

public class PathsWithSum {
	/**
	 * brute force way, start from all the node to count 
	 * during recursion, if sum == targetSum, increase total
	 * @param root 
	 * @param targetSum
	 * @return number of paths that sum equal to target sum
	 */
	public static int countPaths(TreeNode root, int targetSum){
		if(root==null) return 0;
		// count from this node
		int paths = countPathsFromNode(root, targetSum, 0);
		
		// recursive this process
		return paths + countPaths(root.left, targetSum)
				+ countPaths(root.right, targetSum);		
	}
	
	/**
	 * start from root to get paths number that path sum == target sum
	 * @param root start node of the path
	 * @param targetSum 
	 * @param sum dynamic sum during recursion
	 * @return
	 */
	private static int countPathsFromNode(TreeNode root, int targetSum, int sum){
		if(root == null) return 0;
		int total = 0;
		if(sum + root.val == targetSum){
			total++;
		}
		
		return total + countPathsFromNode(root.left, targetSum, sum + root.val)
				+ countPathsFromNode(root.right, targetSum, sum+root.val);
		
	}
	
	
	public static int countPaths2(TreeNode root, int targetSum){
		return countPathsWithSums(root, targetSum, 0, new Hashtable<Integer, Integer>());
	}
	
	private static int countPathsWithSums(TreeNode root, int targetSum, int sum, Hashtable<Integer, Integer> path){
		if(root == null) return 0;
		int runningSum = sum + root.val;
		int diff = runningSum - targetSum;
//		Integer paths = path.get(diff);
		int totalPaths = path.get(diff)==null?0:path.get(diff);
		
		if(runningSum == targetSum){
			totalPaths++;
		}
		
		updateHashtable(path, runningSum, 1);
		totalPaths += countPathsWithSums(root.left, targetSum, runningSum, path);
		totalPaths += countPathsWithSums(root.right, targetSum, runningSum, path);
		updateHashtable(path, runningSum, -1);
		
		return totalPaths;
	}
	
	private static void updateHashtable(Hashtable<Integer,Integer> hs, int runningSum, int delta){
		int value = hs.get(runningSum) == null?0+delta:hs.get(runningSum) + delta;
		if(value==0){
			hs.remove(runningSum);
		}else{
			hs.put(runningSum, value);
		}
	}
	
	public static void main(String[] args){
		TreeNode n0 = new TreeNode(8);
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(-3);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(2);
		TreeNode n5 = new TreeNode(11);
		TreeNode n6 = new TreeNode(-10);
		TreeNode n7 = new TreeNode(-2);
		TreeNode n8 = new TreeNode(1);
		
		n0.left = n1;
		n0.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n4.right = n8;
		System.out.println(countPaths2(n0, 8));
		
	}
	
}

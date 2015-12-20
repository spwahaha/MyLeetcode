package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ListOfDepth {
	// recursive way
	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
			ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
			createLevelLinkedList(root, lists, 0);
			return lists;
	}
	
	// create level linkedlist by recursion
	private static void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>>lists, int level){
		if(root == null){
			return;
		}
		LinkedList list = null;
		//if this level is not touched yet, add an new list to lists
		if(level == lists.size()){
			list = new LinkedList<TreeNode>();
			lists.add(list);
		}else{
			// if this level is already touched, then get it and process it
			list = lists.get(level);
		}
		
		list.add(root);
		createLevelLinkedList(root.left, lists, level+1);
		createLevelLinkedList(root.right, lists, level+1);
	}
	
	// iterative way
	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList2(TreeNode root){
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int size = 0;
		while(!queue.isEmpty()){
			size = queue.size();
			LinkedList<TreeNode> list = new LinkedList<TreeNode>();
			for(int i=0; i<size; i++){
				TreeNode node = queue.poll();
				list.add(node);
				if(node.left!=null) queue.add(node.left);
				if(node.right!=null) queue.add(node.right);
			}
			lists.add(list);
		}
		return lists;		
	}
	
	
	public static void main(String[] args){
		TreeNode n0 = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		
		n0.left = n1;
		n0.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.left = n5;
		n2.right = n6;
		ArrayList<LinkedList<TreeNode>> res = createLevelLinkedList2(n0);
		System.out.println(res);
		
	}
	
	
	
	
	
	
}

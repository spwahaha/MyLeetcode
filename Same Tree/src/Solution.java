
public class Solution {

	 
	  public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
	  public static boolean isSameTree(TreeNode p, TreeNode q) {
		  if(p==null&&q==null) return true;
		  if(p.val!=q.val||(p==null&&q!=null)||(p!=null&&q==null)) return false;
		  return(isSameTree(p.left,q.left)&&isSameTree(p.right,q.right));	  
	  }
		public static void main(String[] args){
			TreeNode n1 = new TreeNode(1);
			TreeNode n3 = new TreeNode(3);
			TreeNode n2 = new TreeNode(2);
			TreeNode n6 = new TreeNode(6);
			TreeNode n5 = new TreeNode(5);
			TreeNode n4 = new TreeNode(4);
			n4.left = n2;
			n4.right = n5;
			n2.left = n1;
			n2.right = n3;
//			n5.left = n3;
			n5.right = n6;
			
			
			TreeNode m1 = new TreeNode(1);
			TreeNode m3 = new TreeNode(3);
			TreeNode m2 = new TreeNode(2);
			TreeNode m6 = new TreeNode(6);
			TreeNode m5 = new TreeNode(5);
			TreeNode m4 = new TreeNode(4);
			m4.left = m2;
			m4.right = m5;
			m2.left = m1;
			m2.right = m3;
//			n5.left = n3;
			m5.right = m6;

			System.out.println(isSameTree(n3,m4));
		}
	  
}

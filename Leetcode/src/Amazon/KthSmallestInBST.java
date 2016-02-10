package Amazon;

public class KthSmallestInBST {
	
    int cur = 0;
    int kth = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        kthSmallest(root.left, k);
        cur++;
        if(cur == k){
            kth = root.val;
        }
        kthSmallest(root.right, k);
        return kth;
    }
    
    public int kthSmallest2(TreeNode root, int k){
    	int cnt = countNodes(root.left);
    	if(cnt + 1 == k){
    		return root.val;
    	}else if(k <= cnt){
    		return kthSmallest2(root.left, k);
    	}else{
    		return kthSmallest2(root.right, k - cnt - 1);
    	}
    }
    
    private int countNodes(TreeNode root){
    	if(root == null){
    		return 0;
    	}
    	return countNodes(root.left) + countNodes(root.right) + 1;
    }
}

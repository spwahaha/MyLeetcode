package Amazon;

import java.util.LinkedList;
import java.util.Queue;

public class BSTIterator {
    Queue<Integer> q = new LinkedList<Integer>();
    public BSTIterator(TreeNode root) {
        inorder(root, q);
    }
    
    private void inorder(TreeNode root, Queue<Integer> q){
        if(root == null){
            return;
        }
        inorder(root.left, q);
        q.add(root.val);
        inorder(root.right, q);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !q.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        return q.poll();
    }
}

package Amazon;

import java.util.Stack;

public class BSTIterator2 {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    public BSTIterator2(TreeNode root) {
        if(root == null){
            return;
        }
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        int val = node.val;
        node = node.right;
        while(node != null){
            stack.push(node);
            node = node.left;
        }
        return val;
    }
}

package Amazon;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null){
            return res;
        }
        helper(res, new ArrayList<Integer>(), root, sum);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> list, TreeNode root, int sum){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            if(root.val == sum){
                list.add(root.val);
                res.add(new ArrayList<Integer>(list));
                list.remove(list.size() - 1);
            }
            return;
        }else{
            list.add(root.val);
            helper(res, list, root.left, sum - root.val);
            helper(res, list, root.right, sum - root.val);
            list.remove(list.size() - 1);
        }
    }
}

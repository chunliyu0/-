/* Analysis - DFS

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<>();
        
        if(root == null)return ret;
        curr.add(root.val);
        dfs(root, ret, curr, sum-root.val);
        return ret;
    }
    
    public void dfs(TreeNode node, List<List<Integer>> ret, List<Integer> curr, int sum){
        if(node.left == null && node.right == null){
            if(sum == 0){
                ret. add(curr);
            }
            return;
        }
        if(node.left!=null){
            List<Integer> list = new ArrayList<Integer>(curr);
            list.add(node.left.val);
  
            int tmp = sum - node.left.val;
            dfs(node.left, ret, list, tmp);
        }
        if(node.right!=null){
            List<Integer> list = new ArrayList<Integer>(curr);
            list.add(node.right.val);

            int tmp = sum - node.right.val;
            dfs(node.right, ret, list, tmp);
        }
    }
}

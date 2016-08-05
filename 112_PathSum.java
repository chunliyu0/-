/* Analysis - DFS */

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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)return false;
        return dfs(root, root.val, sum);
    }
    
    public boolean dfs(TreeNode node, int curr, int sum) {
        if(node.left == null && node.right == null) 
            return curr == sum;
            
        boolean flag1 = false, flag2 = false;
        if(node.left!=null){
            int tmp = curr + node.left.val;
            flag1 = dfs(node.left, tmp, sum);
        }
        if(node.right!=null){
            int tmp = curr + node.right.val;
            flag2 = dfs(node.right, tmp, sum);
        }
        return flag1 || flag2;
    }
}

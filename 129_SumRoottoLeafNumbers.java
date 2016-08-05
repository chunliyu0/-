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
    int sum;
    
    public int sumNumbers(TreeNode root) {
        if(root == null)return 0;
        //Integer sum = new Integer(0);
        dfs(root, root.val);
        return sum;
    }
    
    public void dfs(TreeNode node, int val) {
        if(node.left==null && node.right==null){
            sum += val;
            return;
        }
        if(node.left!=null){
            int tmp = val*10 + node.left.val;
            dfs(node.left, tmp);
        }
        if(node.right!=null){
            int tmp = val*10 + node.right.val;
            dfs(node.right,  tmp);
        }
    }
        
}

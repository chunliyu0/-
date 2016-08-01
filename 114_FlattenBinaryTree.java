/* Analysis - Preorder
(1) flatter the right first;
(2) if the left subtree is null, just return; else flattern the left and attach the flattened right to it;
*/

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
    public void flatten(TreeNode root) {
        if(root==null || root.left == null && root.right == null)return;
        
        flatten(root.right);
        if(root.left == null)return;
        
        TreeNode p = root.left;
        flatten(root.left);
        while(p.right != null)
            p = p.right;
        p.right = root.right;
        root.right = root.left;
        root.left = null;
    }
}

/* Analysis - Travesal
(1) left leaves not the left nodes
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
    public int sumOfLeftLeaves(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        int sum = 0;
        if(root != null)que.add(root);
        while(!que.isEmpty()){
            TreeNode tmp = que.remove();
            if(tmp.left != null){
                que.add(tmp.left);
                if(tmp.left.left == null && tmp.left.right == null)
                    sum += tmp.left.val;
            }
            if(tmp.right != null)
                que.add(tmp.right);
        }
        
        return sum;
    }
}

/* Analysis - DFS
Since the root is the only one without ->, so add it first
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        if(root==null)return ret;
        
        String curr = "" + root.val;
        dfs(root, ret, curr);
        return ret;
    }
    
    public void dfs(TreeNode node, List<String> list, String curr){
        if(node.left == null && node.right == null){
            list.add(curr);
            return;
        }
        if(node.left!=null){
            String tmp = curr + "->" + node.left.val;
            dfs(node.left, list, tmp);
        }
        if(node.right!=null){
            String tmp = curr + "->" + node.right.val;
            dfs(node.right, list, tmp);
        }
    }
}

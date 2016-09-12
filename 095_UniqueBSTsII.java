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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ret = new ArrayList<TreeNode>();
        if(n==0)return ret;
        
        dfs(ret, 1, n);
        return ret;
    }
    
    public void dfs(List<TreeNode> ret, int start, int end){
        if(start > end){
            ret.add(null);//null is also an element in the list
            return;
        }
        
        for(int i = start; i <= end; i++){
            List<TreeNode> left = new ArrayList<TreeNode>();
            List<TreeNode> right = new ArrayList<TreeNode>();
            dfs(left, start, i-1);
            dfs(right, i+1, end);
            
            
            for(TreeNode lchild: left){
                for(TreeNode rchild: right){
                    TreeNode node = new TreeNode(i);
                    node.left = lchild;
                    node.right = rchild;
                    ret.add(node);
                }
            }
        }
    }
}

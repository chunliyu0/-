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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(root == null)return ret;
        
        while(!isLeaf(root)){
            List<Integer> tmp = new ArrayList<Integer>();
            dfs(root, tmp);
            //System.out.println(tmp.toString());
            ret.add(tmp);
        }
        List<Integer> tmp = new ArrayList<Integer>();
        tmp.add(root.val);
        ret.add(tmp);
        return ret;
    }
    
    public void dfs(TreeNode parent, List<Integer> tmp){
        if(parent.left!=null){
            if(isLeaf(parent.left)){
                tmp.add(parent.left.val);
                parent.left = null;
            }
            else{
                dfs(parent.left, tmp);
            }
        }
        if(parent.right!=null){
            if(isLeaf(parent.right)){
                tmp.add(parent.right.val);
                parent.right = null;
            }
            else{
                dfs(parent.right, tmp);
            }
        }
    }
    
    public boolean isLeaf(TreeNode node){
        if(node.left == null && node.right == null){
            return true;
        }
        return false;
    }
    
}

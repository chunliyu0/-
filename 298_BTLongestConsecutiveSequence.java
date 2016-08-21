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
    
    public int longestConsecutive(TreeNode root) {  
        if(root == null)return 0;
        return dfs(root, 1);//current node has been considered
    }  
      
    private int dfs(TreeNode node, int len) { 
        if(node.left == null && node.right == null)return len;
        
        int left = 0, right = 0;
        if(node.left != null){
            if(node.left.val == node.val + 1){
                left = dfs(node.left, len + 1);
            }
            else{
                left = Math.max(len, dfs(node.left, 1));//restart searching, len == 1
            }
        }
        
        if(node.right != null){
            if(node.right.val == node.val + 1){
                right = dfs(node.right, len + 1);
            }
            else{
                right = Math.max(len, dfs(node.right, 1));//restart searching, len == 1
            }
        }
        
        return Math.max(left, right);
    }  
} 

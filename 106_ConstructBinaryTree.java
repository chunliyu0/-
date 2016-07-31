/* Analysis
Recursively built the left and right subtree
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
    public int search(int target, int[] inorder){
        for(int i = 0; i<inorder.length; i++){
            if(target == inorder[i])
                return i;
        }
        return -1;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || inorder.length == 0)return null;
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        
        int idx = search(postorder[postorder.length - 1], inorder);
        
        if(idx > 0){
            int[] leftInorder = Arrays.copyOfRange(inorder, 0, idx);
            int[] leftPostorder = Arrays.copyOfRange(postorder, 0, idx);
            root.left = buildTree(leftInorder, leftPostorder);
        }
        if(idx < inorder.length - 1){
            int[] rightInorder = Arrays.copyOfRange(inorder, idx+1, inorder.length);
            int[] rightPostorder = Arrays.copyOfRange(postorder, idx, postorder.length-1);
            root.right = buildTree(rightInorder, rightPostorder);
        }
        return root;
    }
}

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
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || preorder.length == 0)return null;
        TreeNode root = new TreeNode(preorder[0]);
        
        int idx = search(preorder[0], inorder);
        
        if(idx > 0){
            int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1 + idx);
            int[] leftInorder = Arrays.copyOfRange(inorder, 0, idx);
            root.left = buildTree(leftPreorder, leftInorder);
        }
        if(idx < inorder.length - 1){
            int[] rightPreorder = Arrays.copyOfRange(preorder, idx+1, preorder.length);
            int[] rightInorder = Arrays.copyOfRange(inorder, idx+1, inorder.length);
            root.right = buildTree(rightPreorder, rightInorder);
        }
        return root;
    }
}

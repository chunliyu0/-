//https://discuss.leetcode.com/topic/49665/1-ms-simple-recursive-java-solution-beat-95

/* Analysis - Recursion
(1) Preoccupy the ret list by filling up empty lists.
(2) Then fill up the empty lists by traverse the nodes one by one
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(root == null)return ret;
    
        Stack<TreeNode> currLevel = new Stack<>();
        boolean isLeft = true;
        
        currLevel.push(root);
        while(!currLevel.isEmpty()){//process level by level
            List<Integer> curr = new ArrayList<>();
            Stack<TreeNode> nextLevel = new Stack<>();
            
            while(!currLevel.isEmpty()){//process level by level
                TreeNode tmp = currLevel.pop();
                curr.add(tmp.val);
            
                //deal with the next level
                if(isLeft){
                    if(tmp.left != null)nextLevel.push(tmp.left);
                    if(tmp.right != null)nextLevel.push(tmp.right);
                }
                else{
                    if(tmp.right != null)nextLevel.push(tmp.right);
                    if(tmp.left != null)nextLevel.push(tmp.left);
                }
            }
            
            ret.add(curr);
            currLevel = nextLevel;
            isLeft = !isLeft;
        }
        return ret;
    }
}

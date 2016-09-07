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
        dfs(ret, root, 1);//root is on the first level
        return ret;
    }
    
    public void dfs(List<List<Integer>> ret, TreeNode node, int level){//the left branch will be settled first
        if(node == null)return;
        
        if(ret.size() < level){//preemption
            List<Integer> list = new ArrayList<>();
            ret.add(list);
        }
        
        if((level&1)==1){//on the odd level, the nodes are arranged from left to right;
            ret.get(level - 1).add(node.val);
        }
        else{
            ret.get(level - 1).add(0, node.val);
        }
        
        dfs(ret, node.left, level + 1);
        dfs(ret, node.right, level + 1);
    }
}

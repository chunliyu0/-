/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        TreeNode p = root;
        StringBuilder sb = new StringBuilder();
        
        if(root != null){
            que.add(root);
            sb.append(root.val);
        }

        while(!que.isEmpty()){
            TreeNode tmp = que.remove();
            
            if(tmp.left == null)
                sb.append(",#");
            else{
                sb.append("," + tmp.left.val);
                que.add(tmp.left);
            }
            
            if(tmp.right == null)
                sb.append(",#");
            else{
                sb.append("," + tmp.right.val);
                que.add(tmp.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        if(arr.length < 2)
            return null;
        
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        que.add(root);
        
        int i = 1;
        while(!que.isEmpty()){
            TreeNode tmp = que.remove();
            
            if(arr[i].equals("#"))
                tmp.left = null;
            else{
                tmp.left = new TreeNode(Integer.parseInt(arr[i]));
                que.add(tmp.left);
            }
            i++;
            
            if(arr[i].equals("#"))
                tmp.right = null;
            else{
                tmp.right = new TreeNode(Integer.parseInt(arr[i]));
                que.add(tmp.right);
            }
            i++;
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

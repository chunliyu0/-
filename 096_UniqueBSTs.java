/* Analysis - DP 
(1) 以i为根节点的树，其左子树由[0, i-1]构成， 其右子树由[i+1, n]构成。
(2) Count[n] = ∑ Count[0...k] * [ k+1....i]     0<=k<i-1
*/

public class Solution {
    public int numTrees(int n) {
        int [] ref = new int[n + 1];
        ref[0] = 1;//empty BST
        ref[1] = 1;//there is only one BST when there is only one node
        
        for(int i = 2; i<=n; i++){//the number of BSTs with different number of nodes
            for(int j = 1; j <= i; j++){//sum up all the BSTs starting with different values
                ref[i] += ref[j-1]*ref[i-j];
            }
        }
        
        return ref[n];
    }
}

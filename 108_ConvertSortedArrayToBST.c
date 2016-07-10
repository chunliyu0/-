/* Analysis - Binary Search
recursive
*/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
struct TreeNode* getBST(int* nums, int low, int high) {
    struct TreeNode* bst = (struct TreeNode *)malloc(sizeof(struct TreeNode));
    
    if(low > high)
        return NULL;
    if(low == high) {
        bst->val = nums[low];
        bst->left = NULL;
        bst->right = NULL;
        return bst;
    }
    
    int mid = low + (high - low)/2;
    bst->val = nums[mid];
    bst->left = getBST(nums, low, mid-1);
    bst->right = getBST(nums, mid+1, high);
    
    return bst;
} 
 
struct TreeNode* sortedArrayToBST(int* nums, int numsSize) {
    if(nums==NULL || numsSize == 0)return NULL;
    return getBST(nums, 0, numsSize-1);
}

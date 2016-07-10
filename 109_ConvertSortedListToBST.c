/* Analysis - two pointers
*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
struct TreeNode* buildBST(struct ListNode* head, struct ListNode* end) {
    struct TreeNode* bst = (struct TreeNode*) malloc(sizeof(struct TreeNode));
    struct ListNode* p = head, *q = head;
    
    if(head == end)
        return NULL;
    
    while(p!=end && p->next!=end){
        p = p->next->next;
        q = q->next;
    }
    bst->val = q->val;
    bst->left = buildBST(head, q);//end will not be considered
    bst->right = buildBST(q->next, end);
    
    return bst;
}

struct TreeNode* sortedListToBST(struct ListNode* head) {
    if(head == NULL)return NULL;
    return buildBST(head, NULL);
}

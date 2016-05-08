/*save the result to another list l1 or l2 (ret),
it will change the link only after it finds out all the number which is less.
*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2) {
    if(l1==NULL)return l2;
    if(l2==NULL)return l1;
    
    struct ListNode *ret = l1->val < l2->val ? l1 : l2;
    struct ListNode *pre;
    
    while(true){
        //creep l1 until it finds all the numbers which are less than l2 and append l2 to these number in l1
        while(l1->val < l2->val){
            pre = l1;
            l1 = l1->next;
            if(l1==NULL){
                pre->next = l2;
                return ret;
            }
        }
        pre->next = l2;
        
        ////creep l2 until it finds all the numbers which are not greater than l1 and append l1 to these number in l2
        while(l2->val <= l1->val&&l2!=NULL){
            pre = l2;
            l2 = l2->next;
            if(l2==NULL){
                pre->next = l1;
                return ret;
            }
        }
        pre->next = l1;
    }
}

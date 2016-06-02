/* Analysis
(1) Similar to add binary
*/
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2) {
    struct ListNode *p = l1, *q = l2; 
    struct ListNode *l3 = (struct ListNode*)malloc(sizeof(struct ListNode)), *r = l3;
    int carry = 0;
    
    //add the corresponding digits
    while(p||q){
        if(p){
            carry += p->val;
            p = p->next;
        }
        if(q){
            carry += q->val;
            q = q->next;
        }
        struct ListNode* tmp = (struct ListNode*)malloc(sizeof(struct ListNode));
        tmp->val = carry % 10;
        carry = carry/10;
        r->next = tmp;
        r = r->next;
    }
    
    // check if there is carry at the MSB
    if(carry){
         struct ListNode* tmp = (struct ListNode*)malloc(sizeof(struct ListNode));
         tmp->val = 1;
         tmp->next = NULL;
         r->next = tmp;
    }
    else{
         r->next = NULL;
    }
    return l3->next;
}

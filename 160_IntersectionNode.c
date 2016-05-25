/* Analysis
Decide if two lists have the intersection based on the last node.
Get the lengths of the two nodes and move the longer node steps further until it gets the starting point of the shorter node.
move the two pointers together to see where they meet.
*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode *getIntersectionNode(struct ListNode *headA, struct ListNode *headB) {
    //Base cases
    if(headA ==NULL || headB == NULL)return NULL;
    
    struct ListNode *p = headA, *q = headB;
    int count1 = 1, count2 = 1, diff;
    
    //get the lengths for headA and headB.
    while(p->next!=NULL){
        p = p->next;
        count1 ++;
    }
    while(q->next!=NULL){
        q = q->next;
        count2 ++;
    }
    //if they don't share the last node, there is no intersaction. else intersection must exist.
    if(p!=q) return NULL;
    
    //move the longer list diff steps further, p points to the longer list while q points to the shorter list
    diff = count1 - count2;
    if(diff>=0){
        q = headB;
        p = headA;
    }
    else{
        diff *= -1;
        q = headA;
        p = headB;
    }
    while(diff>0){
        p = p->next;
        diff--;
    }
    
    //check the intersection node.
    while(p!=q){
        p = p->next;
        q = q->next;
    }
    return p;
}

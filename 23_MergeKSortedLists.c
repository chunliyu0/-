/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
 
struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2) {
    if (!l1) return l2;
    if (!l2) return l1;
    struct ListNode *head, *f, *s, *p;
    if (l1->val < l2->val) {
        head = l1;
        f = l1->next;
        s = l2;
    }
    else {
        head = l2;
        f = l1;
        s = l2->next;
    }
    p = head;
    for (; f && s;) {
        if (f->val < s->val) {
            p->next = f;
            f = f->next;
        }
        else {
            p->next = s;
            s = s->next;
        }
        p = p->next;
    }
    if (f) p->next = f;
    else p->next = s;
    return head;
}
struct ListNode* mergeKLists(struct ListNode** lists, int listsSize) {
    if (!listsSize) return 0;
    if (listsSize == 1) return lists[0];
    int i, id = 0;
    for (i = 0; i < listsSize; ) {
        if (i + 1 < listsSize) {
            lists[id++] = mergeTwoLists(lists[i], lists[i + 1]);
            i += 2;
        }
        else lists[id++] = lists[i++];
    }
    return mergeKLists(lists, id);
}

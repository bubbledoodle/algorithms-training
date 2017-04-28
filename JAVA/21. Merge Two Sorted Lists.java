/*
## Description
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
## Thinkings:
1.  [problem] about this kind, if using for, probably it is really hard to acquire a specific loop time. While statement on the other hand is also hard cuz one LL could deplete before get to the end of another LL
    The right thing to do is __using recursion__, which nice and clean solve the looping problem
    
----------[JAVA basics]--------------------------[JAVA basics]---------------
2.  [init ListNode as null] in Method. Assign null to a value means reference to nothing. untill create a instance of certain class will sys allocate the real memory space and reference to it. 
3.  [three things you should know about null] 
    i.variable of reference type will be init as null
    ii. null is not object, because null instance of Object equals to flase
    iii. there is only one null value in JVM, no matter how many variable refers to null.
4.  [types, instances, value, Object]
    i. in JAVA, there are 2 kinds of types. primitive type & reference type. Reference type ----<Class type, array type>
    ii. Object is a instance of Reference type. 
    iii. most people trate Object and instance as synonyms; choose value rather than instance to refer to instance of permitive

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null) return l2;
        if (l2==null) return l1;
        ListNode mergeHead = null;
        
        if (l1.val < l2.val){
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next,l2);
        } else {
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1, l2.next);
        }
        return mergeHead;
    }
}

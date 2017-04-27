/*
Description
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.

Thinkings
1. basically in all, this question is ez, can be transfered as align two LL
2. to compare two ListNode, simply use NodeA != NodeB ?

*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lengthA = length(headA), lengthB = length(headB);
        while(lengthA > lengthB){
            headA = headA.next;
            lengthA--;
        }
        while(lengthA < lengthB) {
            headB = headB.next;
            lengthB--;
        }
        
        while(headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    
    public int length(ListNode head){
        int res = 0;
        while(head.next!=null){
            head = head.next;
            res++;
        }
        return res;
    }
}

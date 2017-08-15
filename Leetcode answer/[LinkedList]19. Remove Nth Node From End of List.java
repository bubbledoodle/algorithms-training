// Given a linked list, remove the nth node from the end of list and return its head.

// For example,

//    Given linked list: 1->2->3->4->5, and n = 2.

//    After removing the second node from the end, the linked list becomes 1->2->3->5.

// two pass: 倒数即正数, 算出长度 再走一遍
// one pass: 俩pointer 中间带gap
// LL 惯用伎俩: dummy head防止直接消掉head

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // public ListNode removeNthFromEnd(ListNode head, int n) {
    //     ListNode dummy = new ListNode(0);
    //     dummy.next = head;
    //     int length = 0;
    //     while(head != null){
    //         length++;
    //         head = head.next;
    //     }
    //     length = length - n;
    //     head = dummy;
    //     while(length > 0){
    //         head = head.next;
    //         length--;
    //     }
    //     head.next = head.next.next;
    //     return dummy.next;
    // }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next     = head;
        ListNode left  = dummy,
                 right = dummy;
        
        while(n >= 0){
            right = right.next;
            n -= 1;
        }
        while(right != null){
            left = left.next;
            right = right.next;
        }
        
        left.next = left.next.next;
        return dummy.next;
    }
}
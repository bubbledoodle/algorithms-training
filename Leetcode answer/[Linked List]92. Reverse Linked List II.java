// Reverse a linked list from position m to n. Do it in-place and in one-pass.

// For example:
// Given 1->2->3->4->5->NULL, m = 2 and n = 4,

// return 1->4->3->2->5->NULL.

// 到达操作地点，引入了一个helper作为假的prev，因为prev肩负着保存断点和衔接的任务不能丢掉
// corner cases比较多。i<=n-m 以及衔接方法，只考虑交换完以后的。


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        for(int i = 0; i < m - 1; i++){
            prev = prev.next;
        }
        
        ListNode curr = prev.next;
        ListNode helper = null;
        for(int i = 0; i <= n - m; i++){
            ListNode temp = curr.next;
            curr.next = helper;
            helper = curr;
            curr = temp;
        }
        
        prev.next.next = curr;
        prev.next = helper;
            
        return dummy.next;
    }
    
}
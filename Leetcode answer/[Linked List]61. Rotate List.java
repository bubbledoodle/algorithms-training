// Given a list, rotate the list to the right by k places, where k is non-negative.

// For example:
// Given 1->2->3->4->5->NULL and k = 2,
// return 4->5->1->2->3->NULL.

// 想法依然很直观，命名要操作的list找到start ending，对接指针。对于进入条件要排除掉head空和一个元素的情况，返回head


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode dummy  = new ListNode(0);
        dummy.next      = head;
        ListNode start  = dummy,
                 ending = dummy;
        int      len    = 0;
        
        while(ending.next != null){
            ending = ending.next;
            len++;
        }

        for(int j = 0; j < len - k % len; j++){
            start = start.next;
        }
        
        ending.next = head;
        dummy.next  = start.next;
        start.next   = null;

        return dummy.next;
    }
}
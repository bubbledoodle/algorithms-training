// Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

// 和第一道cycle类似，涉及到了一些数量关系：相遇的时候：fast走了两倍的slow长度，差值刚好是循环的长度-----进入循环以后每一步追一个格子直到把循环的长度追完。
// 所以要找到从头到循环的长度C，正好是cycle - 循环开始到相遇点长度S。所以head往前挪动C slow挪动的正好是cycle - s即会相遇。

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head,
                 fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                while (head != slow){
                    head = head.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
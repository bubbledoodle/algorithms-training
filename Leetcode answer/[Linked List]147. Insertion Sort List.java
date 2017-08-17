// Sort a linked list using insertion sort.


// For God's sake, don't try sorting a linked list during the interview!
// in real life you might want to copy the LL into an array than sort it.
// curr代表当前要insert的，prev每次从head开始 两个限制条件：prev.next != null && prev.next.val < curr.val
// 走到不能走了。这个时候开始缝合。创建一个next保存curr.next 
// 动刀1: curr.next = prev.next 后项相连
// 动刀2: prev.next = curr 前项相连
// 移动curr


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head){
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy,
                 curr = head;
        while(curr != null){
            prev = dummy;
            while(prev.next != null && prev.next.val < curr.val){
                prev = prev.next;
            }
            ListNode next = curr.next;
            curr.next     = prev.next;
            prev.next     = curr;
            curr          = next;
        }
        return dummy.next;
    }
}
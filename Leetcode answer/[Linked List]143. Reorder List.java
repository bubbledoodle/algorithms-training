// Given a singly linked list L: L0->L1->…->Ln-1->Ln,
// reorder it to: L0->Ln->L1->Ln-1->L2->Ln-2->…

// You must do this in-place without altering the nodes' values.

// For example,
// Given {1,2,3,4}, reorder it to {1,4,2,3}.

// 三段论，先找到中间，reverse后半段，缝合以后merge，每一步都炸弹很多


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        //Find the middle of the list
        if(head == null || head.next == null) return;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
     
        //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
        ListNode middle = slow; // preserve middle
        slow.next = reverse(slow.next);
        
        
        //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
        slow = head;
        fast = middle.next;
        while(slow != middle){
            middle.next = fast.next;
            fast.next   = slow.next;
            slow.next   = fast;
            slow        = fast.next;
            fast        = middle.next;
        }
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
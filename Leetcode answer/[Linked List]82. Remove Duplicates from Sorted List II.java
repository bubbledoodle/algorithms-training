// Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

// For example,
// Given 1->2->3->3->4->4->5, return 1->2->5.
// Given 1->1->1->2->3, return 2->3.

// 这里没有再选用HashSet，由于速度考虑。还是按照步骤1. 找到有dup的最后一个元素 比较prev.next == curr


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head,
                 prev = dummy;
        
        while(curr != null ){
            while(curr.next != null && curr.val == curr.next.val){
                curr = curr.next;
            }
            if(prev.next != curr) {
                prev.next = curr.next;
                curr = prev.next;
            }
            
            else {
                prev = prev.next;
                curr = curr.next;
            }
        }
        
        return dummy.next;    
    }
}
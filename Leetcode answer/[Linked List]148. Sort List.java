// Sort a linked list in O(n log n) time using constant space complexity.

// 三步：拆成一半，递归，merge
// merge时候：1. 用到的dummy 和 head一个地址，这个技巧用于保存最初head的位置
//           2. 保证两个list都不空的时候比较，移动。空了之后直接衔接后边的

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        // step 1. cut the list to two halves
        ListNode prev = null, slow = head, fast = head;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        
        // step 2. sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        
        // step 3. merge l1 and l2
        return merge(l1, l2);
    }
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(l1 != null && l2 != null){
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 != null) head.next = l1;
        if (l2 != null) head.next = l2;
    
        return dummy.next;
    }
    
}
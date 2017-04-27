/*
## Description
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?

## Thinkings
1. [problem] cycle in LL means 1-->2-->3-->4-->i(1,2,3,4 anyone), iterate through LL is an endless procedure. Pointer point to memory address. 
2. [hash] This is a problem to test repedity, however not care the content. If using HashSet, gonna ecord each node's reference (or memory address) in a hash table, which is constructed through HashSet<ListNode> 
3. [two pointer] Another trick is to use two pointer, say fast and slow. Also the compare procedure is compare node's reference. 
4. [two pointer] need to care about two pointers. One of the convention is to the entrance should be `while(fast!=null && fast.next!=null)`

*/
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
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast==slow) return true;
        }
        return false;
    }
}

/*
## Description
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5

## Thinkings
1. the most highlight part of this solution is by __using fakeHead__. The one doesn't matter
2. to create a ListNode, like other primitives, `ListNode fakeHead = new ListNode(-1)`
3. interesting part is here, delete the element, the only thing is by __re-reference__, which is different from the [delete given ListNode question](https://github.com/bubbledoodle/Algorithms_Training/blob/master/JAVA/237.%20Delete%20Node%20in%20a%20Linked%20List.java). While that one use two allocation.

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode fakeHead = new ListNode(-1);
        ListNode temp = head, prev = fakeHead;
        fakeHead.next = head;
        
        while(temp!=null) {
            if(temp.val==val) {
                prev.next = temp.next;
            } else prev = prev.next;
            
            temp = temp.next;
        }
        return fakeHead.next;
    }
}

/*
 * description
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
    For example,
    Given 1->1->2, return 1->2.
    Given 1->1->2->3->3, return 1->2->3.
    
 * Thinkings
   Most thinkings are at the bottom. 1~5, however do not worry about the run time
   the very limited condition set to this question is SORTED, which does not seem
   to be a very good condition. That way, one of the answer can run to only do:
   temp.next = temp.next.next, while not change the temp.val = temp.next.val
   Good dig!
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
    public ListNode deleteDuplicates(ListNode head) {
        
        HashSet<Integer> set = new HashSet<Integer>();
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode temp = head, prev = fakeHead; 
        // the reason step to prev is need of deleting the curr node if needed.

        while(temp!=null) {
            if(!set.add(temp.val)) prev.next = temp.next;
            else prev = prev.next;
            temp = temp.next;
        }
        return fakeHead.next;
        
        
        /* this could not throw a right answer. The problem is
        1. while statement, ya have to use temp.next! otherwise you don't get access to temp.next.val
        need to look at if not access to prev, how to delete it. 
        2. for the skip current, ya have to do the allocation val, pointer separately. 
        3. set.add(...)  whenever you call this, you will invoke this.
        4. [1,1] will result in a wrong answer, at the tail, because the while condition unsatisfied
           skiped. Now the problem comes to how to delete the last node in singly linked list?
        5. seems like using a fakeHead and prev node is the easiest way to do so. 
        
        if(head==null || head.next==null) return head;
        HashSet<Integer> set = new HashSet<Integer>();
        ListNode temp = head;

        while(temp.next!=null) {
            if(set.add(temp.val)) {
                temp = temp.next;
                System.out.println("add success");
            }
            else {
                temp.val = temp.next.val;
                temp.next = temp.next.next;
                System.out.println("add fail");
            }
        }
        if(set.add(temp.val)) // the last step towards AC answer.
        return head;
        */
    }
}

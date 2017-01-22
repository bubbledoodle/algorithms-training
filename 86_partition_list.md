## Question
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.

## Code
```python
class Solution(object):
    def partition(self, head, x):
        """
        :type head: ListNode
        :type x: int
        :rtype: ListNode
        """
        if head is None or head.next is None or x is None:
            return head
        p1 = head1 = ListNode(0)
        p2 = head2 = ListNode(0)
        p = head
        
        while p:
            if p.val < x:
                p1.next = p
                p1 = p1.next
            else:
                p2.next = p
                p2 = p2.next
            p = p.next
        p1.next = head2.next
        p2.next = None
        return head1.next
```

## thinkings
讲真，一开始没有理解这个问题。这是第一次做linklist的题，十分的不顺手
套路有这样一些

1. 先验证

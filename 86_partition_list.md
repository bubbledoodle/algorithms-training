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
关于linked list套路有这样一些

1. 先验证list是否为空
2. 创建一个新的list，只需要初始化这个头就好咯。后边的都可以有有向表推出来
3. p = p.next 这个是pointer更新的方式，操作的东西永远是当前的
4. python里初始化好像只用了ListNode（0）这样的方式，觉得Java或者C都得new 或者malloc一下 来保证有新的存储空间分配给它。可以去查一下RTEmbedded

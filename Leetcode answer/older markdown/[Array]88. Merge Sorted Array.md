## Question
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.

Subscribe to see which companies asked this question.


## Code
```JAVA
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1==null || nums2==null) return;
        if (n==0) return;
        int i = m - 1, j = n - 1;
        for(int pos = m + n - 1; pos >= 0; pos--) {
            if (j < 0) return;
            if (i < 0) nums1[pos] = nums2[j--];
            else{
            if (nums1[i] > nums2[j]) nums1[pos] = nums1[i--];
            else nums1[pos] = nums2[j--];
            }
        }
    }
}
```

## Thinkings
首先看到的应该是一个从array最后往前放的过程。定位于pos = m + n - 1; pos--
考虑两个情况 序列1用光了 序列2用光了 再就是正常都没有光的情况了
1. edge conditions, like j,i < 0. pos >=0
2. integer array: int[], access through indexing. 

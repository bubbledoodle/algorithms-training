## 数组，去重然后返回计数，针对数组的操作只关心前 count个数字 原题描述的屎一样

```JAVA
public class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(nums == null || n == 0) return 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (res == 0 || nums[i] != nums[i-1]) {
                nums[res] = nums[i];
                res++;
            }
        }
        return res;
    }
}
```

## thinkings shitty. 
一个值得注意的：当需要access前一个index 然而又可能造成溢出时：
if (res == 0 || nums[i] != nums[i-1]) 很好地解决了这个问题。

-----
好的一点是 how to update a array within the same array. only care about those with nums[res]

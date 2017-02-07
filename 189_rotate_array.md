## question
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]

Hint:
Could you do it in-place with O(1) extra space?
Related problem: Reverse Words in a String II

## code

```Java
public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        int[] temp = Arrays.copyOfRange(nums, 0, n - k);
        System.arraycopy(nums, n - k, nums, 0, k);
        System.arraycopy(temp, 0, nums, k, n - k);
    }
}
```

## thinking
two things to stress. t%n
method arraycopy and method copyOfRange. also rotate array doesn't change the linear sequence.

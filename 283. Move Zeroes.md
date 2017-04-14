## Question
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.

## Code
```JAVA
/*public class Solution {
    public void moveZeroes(int[] nums) {
        int j;
        int num;
        for(int i = 0; i<nums.length; i++) {
            if(nums[i]==0) {
                j = i;
                while(j<nums.length && nums[j]==0) j++;
                if(j<nums.length){
                    num = nums[i];
                    nums[i] = nums[j];
                    nums[j] = num;
                }
            }
        }
    }
}
*/
public class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i=0; i<nums.length; i++){
            if(nums[i]!=0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }
}
```

## Thinkings
Two versions of JAVA code. Again another inline munipulation. First version is just oridinary one concerns always on current element. While the second edition concerns on the final array gonna build, which is faster. 

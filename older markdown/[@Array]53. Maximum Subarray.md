## Question
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

## Code

```JAVA
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0, res = nums[0];//init
        
        for (int i = 0; i<=nums.length - 1; i++) {
            sum = sum + nums[i];
            if (res >= sum) {
                if (sum < 0) {
                    if (nums[i] >= 0){// basically plus happens
                        res = nums[i];
                    }
                    sum = 0; //discard all previous 
                }
            } else {
                res = sum;
                if (sum < 0) sum = 0;
            }
        }
        return res;
    }
} // not good at all
```

## thinkings
Good thing is you finished that yourself. bad thing is logic is not beautiful, uses a lot of conner cases to modify the code. 

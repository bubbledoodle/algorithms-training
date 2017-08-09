## Question
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

## Code
```JAVA
public class Solution {
    public int singleNumber(int[] nums) {
        int res=0;
        for (Integer num:nums) res ^= num;
        return res;
    }
}
```

## Thinking
oh wow, impressive

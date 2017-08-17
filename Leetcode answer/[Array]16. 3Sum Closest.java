// Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

//     For example, given array S = {-1 2 1 -4}, and target = 1.

//     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).


// 相较于3sum来说更简单一点。不需要考虑去重，也不用Arrays.asList去返回一个List<List<Integer>>
// 思想一样，都是三个指针，这里maintain res。
// 复习一下3sum去重：sum和target相等时，左移右移到新的位置在开始。其他部分思想代码都一样

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            int start = i + 1, end = nums.length - 1;
            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if(sum > target){
                    end--;
                } else {
                    start++;
                }
                if(Math.abs(sum - target) < Math.abs(res - target)) res = sum;
            }  
        }
        return res;
    }
}
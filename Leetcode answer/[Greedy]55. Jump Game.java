// Given an array of non-negative integers, you are initially positioned at the first index of the array.

// Each element in the array represents your maximum jump length at that position.

// Determine if you are able to reach the last index.

// For example:
// A = [2,3,1,1,4], return true.

// A = [3,2,1,0,4], return false.

// 好几种方法 Greedy从最尾端找答案最好。能走就更新掉lastPos 不能就保留着 看最后能不能走到0index

class Solution {
    // Greedy O(n)
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--){
            if (i + nums[i] >= lastPos) lastPos = i;
        }
        return lastPos == 0;
        
    }

    // Backtracking O(2^n)
    public boolean canJump(int[] nums) {
        return canJumpFrom(0, nums);
    }
    private boolean canJumpFrom(int position, int[] nums){
        if (position == nums.length - 1) return true;
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++){
            if(canJumpFrom(nextPosition, nums)) return true;
        }
        return false;
    }
    
}
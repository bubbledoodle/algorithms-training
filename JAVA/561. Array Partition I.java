//ez Array.sort(int[]) method;
public class Solution {
    public int arrayPairSum(int[] nums) {
        int n = nums.length, res = 0;
        if (n == 0) return res;
        
        Arrays.sort(nums);
        for (int i = 0; i<n ; i++) {
            res += nums[i];
            i++;
        }
        return res;
    }
}

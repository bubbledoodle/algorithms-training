// Given a collection of integers that might contain duplicates, nums, return all possible subsets.

// Note: The solution set must not contain duplicate subsets.

// For example,
// If nums = [1,2,2], a solution is:

// [
//   [2],
//   [1],
//   [1,2,2],
//   [2,2],
//   [1,2],
//   []
// ]

// 依然是backtracking，不同的是输入带重。去重在if(i>start && nums[i] == nums[i - 1]) continue; 不会去掉[2,2]，条件i>start 保证了不会去掉新加的[2,2]，但会skip掉第二个作为起始的[2] 所以这里的比较是和前一个数字，不是后一个


public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(res, new ArrayList<>(); nums, 0);
        return res;
    }
    private void backtracking(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start){
        list.add(tempList);
        for(int i = start; i < nums.length; i++){
            if(i>start && nums[i] == nums[i - 1]) continue;
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
Given a set of distinct integers, nums, return all possible subsets.
// Note: The solution set must not contain duplicate subsets.

// For example,
// If nums = [1,2,3], a solution is:

// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]

// 道：根正苗红的backtracking问题，两段论
// 返回值的地方比较tricky。因为所有的都要返回，做来也简单 不需要if判断即可
// sort没必要
// 记得remove掉队尾的新加进来的元素，因为在上一行backtrack里他已经加入到list答案里去了

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }
    private void backtrack(List<List<Integer>> list, List<Integer> subset, int[] nums, int start){
        list.add(new ArrayList<>(subset));
        for(int i=start; i< nums.length; i++){
            subset.add(nums[i]);
            backtrack(list, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
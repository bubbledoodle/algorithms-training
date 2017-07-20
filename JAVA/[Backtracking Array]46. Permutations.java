/*
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

/*
    another way of doing permutation. difficulties: 乱七八糟的数据类型
    ex: 1. 空arraylist backtrack(res, nums, new ArrayList<>());
        2. 新建一个list的list: List<List<Integer>> res = new ArrayList<>();
        3. 函数调用，然并不能直接写backtrack(res, nums, prefix.add(nums[i])); 尼玛
        4. 涉及到要sub array有点烦，不像string里有可以substring

    对于permutation来说 确实是有remove的步骤，string的输入不是层层都输入全nums[]

*/

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, nums, new ArrayList<>());
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, int[] nums, List<Integer> prefix) {
        int n = nums.length;
        if(prefix.size() == n) {
            res.add(new ArrayList<>(prefix));
            return;
        }
        for(int i=0; i<nums.length; i++) {
            if(prefix.contains(nums[i])) continue; //这一步十分sb但没办法 写入一个position更丑。每次递归都要从第一个nums[0]看起。而且如果list有重复，会错啊

            prefix.add(nums[i]);
            backtrack(res, nums, prefix);
            prefix.remove(prefix.size() - 1);
        }
    }
}

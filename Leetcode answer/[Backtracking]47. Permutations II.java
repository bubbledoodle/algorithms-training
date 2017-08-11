// Given a collection of numbers that might contain duplicates, return all possible unique permutations.

// For example,
// [1,1,2] have the following unique permutations:
// [
//   [1,1,2],
//   [1,2,1],
//   [2,1,1]
// ]

// 道：最难的一步：
// if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
// 因为是permutation 必须从index 0开始 又不能有重，用used[i]来保证用过的先skip掉
// 去重第二步，不希望重复的数字另开炉灶，但是也不希望因为数字相等 而使得数字在本序列被skip掉，所以用!used[i-1]
// 大体上讲：maintain a used boolean array, tracking the status. 添加答案有限制 故要if check

// 术：List is an abstract, and cannot be initialized, use ArrayList
//    list.add(new ArrayList<>(tempList)); 添加时，写成list.add(tempList)会使得只添加的elem没有存储空间？



public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }
    private void backtracking(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used){
        if (tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else {
            for(int i = 0; i < nums.length; i++){
                if(used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtracking(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
// Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

// If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

// The replacement must be in-place, do not allocate extra memory.

// Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
// 1,2,3 → 1,3,2
// 3,2,1 → 1,2,3
// 1,1,5 → 1,5,1

// 不要被题目迷惑，不是backtracking的permutation，只是一个特殊的算法。
// 操作起来分三步，和自己去按字母顺序排列一样：
// 1. 从尾开始 找到nums[i] > nums[i - 1]
// 2. 从尾开始 找到number  > nums[i - 1] 并交换
// 3. reverse从nums[i]到尾巴的所有数字

// Example:
// 6，3，4，9，8，7，1
// 此时 first ＝ 4，second = 9
// 从尾巴到前找到第一个大于first的数字，就是7
// 交换4和7，即上面的swap函数，此时序列变成6，3，7，9，8，4，1
// 再将second＝9以及以后的序列重新排序，让其从小到大排序，使得整体最小，即reverse一下（因为此时肯定是递减序列）
// 得到最终的结果：6，3，7，1，4，8，9


public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length <= 1) return;
        int i = nums.length - 1;
        
        for(; i >= 1; i--){
            if(nums[i] > nums[i-1]){ //find first number which is smaller than it's after number
                break;
            }
        }
      
        if(i != 0){
            swap(nums, i - 1); //if the number exist,which means that the nums not like{5,4,3,2,1}
        }
      
        reverse(nums, i);    
    }
    private void swap(int[] nums, int i){
         for(int j = nums.length - 1; j >= 1; j--){
             if(nums[i] < nums[j]){
                 int temp = nums[i];
                 nums[i] = nums[j];
                 nums[j] = temp;
                 break;
             }
         }
     }
    
    private void reverse(int[] nums, int i){
        int first = i;
        int last = nums.length - 1;
        while(first < last){
            int temp = nums[first];
            nums[first] = nums[last];
            nums[last] = temp;
            first++;
            last--;
        }
    }
}
// Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

// Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
// 题意就是拍个012的序

// 这样的特殊排序：把所有零归在一边，另一边都是2的 如果one pass是一个慢慢缩小操作区域的过程。需要两枚指针一个划分0 一个划分2
// 读取当前的数，进行的两个操作是 看看是不是2 看看是不是0 这个while的存在保证了这种一直换到不能换
// 关于为什么交换2 0 的顺序成 0 2 会出错： 因为你是从index = 0来的，对于nums起初到currIndex的数是知道的，但是对2之后的数并不了解。先换过来2使得即便换过来的是0依然可以下一步接着做，因从左而来，一定不会在curr以前是2了

class Solution {
    // Method1 compact
    public void sortColors(int[] nums) {
        if(nums == null) return;
        int second = nums.length - 1, zero = 0;
        for(int i = 0; i <= second; i++){
            while(nums[i] == 2 && i <= second) swap(nums, i, second--);
            while(nums[i] == 0 && i >= zero) swap(nums, i, zero++);
        }
    }


    // Method2 写成if
    public void sortColors(int[] nums){
        int p1 = 0, p2 = nums.length - 1, index = 0;
        while(index <= p2){
            if (nums[index] == 0) {
                nums[index] = nums[p1];
                nums[p1++] = 0;
            }
            if (nums[index] == 2) {
                nums[index] = nums[p2];
                nums[p2--] = 2;
                index--;
            }
            index++;
        }
    }
    
    private void swap(int[] nums, int m, int n){
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }
}
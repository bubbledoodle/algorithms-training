// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

// For example, 
// Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

// 详解见下：关键点在于找到左maxLeft maxRight 怎么找是个学问：题解用了三种方法，brute force, DP & stack.
// 好题！ Stack的经典样例


class Solution {
    // brute force
    public int trap(int[] height) {
        int res = 0;
        int n = height.length;
        for(int i = 1; i < n; i++){
            int maxLeft = 0, maxRight = 0;
            for(int j = i; j >= 0; j--){
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for(int j = i; j < n; j++){
                maxRight = Math.max(maxRight, height[j]);
            }
            res += Math.min(maxLeft, maxRight) - height[i];
        }
        return res;
    
    // DP DP的思想是存：从左看最高 和从右看最高。这个从左看从右看其实就是skyline的变种题。 
    // 暂且不说skyline：两遍便利之后取其小者就是可以存水的多少。为什么brute force要走N^2 这个只走了2N?: brute force旨在看全局所有的高高低低都找出来 主循环还是最外层的i，浪费了很多资源。
    // 至于为什么叫DP再去研究.
    public int trap(int[] height) {
        int res = 0;
        int n = height.length;
        if(n == 0) return 0;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        maxLeft[0] = height[0];
        for(int i = 1; i < n; i++){
            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
        }
        maxRight[n - 1] = height[n - 1];
        for(int i = n - 2; i >= 0; i--){
            maxRight[i] = Math.max(height[i], maxRight[i + 1]);
        }
        for(int i = 0; i < n; i++){
            res += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return res;
    }
    
    // Stack 针对stack的叫法倒是明朗 只要有减就压入栈，有增加就考虑出栈榨取剩余水值。
    // 至于为什么后边非要 * （i - stack.peek() - 1）只好说这个是分层级来算的，一层水 二层水 三层水

    public int trap(int[] height) {
        if(height == null) return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(int i = 0; i< height.length; i++){
            if(stack.isEmpty() || height[i] <= height[stack.peek()]){
                stack.push(i);
            } else{
                int bot = stack.pop();
                if(!stack.isEmpty()){
                    res +=(Math.min(height[stack.peek()], height[i]) - height[bot]) * (i - stack.peek() - 1);
                }
                i--;   
            }   
        }
        return res;
    }
}
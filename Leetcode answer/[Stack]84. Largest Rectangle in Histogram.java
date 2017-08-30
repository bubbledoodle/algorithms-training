// Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


// Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


// The largest rectangle is shown in the shaded area, which has area = 10 unit.

// For example,
// Given heights = [2,1,5,6,2,3],
// return 10.

// 经典stack题。之所以选用stack 这里总是会把变大的高度压入stack里，如果不变大，那就意味着之前的大高度能带来的增长到头了。会从当前的前一个起一个一个的往空推栈，同时保持一个maxArea的值作为返回值。直到当前的高度比之前的小，可以按照当前的高度算最高。

// 当触及所有元素都走过一遍之后，可以开始慢慢出栈，更新方法和之前的相似。
// 试想一个例子 如果给定输入一个递增的数列 say ramp resp，那么直到最后才可以出栈，每一次计算都是针对前一算好最大矩形然后比对，很像数模转换时候的样子。

// 为什么众多数据结构里选用了stack呢 利用了stack的peek和pop性质，更重要的：一个先入后出的结构对于这种往前推算，不比原来大就不出的系统十分合适单次O(2N)行走int[] 而其他的数据结构为了寻找最大值，废掉的劲应该是stack的很多倍 复杂度往往会冲向O(N^2~3)

// stack里的数字是存index呢 还是直接压入数字？
// 针对这个问题，因为最重要计算的面积涉及到宽度变化，存入index再去按照index access value 比较合适

// 还涉及到一个stack的惯用伎俩 stack.push(-1); while(stack.peek() != -1);


class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack <Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;
        for(int i = 0; i < heights.length; i++){
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                res = Math.max(res, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        while(stack.peek() != -1)
            res = Math.max(res, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        return res;
    }
}
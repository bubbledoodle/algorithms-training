/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/

/*
Stdout
(((   // open == 3 不再<max 执行print -> 执行 close
((()  // 此条由close引出，同不执行open 但有print
((()) // 同上，之后完全close掉 写入答案 
((    // 关闭了open == 3的branch， 转到open == 2 当时没有走完剩下的
(()(
(()()
(()
(())(
(())
(
()((
()(()
()(
()()(
()()
()

 Backtracking problem, tricky to think of.
    1. out of helper function, need a res list to maintain answer.
    2. 想想怎么去写一个helper function: 要记录 answer, 当前的 str, 已开括号，已关括号，最大数量
    3. 看看stdout 明白了很多, basically依然是一个递归的使用。
    4. 这里递归的出口就是str满足了长度条件，因为每一层都有可能有答案产生，所以max要一直作为一个参数传着。
    5. 增长条件 open < max 和 close < open. 操作以后更改相关数据

*/

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list,"", 0, 0, n);
        return list;
    }
    public void backtrack(List<String> list, String str, int open, int close, int max) {
        if(str.length() == max*2) {
            list.add(str);
            return;
        }
        if(open < max) backtrack(list, str+"(", open+1, close, max);
        System.out.println(str);
        if(close< open) backtrack(list, str+")", open, close+1, max);
    }
}
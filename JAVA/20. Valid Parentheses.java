/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.


 think of bit manipulation is a doomed failer 
 the first to think of is which data structure needed?
 in this case should be stack
 
 @.@ never used stack in Java before. so carefully
 题设 只有括号们 所以别花心思想Character了
*/
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
			return false;
        }
        return stack.isEmpty();
    }
}

// Evaluate the value of an arithmetic expression in Reverse Polish Notation.

// Valid operators are +, -, *, /. Each operand may be an integer or another expression.

// Some examples:
//   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

// Stack部分很好想，麻烦在了string的操作。
// 这里的输入竟然是一个String[] 所以s.equals("") 而不是 == ‘’
// Integer.parseInt("s")
// that's it!

class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        if (n == 0) return 0;
        int op1, op2;
        
        Stack<Integer> stack = new Stack<Integer>();
        for (String s : tokens){
            if(s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } 
            else if (s.equals("-")) {
                op2 = stack.pop();
                op1 = stack.pop();
                stack.push(op1 - op2);
            } 
            else if (s.equals("*")) {
                op2 = stack.pop();
                op1 = stack.pop();
                stack.push(op1 * op2);
            } 
            else if (s.equals("/")) {
                op2 = stack.pop();
                op1 = stack.pop();
                stack.push(op1 / op2);
            } 
            else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
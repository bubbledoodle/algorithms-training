## Question
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

## Code
```JAVA
public class Solution {
    public boolean isHappy(int n) {
        HashSet inLoop = new HashSet<Integer>();
        while (inLoop.add(n)) {
            n = op(n);
            if (n == 1) return true;
        }
        return false;
    }
    
    public int op(int num) {
        int sum = 0;
        while (num>0){
            sum += (num%10) * (num%10);
            num /= 10;
        }
        return sum;
    }
}
```

## Thinking
1. the loop thinking is great, that way HashSet is used to get out from loop;
2. for any length integer, compute a bit each time. the 2nd function could be a very good example for bit manipulation. 
3. JAVA, ^ is XOR, not the square.

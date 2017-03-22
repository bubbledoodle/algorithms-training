## Question
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

## Code
```JAVA
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        if (rowIndex < 0) return res;
        res.add(1);
        // starting from the second line.
        for (int i = 1; i <= rowIndex; i++ ) {
            for (int j = i-1; j >= 1; j--) { // compute from the back all the way to j = 1 which res.get(j - 1) gets the 1st element
                res.set(j, res.get(j) + res.get(j - 1));
            }
            res.add(1);
        }
        return res;
    }
}
```

## Thought
first think about directly calculate the row, which may exceed the runing time. 
This answer is smart. it utilize the previous line and rewrite the line. 

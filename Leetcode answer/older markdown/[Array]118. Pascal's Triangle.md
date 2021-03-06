## Question
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
     
    [1,1],
    
   [1,2,1],
   
  [1,3,3,1],
  
 [1,4,6,4,1]
]

## Code
```JAVA
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        if (numRows <= 0) return res;
        for (int i = 0; i < numRows; i++){
            row.add(0,1);
            System.out.println(row);
            for (int j = 1; j < row.size() - 1; j++){
                row.set(j, row.get(j) + row.get(j + 1));
            }
            
            res.add(new ArrayList<Integer>(row));
        }
        return res;
    }
}
```

## Thinkings
1. `List<List<Integer>> = new ArrayList<List<Integer>>();`
2. it is `res.add(new ArrayList<Integer>(row));` rather than `res.add(row);` See how JAVA passes parameters.
3. each iteration, 1 is add to the front of the List. which is reasonable. consider how to construct the current row. 

__finally__ This gives an example that how to construct a list of list and return them all together. It is actually constructed __row by row__

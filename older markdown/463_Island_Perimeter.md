## Question
[compute the perimetet]
You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

## Code
```Java
public class Solution {
    public int islandPerimeter(int[][] grid) {
        // grid[i][j] ->grid[i - 1][j] + grid[i + 1][j] + grid[i][j - 1] + grid[i][j + 1] four neighboorhood
        // get map to 1,2,3 and 4. and corresponding commit to perimeter is (4 - map) * grid[i][j] -> make sure zero commit nothing to final perimeter; traverise through element. 
        // difficulty: index out of range. 
        // solution: to compute every edges independly, or augment the matrix. 
        int islandNum = 0; int neighboors = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islandNum++;
                    if (j < grid[i].length -1 && grid[i][j + 1] == 1) neighboors++;
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighboors++;
                }
            }
        }
        return islandNum * 4 - neighboors * 2;
    }
}
```

## Thinking
You thought you got it. haha.
Actually this is a very easy question. Think of neighboorhoods are great. however, you do not have to access such a lot of neighboors. All the conditions are to eliminate the not continued islands. The solution is very smart. 

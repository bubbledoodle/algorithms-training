// Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

// The distance between two adjacent cells is 1.
// Example 1: 
// Input:

// 0 0 0
// 0 1 0
// 0 0 0
// Output:
// 0 0 0
// 0 1 0
// 0 0 0
// Example 2: 
// Input:

// 0 0 0
// 0 1 0
// 1 1 1
// Output:
// 0 0 0
// 0 1 0
// 1 2 1

// 循环整个matrix，init每个格子的数字
// 把所有的0入queue 
// 检查所有入queue的元素的四个邻域：情况就是 要不然也是0 要不然就值 总之要找最小的
// 重写一下四邻域：
// int[][] dirs = {{-1, 0},{1, 0},{0, -1},{0, 1}}; // 固定一个 向另一个方向加一/减一
// int r = cell[0] + dirs[i][0];
// int c = ccll[1] + dirs[i][0];
// if (distance[r][c] > distance[cell[0]][cell[1]] + 1){
//     变更；
//     q.offer(new int[]{r,c});
//     //这一步牛逼的解决了除了0 向纵深挺近的问题。因为第一步0只是入列了一些0领域，而纵深的挺近要靠{r.c}
// }

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return matrix;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] distance = new int[rows][cols];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == 0){
                    distance[i][j] = 0;
                    q.offer(new int[]{i, j});
                } else {
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] dirs = {{-1, 0},{1, 0},{0, -1},{0, 1}};
        while(!q.isEmpty()){
            int[] cell = q.poll();
            for(int i = 0; i < 4; i++){
                int r = cell[0] + dirs[i][0];
                int c = cell[1] + dirs[i][1];
                if(r >= 0 && c >= 0 && r < rows && c < cols){
                    if(distance[r][c] > distance[cell[0]][cell[1]] + 1) {
                        distance[r][c] = distance[cell[0]][cell[1]] + 1;
                        q.offer(new int[] {r, c});
                    }
                }
            }
        }
        return distance;
    }
}
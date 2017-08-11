## Question
Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

## Code
```Java
public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        // point wise distance map: find one dis -> map; find second -> +1; permutation x 2
        // what about the distance? are you going to compute it every time a new point come? --> n^2 complexity 
        
        int res = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<points.length; i++) {
            for (int j=0; j<points.length; j++) {
                if (i == j) 
                    continue; // nice
                  
                int d = getDistance(points[i], points[j]); // think about passing points, naming, int
                
                if (map.get(d) == null) {
                    map.put(d, 1); // nice
                } else { map.put(d, map.get(d) + 1);}
                //map.put(d, map.getOrDefault(d, 0) + 1);
            }
            
            for (int val: map.values()) {
                res += val * (val - 1);
            }
            map.clear(); // record this
        }
        return res;
    }
    private int getDistance(int[] point, int[] target) {
        int dx = target[0] - point[0];
        int dy = target[1] - point[1];
        
        return dx*dx + dy*dy;
        
        // return (target[0] - point[0])^2 + (target[1] - point[1])^2;
        // this is wrong, however seems right don't know why???
    }
}
```
## Thinking 
1. O(n^2) time and O(n) spacial
2. Map method getOrDefault; Actually get and put back +1 is cool also
3. Distance 
4. naming method, variables.

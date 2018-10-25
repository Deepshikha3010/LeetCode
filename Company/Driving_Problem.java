/**
Driving problem
There is a road with a length L and a width W. There are some circular obstacles in the road. The radius is 1, there is a circular car with a radius of 2. Ask if the car can pass this road. You can think of the road as a rectangle on two-dimensional coordinates. The four points are (0,0), (0,W), (L,0), (L,W). Now you need to start from x=0 To x=L, contact with obstacles is not allowed, and all parts of the car are betweeny=0 and y=W, contact is not allowed.

Example
Given L=8,W=8, the obstacle coordinates are [[1,1],[6,6]]. Return yes.

The center of the car can go from (0,5) to (2,5) to (5,2) to (8,2), so return yes.
Give L=8, W=6, the obstacle coordinate is [[1,1]], and return no.

Regardless of how you drive, the car will always be tangent to or intersect with obstacles, which is not allowed.
Notice
The coordinates of the obstacle can be floating point numbers
The car can't drive out of the road
The number of obstacles does not exceed 1,000.
Obstacles can intersect or overlap
 */

public class Solution {
    /**
     * @param L: the length
     * @param W: the width
     * @param p:  the obstacle coordinates
     * @return: yes or no
     */
    class UnionFind {
        int[] father;
        
        UnionFind(int n) {
            father = new int[n + 2];
            for (int i = 0; i < n + 2; i++) {
                father[i] = i;
            }
        }
        
        int find_and_compress(int x) {
            int parent = x;
            while (parent != father[parent]) {
                parent = father[parent];
            }
            int temp;
            while (x != father[x]) {
                temp = father[x];
                father[x] = parent;
                x = temp;
            }
            return parent;
        }
        
        void union(int x, int y) {
            int x_ = find_and_compress(x);
            int y_ = find_and_compress(y);
            
            father[x_] = y_;
        }
    }
    
    private static final String YES = "yes";
    private static final String NO = "no";
     
    public String drivingProblem(int L, int W, double[][] p) {
        int n = p.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double dx = (p[i][0] - p[j][0]) * (p[i][0] - p[j][0]);
                double dy = (p[i][1] - p[j][1]) * (p[i][1] - p[j][1]);
                
                if (dx + dy <= 36d) {
                    uf.union(i, j);
                }
            }
            if (p[i][1] >= W - 5) {
                uf.union(i, n);
            }
            
            if (p[i][1] <= 5) {
                uf.union(i, n + 1);
            }
        }
        
        if (uf.find_and_compress(n) == uf.find_and_compress(n + 1)) {
            return NO;
        }
        return YES;
    }
}
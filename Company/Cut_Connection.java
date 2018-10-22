/**
Description
Given a matrix consists of 0 and 1, the first line is the roof.
Remove one of '1', the same column of the '1' that is not connected to the roof will drop and need to be set to '0'.

Roof will not be cut

Example
Given:
matrix = [ 
         [1,1,1,1,1],
         [0,0,1,0,1],
         [0,0,1,0,1],
         [0,0,1,0,0]
         ]
Point = (1,2)
Return:
matrix = [                  
         [1,1,1,1,1],
         [0,0,0,0,1],
         [0,0,0,0,1],
         [0,0,0,0,0]
         ]
 */

public class Solution {
    /**
     * @param matrix: 
     * @param x: 
     * @param y: 
     * @return: return the matrix
     */
    public int[][] removeOne(int[][] matrix, int x, int y) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }
        
        int height = matrix.length;
        
        for (int i = x; i < height; i++) {
            matrix[i][y] = 0;
        }
        
        return matrix;
    }
}
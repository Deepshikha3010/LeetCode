/**
 * 记忆化搜索：递归模式下的动态规划。
 * 
 * Solution (bottom-up): 时间复杂度n2, 空间复杂度n2
 */

 /**Solution */
public class Solution {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        int height = triangle.length;
        //state
        int[][] f = new int[height][height];
        //initial
        for(int i = 0; i < height; i++){
            f[height - 1][i] = triangle[height - 1][i];
        }
        //function
        for(int i = height - 2; i >= 0; i--){
            for(int j = 0; j < triangle[i].length; j++){
                f[i][j] = Math.min(f[i + 1][j], f[i + 1][j + 1]) + triangle[i][j];
            }
        }
        //result
        return f[0][0];
    }
}
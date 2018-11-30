/**
Pinterest给了四小时，结果只有一个题。我做了两小时就交了，事后在想是不是还有更优解法。我当时是写了一个bfs。

给定一个由字母组成的矩阵，从任意一格出发，找出由相邻字母组成的最长路径。
相邻字母的定义是当前格子字母的前后字母，例如B的相邻字母就是A和C。
在矩阵中移动时，可以向上下左右四个方向移动。
例如：
A	B	E	F
E	C	D	D
A	C	E	C
A	B	C	E
最长路径是ABCCBA

这差不多是问题描述里的例子，但是问题描述里的sample output错了。Sample Output给的答案是ABCDE。
然后这还是第二个public test case，在test case给的standard output就是ABCCBA。
最后feedback的时候我还把这点写上去了。

这题感觉有点像 leetcode 329 longest increasing path in a matrix.

写了这么长，最后诚心求大米。两三小时前刚发完Google的OA，开始看电面面经，结果发现有一些还是米不够。诚心恳求各位走过路过点个赞，加个米，谢谢！


补充内容 (2018-10-28 11:49):
对不起我把例子写错了
ABEF
ECDD
ADXC
BCXE
应该是这样
然后最长路径是ABCDCB
 */

class Solution {
    boolean[][] flag;
    int[][] f;

    public String longestLetterPath(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return "";
        }

        int height = matrix.length, width = matrix[0].length;
        flag = new boolean[height][width];
        f = new int[height][width];

        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                
            }
        }
        return null;
    }
}
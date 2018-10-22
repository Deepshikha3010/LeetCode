/**
Description
Given two integer arrays a and b,please find the number in a with the minimal distance between corresponding value in b (the distance between two numbers means the absolute value of two numbers), if there are several numbers in a have same distance between b[i],just output the smallest number.
Finally, you should output an array of length b.length to represent the answer.

1<=a.length,b.length<=100000

Have you met this question in a real interview?  
Example
Givena=[5,1,2,3],b=[2,4,2],return [2,3,2]
Explanation：

`b[0]=2`,`2` is the number who has the minimal distance to `2`
`b[1]=4`,`3` and `5` have the same distance to `4`,output `3` because `3` is smaller
`b[2]=2`,as well as `b[0]`
Givena=[5,3,1,-1,6],b=[4,8,1,1],return[3,6,1,1]
Explanation：

`b[0]=4`,`3` and `5` have the same distance to `4`,output `3` because `3` is smaller
`b[1]=8`,`6` is the number who has the minimal distance to `8`
`b[2]=1`,`1` is the number who has the minimal distance to `1`
`b[3]=1`,as well as`b[2]`
 */

public class Solution {
    /**
     * @param a: array a
     * @param b: the query array
     * @return: Output an array of length `b.length` to represent the answer
     */
    public int[] minimalDistance(int[] a, int[] b) {
        if (a == null || a.length == 0 || b == null || b.length == 0) {
            return new int[0];
        }
        
        Arrays.sort(a);
        
        int[] res = new int[b.length];
        for (int i = 0; i < b.length; i++) {
            int cur = b[i];
            res[i] = a[findClosest(a, cur)];
        }
        
        return res;
    }
    
    private int findClosest(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        
        if (Math.abs(arr[start] - target) <= Math.abs(arr[end] - target)) {
            return start;
        }
        return end;
    }
}
/**
 * 
 * Solution 1: -- 时间复杂度logn，空间复杂度1
 * 1. 二分法：根据递增数列求和公式。
 * 2. double amount = 0.5 * mid + 0.5 * mid * mid; 必须先乘0.5做强制转换。
 * 
 * Solution 2: -- 时间复杂度1，空间复杂度1
 * (1 + X) * X = 2n
 * 4X * X + 4 * X = 8n
 * (2X + 1)(2X + 1) - 1 = 8n
 * X = (Math.sqrt(8 * n + 1) - 1)/ 2
 */

/**Solution 1 */
class Solution {
    public int arrangeCoins(int n) {
        if (n <= 0){
            return 0;
        }
        
        int start = 1, end = n;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            double amount = 0.5 * mid + 0.5 * mid * mid;
            if (amount == n){
                return mid;
            }else if(amount < n){
                start = mid;
            }else{
                end = mid;
            }
        }
        
        double amountEnd = 0.5 * end + 0.5 * end * end;
        if(amountEnd <= n){
            return end;
        }else {
            return start;
        }
    }
}

/**Solution 2 */
public class Solution {
    public int arrangeCoins(int n) {
        return (int)((-1 + Math.sqrt(1 + 8 * (long)n)) / 2);
    }
}
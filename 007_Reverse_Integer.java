/**
 * 利用 x % 10 取余得到个位数，用x /= 10 退位。
 * 如果Integer溢出，得到的数反向操作与原来的数不相等。
 * 
 * Solution:
 * 1. 取余。
 * 2. 通过result * 10 + tail 得到新数。
 * 3. 反向操作新数检查有没有溢出。
 * 4. 利用 x /= 10 退位。
 */

/**Solution */
class Solution {
    public int reverse(int x) {
        int result = 0;
        while(x != 0){
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if((newResult - tail) / 10 != result){
                return 0;
            }
            result = newResult;
            x /= 10;
        }
        return result;
    }
}
/**
 * Math
 * 时间复杂度n, 空间复杂度n
 * AB => 28 == 26 + 2 => (25 + 1) + (1 + 1)
 * 每一节都要n--
 * 
 */

/**Solution 1 Recursion */
class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        return helper(n, sb).reverse().toString();
    }
    
    private StringBuilder helper(int n, StringBuilder sb){
        if(n == 0){
            return sb;
        }
        n--;
        sb.append((char)(n % 26 + 'A'));
        return helper(n / 26, sb);
    }
}

/**Solution 2 Iterative */
class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            n--;
            char c = (char) (n % 26 + 'A');
            sb.append(c);
            n /= 26;
        }
        return sb.reverse().toString();
    }
}

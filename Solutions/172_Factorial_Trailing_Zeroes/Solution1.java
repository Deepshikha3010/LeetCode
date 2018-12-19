/**
 * Type: Brute Force
 * Time: n
 * Space: 1
 */
class Solution {
    public int trailingZeroes(int n) {
        if (n == 0) return 0;
        
        long num = 1;
        n = Math.abs(n);
            
        while (n != 0) {
            num *= n--;
        }
        
        System.out.println(num);
        
        int count = 0;
        while (num != 0) {
            int d = (int)(num % 10);
            if (d == 0) count++;
            else break;
            num /= 10;
        }
        
        return count;
    }
}
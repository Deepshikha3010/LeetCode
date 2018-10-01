class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int init = x;
        int num = 0;
        while(x > 0) {
            int remainder = x % 10;
            if (x == 0 && remainder == 0) {
                return false;
            }
            int temp = num * 10 + remainder;
            if (temp / 10 != num) {
                return false;
            }
            num = temp;
            x /= 10;
        }
        
        return num == init;
    }
}

class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        
        while (n > 1) {
            if (n % 3 != 0) {
                return false;
            }
            n /= 3;
        }
        
        return n == 1;
    }
}

// No loop or recursion
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        
        if (1162261467 % n == 0) {
            return true;
        }
        
        return false;
    }
}

// Log use no loop or recursion, time complexity is logn
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        
        return (int)(Math.log10(n) / Math.log10(3)) - Math.log10(n) / Math.log10(3) == 0;
    }
}
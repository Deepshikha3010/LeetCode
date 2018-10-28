class Solution {
    public boolean isPerfectSquare(int num) {
        if (num <= 0) {
            return false;
        }
        
        long start = 1, end = num;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid < num) {
                start = mid;
            } else if (mid * mid > num) {
                end = mid;
            } else {
                return true;
            }
        }
        
        if (start * start == num) {
            return true;
        }
        if (end * end == num) {
            return true;
        }
        return false;
    }
}
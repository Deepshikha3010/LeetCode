class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        
        int[] res = new int[digits.length];
        int pre = 1;
        
        for (int i = digits.length - 1; i >= 0; i--) {
            int cur = digits[i];
            int sum = pre + cur;
            res[i] = sum % 10;
            pre = sum / 10;
        }
        
        if (pre != 0) {
            int[] newRes = new int[digits.length + 1];
            for(int i = res.length - 1; i >= 0; i--) {
                newRes[i + 1] = res[i];
            }
            newRes[0] = pre;
            return newRes;
        }
        
        return res;
    }
}
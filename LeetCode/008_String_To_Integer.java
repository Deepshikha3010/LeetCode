/**
Use code below to check if overflow:
    int temp = num * 10 + n;
    if (temp / 10 != num) {...} 
If overflow, temp / 10 will not keep the same negative/positive as num.
 */

class Solution {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        
        int start = 0;
        int num = 0;
        boolean isNegative = false;
        boolean hasInvalid = false;
        
        char[] sc = str.toCharArray();
        if (sc[0] == '-') {
            isNegative = true;
            start = 1;
        } else if (sc[0] == '+') {
            start = 1;
        }
    
        for (int i = start; i < sc.length; i++) {
            char c = sc[i];
            if (!Character.isDigit(c)) {
                break;
            }
            int n = Character.getNumericValue(c);
            n = isNegative ? -n : n;
            int temp = num * 10 + n;
            if (temp / 10 != num) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            num = temp;
        }
        
        return num;
    }
}

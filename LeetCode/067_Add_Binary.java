/**
 * Rest + Result
 * 
 * Solution 1: 时间复杂度n，空间复杂度1
 * 
 * Solution 2: 时间复杂度n，空间复杂度1
 * 优化：保证a的长度比b长。
 */

/**Solution 1 */
class Solution {
    public String addBinary(String a, String b) {
        if(a == null || a.length() == 0){
            return b;
        }
        if(b == null || b.length() == 0){
            return a;
        }
        String result = "";
        int ptA = a.length() - 1;
        int ptB = b.length() - 1;
        int rest = 0;
        while(ptA >= 0 && ptB >= 0){
            int numA = a.charAt(ptA) - '0';
            int numB = b.charAt(ptB) - '0';
            int sum = numA + numB + rest;
            int digit = sum % 2;
            rest = sum / 2;
            result = digit + result;
            ptA--;
            ptB--;
        }
        while(ptA >= 0){
            int numA = a.charAt(ptA) - '0';
            int sum = numA + rest;
            int digit = sum % 2;
            rest = sum / 2;
            result = digit + result;
            ptA--;
        }
        while(ptB >= 0){
            int numB = b.charAt(ptB) - '0';
            int sum = numB + rest;
            int digit = sum % 2;
            rest = sum / 2;
            result = digit + result;
            ptB--;
        }
        if(rest == 1){
            result = 1 + result;
        }
        return result;
    }
}

/**Solution 2 */
class Solution {
    public String addBinary(String a, String b) {
        if(a == null || a.length() == 0){
            return b;
        }
        if(b == null || b.length() == 0){
            return a;
        }
        if(a.length() < b.length()){
            return addBinary(b, a);
        }
        String result = "";
        int ptA = a.length() - 1;
        int ptB = b.length() - 1;
        int rest = 0;
        while(ptB >= 0){
            int numA = a.charAt(ptA) - '0';
            int numB = b.charAt(ptB) - '0';
            int sum = numA + numB + rest;
            int digit = sum % 2;
            rest = sum / 2;
            result = digit + result;
            ptA--;
            ptB--;
        }
        while(ptA >= 0){
            int numA = a.charAt(ptA) - '0';
            int sum = numA + rest;
            int digit = sum % 2;
            rest = sum / 2;
            result = digit + result;
            ptA--;
        }
        if(rest == 1){
            result = 1 + result;
        }
        return result;
    }
}
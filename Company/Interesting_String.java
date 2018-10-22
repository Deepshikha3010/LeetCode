/**
Interesting String
There is now a string s consisting of only numbers and lowercase letters. If the string s is interesting, then s must be split into several substrings, each substring satisfies the beginning of the number, and the number represents the number of characters after it. For example, s = "4g12y6hunter", we can divide it into "4g12y" and "6hunter", so the string is interesting.
If s is an interesting string, output "yes", otherwise output "no"

Example
s = "124gray6hunter",return "yes"

we can divide it into "12", "4gray", "6hunter".
s = "31ba2a" ,return "no"

Notice
the length of string no more than 10000
 */

public class Solution {
    /**
     * @param s: the string s
     * @return: check if the string is interesting
     */
    public String check(String s) {
        if (s == null || s.length() == 0) {
            return "yes";
        }
        
        boolean res = helper(s, 0);
        return res == true ? "yes" : "no";
    }
    
    private boolean helper(String s, int index) {
        if (index == s.length()) {
            return true;
        }
        
        if (index > s.length() || !Character.isDigit(s.charAt(index))) {
            return false;
        }
        
        int num = 0;
        while (Character.isDigit(s.charAt(index))) {
            int cur = s.charAt(index) - '0';
            num = 10 * num + cur;
            if (helper(s, index + num + 1)) {
                return true;
            }
            index++;
        }
        
        return false;
    }
}
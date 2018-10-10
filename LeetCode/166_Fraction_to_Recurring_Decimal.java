// https://www.jianshu.com/p/fc135bb12dd8
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        if (numerator == 0) {
            return "0";
        }
        
        int s1 = numerator < 0 ? -1 : 1;
        int s2 = denominator < 0 ? -1 : 1;
        
        long num = Math.abs((long) numerator);
        long div = Math.abs((long) denominator);
        
        if (s1 * s2 < 0) {
            sb.append("-");
        }
        sb.append(num / div);
        
        long remainder = num % div;
        if (remainder == 0) {
            return sb.toString();
        }
        sb.append(".");
        
        Map<Long, Integer> map = new HashMap<>();
        while(!map.containsKey(remainder)) {
            map.put(remainder, sb.length());
            sb.append(10 * remainder / div);
            remainder = 10 * remainder % div;
        }
        
        int index = map.get(remainder);
        sb.insert(index, "(");
        sb.append(")");
        return sb.toString().replace("(0)", "");
    }
}
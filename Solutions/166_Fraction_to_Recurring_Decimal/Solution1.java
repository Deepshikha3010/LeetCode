/**
 * Type: Math
 * Time: n (unknown)
 * Space: n (unknown)
 */
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) return "";
        
        StringBuilder sb = new StringBuilder();
        
        if (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) sb.append('-');
        
        long divd = Math.abs((long) numerator);
        long divs = Math.abs((long) denominator);
        
        sb.append(divd / divs);
        long res = divd % divs;
        
        if (res == 0) return sb.toString();
        
        sb.append('.');
        Map<Long, Integer> map = new HashMap<>();
        while (!map.containsKey(res)) {
            map.put(res, sb.length());
            sb.append(10 * res / divs);
            res = res * 10 % divs;
        }
        
        int index = map.get(res);
        sb.insert(index, '(');
        sb.append(')');
        return sb.toString().replace("(0)", "");
    }
}
/**
 * 时间复杂度n, 空间复杂度1
 * 从左往右得可能需要删除前面元素的值，
 * 从右往左不需要考虑。
 */

// 从右往左
class Solution {
    public int romanToInt(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char pre = s.charAt(s.length() - 1);
        int sum = map.get(pre);
        for(int i = s.length() - 2; i >= 0; i--){
            char c = s.charAt(i);
            if(map.get(c) >= map.get(pre)){
                sum += map.get(c);
            }else{
                sum -= map.get(c);
            }
            pre = c;
        }
        return sum;
    }
}

// 从左往右
class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int len = s.length();
        int pre = map.get(s.charAt(0));
        int result = pre;
        for(int i = 1; i < len; i++){
            char c = s.charAt(i);
            int crt = map.get(c);
            if(crt > pre){
                result -= pre * 2;
                result += crt;
            }else{
                result += crt;
            }
            pre = crt;
        }
        
        return result;
    }
}
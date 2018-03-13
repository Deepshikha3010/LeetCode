/**
 * Solution 1: 时间复杂度nm，空间复杂度m(n)
 * 1. 先判定num1与num2长度。使得num1长度一定大于num2（如果num1为0，num2肯定为0。）
 * 2. 嵌套循环从右往左进行乘法，结果为String，当被乘数i位置为0的时候直接跳过。
 * 3. 利用i的位置对record进位。
 * 4. 利用add方法进行String加法。
 * 5. 如果result最终为空，则返回0.否则返回result。
 * 
 * Solution 2: 时间复杂度nm, 空间复杂度m + n;
 * num1[i] * num2[j] will be placed at indices [i + j, i + j + 1]。
 * 1. result最大长度为m + n。
 * 2. 反过来看的话，0与0位的相乘的个位应该在index=1的位置上，所以个位应为i + j + 1。由此可得其它数位的各位位置都为i + j + 1;
 * 3. 相比较binary multiply只需将模数改为2.
 */

 /**Solution 1 */
class Solution {
    public String multiply(String num1, String num2) {
        if(num1.length() < num2.length()){
            return multiply(num2, num1);
        }
        int pt1 = num1.length() - 1;
        int pt2 = num2.length() - 1;
        String result = "";
        for(int i = pt2; i >= 0; i--){
            int n2 = num2.charAt(i) - '0';
            String record = "";
            if(n2 != 0){
                int rest = 0;
                int j = pt1;
                for(; j >= 0; j--){
                    int n1 = num1.charAt(j) - '0';
                    int multi = n1 * n2 + rest;
                    int digit = multi % 10;
                    rest = multi / 10;
                    record = digit + record;
                }
                if(rest != 0){
                    record = rest + record;
                }
                String tail = "";
                for(int k = 0; k < pt2 - i; k++){
                    tail += "0";
                }
                record = record + tail;
                result = add(record, result);
            }
        }
        return result.equals("") ? "0" : result;
    }
    
    private String add(String a, String b) {
        if(a == null || a.length() == 0){
            return b;
        }
        if(b == null || b.length() == 0){
            return a;
        }
        if(a.length() < b.length()){
            return add(b, a);
        }
        String result = "";
        int ptA = a.length() - 1;
        int ptB = b.length() - 1;
        int rest = 0;
        while(ptB >= 0){
            int numA = a.charAt(ptA) - '0';
            int numB = b.charAt(ptB) - '0';
            int sum = numA + numB + rest;
            int digit = sum % 10;
            rest = sum / 10;
            result = digit + result;
            ptA--;
            ptB--;
        }
        while(ptA >= 0){
            int numA = a.charAt(ptA) - '0';
            int sum = numA + rest;
            int digit = sum % 10;
            rest = sum / 10;
            result = digit + result;
            ptA--;
        }
        if(rest != 0){
            result = rest + result;
        }
        return result;
    }
}

/**Solution 2 */
class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null){
            return null;
        }
        int pt1 = num1.length() - 1;
        int pt2 = num2.length() - 1;
        int[] f = new int[num1.length() + num2.length()];
        for(int i = pt1; i >= 0; i--){
            for(int j = pt2; j >= 0; j--){
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + f[p2];
                f[p2] = sum % 10;
                f[p1] += sum / 10;
            }
        }
        String result = "";
        for(int i = 0; i < f.length; i++){
            if(result.length() == 0 && f[i] == 0){
                continue;
            }
            result += f[i];
        }
        return result.length() == 0 ? "0" : result;
    }
}
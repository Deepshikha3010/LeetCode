/**
 * 双指针：fast寻找下一个元素并判定，slow控制实际打印元素。
 * 使用窗口双指针模板
 * 
 * Solution 1: 时间复杂度n，空间复杂度1
 * 1. 默认长度为1则返回1。
 * 2. slow在0位置，fast在1位置，默认第一个元素已经加入。
 * 3. cur为当前打印元素，num为当前元素的个数，初始值为1。
 * 4. 当fast元素与cur相同，则num++。
 * 5. 当fast元素与cur不同，则slow前进一位。打印num，再将slow前进一位。转换cur为fast元素，并打印当前元素。
 * 6. 结束循环后，最后一个元素没有打印，则再进行一次打印判断。
 * 
 * Solution 2 优化：
 * 1. 使用双指针模板，slow锚定初始元素后，fast前进计算count。
 * 2. 将num转化成char[]，用循环放入数组。
 */

/**Solution 1 */
class Solution {
    int num = 1;
    
    public int compress(char[] chars) {
        if(chars.length == 1){
            return 1;
        }
        int slow = 0, fast = 1;
        char cur = chars[0];
        while(fast < chars.length){
            char c = chars[fast];
            if(c == cur){
                num++;
            }else{ // either add number or skip directly
                slow = addItem(chars, slow, cur);
                cur = c;
                chars[slow] = cur;
            }
            fast++;
        }
        slow = addItem(chars, slow, cur);
        return slow;
    }
    
    private int addItem(char[] chars, int slow, char cur){
        slow++;
        if(num > 1){
            if(num < 10){
                chars[slow] = (char)(num + '0');
                slow++;
            }else if(num < 100){
                chars[slow] = (char)(num / 10 + '0');
                chars[slow + 1] = (char)(num % 10 + '0');
                slow += 2;
            }else{
                chars[slow] = (char)(num / 100 + '0');
                chars[slow + 1] = (char)(num / 10 % 10 + '0');
                chars[slow + 2] = (char)(num % 10 + '0');
                slow += 3;
            }
        }
        num = 1;
        return slow;
    }
}

/**Solution 2 */
class Solution {
    public int compress(char[] chars) {
        int slow = 0, fast = 0;
        while(fast < chars.length){
            char c = chars[fast];
            int num = 0;
            while(fast < chars.length && chars[fast] == c){
                fast++;
                num++;
            }
            chars[slow++] = c;
            if(num > 1){
                char[] numChars = Integer.toString(num).toCharArray();
                for(char ch : numChars){
                    chars[slow++] = ch;
                }
            }
        }
        return slow;
    }
}
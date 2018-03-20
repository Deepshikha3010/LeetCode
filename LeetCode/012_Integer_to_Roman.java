/**
 * 时间复杂度1, 空间复杂度1
 * 用String[]做好每一位的结果，最后相加。
 */

class Solution {
    private String[] belowTwenty = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    private String[] belowHundred = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private String[] belowThousand = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private String[] upThousand = new String[]{"", "M", "MM", "MMM"};
    
    public String intToRoman(int num) {
        if(num <= 0){
            return "";
        }
        if(num < 10){
            return belowTwenty[num];
        }else if(num < 100){
            return belowHundred[num / 10] + belowTwenty[num % 10];
        }else if(num < 1000){
            return belowThousand[num / 100] + belowHundred[num / 10 % 10] + belowTwenty[num % 10];
        }else{
            return upThousand[num / 1000] + intToRoman(num % 1000);
        }
    }
}
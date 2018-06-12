/**
用while循环通过1000切分，每一份内部都是Hundred及其以下。
每一份之间用record进行数量级判断。
注意每次合并之前用trim()。 */

class Solution {
    private String[] belowTwenty = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private String[] belowHundred = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private String[] upHundred = new String[]{"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if(num < 0){
            return null;
        }
        
        if(num == 0){
            return "Zero";
        }
        
        String result = "";
        int record = 0;
        
        while(num > 0){
            String crt = helper(num % 1000).trim();
            num /= 1000;
            if(crt.length() > 0){
                result = crt.trim() + " " + upHundred[record] + " " + result;
            }
            record++;
        }
        
        return result.trim();
    }
    
    private String helper(int num){
        if(num < 20){
            return belowTwenty[num];
        }else if(num < 100){
            return belowHundred[num / 10] + " " + belowTwenty[num % 10];
        }
        return belowTwenty[num / 100] + " Hundred " + helper(num % 100);
    }
}
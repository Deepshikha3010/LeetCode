/**
Word Segmentation
Given a long string S, only include normal English words, words are separated by a single space, and give you a positive integer. Please divide the string into several lines. Requirement 1: You can only wrap between words. The same word cannot be separated; Requirement 2: Each line cannot be more than one character after the division.

Example
Give s="aaaa bbb cccc ddd ee ff ggggg", k=8,return ["aaaa bbb","cccc ddd","ee ff","ggggg"]

Notice
String length does not exceed 100000
Data guarantee legal
 */

public class Solution {
    /**
     * @param s: the string
     * @param k: the k
     * @return: the answer
     */
    public String[] wordSegmentation(String s, int k) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }
        
        String[] record = s.split(" ");
        List<String> list = new ArrayList<>();
        int index = 0;
        while (index < record.length){
            int temp = k;
            StringBuilder sb = new StringBuilder();
            while (index < record.length && record[index].length() <= temp) {
                sb.append(record[index] + " ");
                temp -= record[index].length() + 1;
                index++;
            }
            list.add(sb.substring(0, sb.length() - 1).toString());
        }
        
        return list.toArray(new String[list.size()]);
    }
}
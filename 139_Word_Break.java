/**
 * String DP
 * 一般String DP的状态数组长度为s.length() + 1。
 * f[i]代表前i个子字符串的状态。因为第一层循环的起点为1。
 * 此特性正好与substring()含头不含尾相符。
 * 第二层循环的自增数为lastWordLen(最后一个字符串的长度)。
 * 
 */

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        int maxLen = 0;
        for(String word : wordDict){
            set.add(word);
            maxLen = Math.max(maxLen, word.length());
        }
        int len = s.length();
        boolean[] f = new boolean[len + 1];
        f[0] = true;
        for(int i = 1; i <= len; i++){
            for(int lastWordLen = 1; lastWordLen <= maxLen && lastWordLen <= i; lastWordLen++){
                if(f[i - lastWordLen] && set.contains(s.substring(i - lastWordLen, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        return f[len];
    }
}
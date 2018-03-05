/**
 * 分割
 * 分割
 */

class Solution {
    public boolean dicToWord(Set<E> set, String word){
        for(int i = 0; i < word.length(); i++){
            String pre = word.substring(0, i + 1);
            String post = word.substring(i + 1, word.length() + 1);
            if(set.contains(pre) && set.contains(post)){
                return true;
            }
        }
        return false;
    }
}
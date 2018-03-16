/**
 * 解法类似strstr.
 * 用Set检查相同元素。
 * 时间复杂度n2，空间复杂度n。
 */

class Solution {
    public List<String> buildSubsequences(String s){
        List<String> result = new ArrayList<>();
        if(s == null){
            return result;
        }
        Set<String> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length() + 1; j++){
                String cur = s.substring(i, j);
                if(!cur.equals("")){
                    set.add(cur);
                }
            }
        }
        for(String str : set){
            result.add(str);
        }
        return result;
    }
}
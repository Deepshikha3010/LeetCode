/**
Solution 1: HashMap
时间复杂度nk, 空间复杂度n （k为word长度）
1. 将word转化成int[]，相当于排序。
2. 将int[]重新组成word，再用HashMap归类。

Solution 2: HashMap + Sort
时间复杂度nklogk, 空间复杂度n （k为word长度）
1. 讲word转化成char[]， 用Arrays.sort直接排序。
 */

/**Solution 1 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if(strs == null || strs.length == 0){
            return result;
        }
        
        int[][] record = new int[strs.length][256];
        for(int i = 0; i < strs.length; i++){
            String str = strs[i];
            for(int j = 0; j < str.length(); j++){
                char c = str.charAt(j);
                record[i][c]++;
            }
        }
        
        Map<String, List<String>> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < record.length; i++){
            int[] asc = record[i];
            for(int j = 0; j < asc.length; j++){
                if(asc[j] > 0){
                    sb.append(asc[j]);
                    sb.append((char) j);
                }
            }
            if(map.containsKey(sb.toString())){
                map.get(sb.toString()).add(strs[i]);
            }else{
                map.put(sb.toString(), new ArrayList<>());
                map.get(sb.toString()).add(strs[i]);
            }
            sb = new StringBuilder();
        }
        for(String key : map.keySet()){
            result.add(map.get(key));
        }
        return result;
    }
}

/**Solution 2 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if(strs == null || strs.length == 0){
            return result;
        }
        
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String hashStr = String.valueOf(cs);
            if(map.containsKey(hashStr)){
                map.get(hashStr).add(str);
            }else{
                map.put(hashStr, new ArrayList<>());
                map.get(hashStr).add(str);
            }
        }
        for(String hashStr : map.keySet()){
            result.add(map.get(hashStr));
        }
        return result;
    }
}
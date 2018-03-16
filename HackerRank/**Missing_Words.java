/**
 * Godday
 * Julia and Samantha are playing with strings. Julia has a string S, and Samantha has a string T which is a subsequence of string S. They are trying to find out what words are missing in T.
 * Help Julia and Samantha to solve the problem. List all the missing words in T, such that inserting them at the appropriate positions in T, in the same order, results in the string S.
 * Constraints
 * 1 <= |T| <= |S| <= 106, where |X| denotes the length of string X.
 * The length of each word will be less than 15.
 *  
 * Function Parameter
 * You are given a function missingWords that takes the strings S and T as its arguments.
 *  
 * Function Return Value
 * Return an array of the missing words.
 *  
 * Sample Input
 * I am using hackerrank to improve programming
 * am hackerrank to improve
 * Sample Output
 * I
 * using
 * programming
 * Explanation
 * Missing words are:
 * 1. I  
 * 2. using  
 * 3. programming  
 * 
 * Solution 1: 时间复杂度n, 空间复杂度n
 * 1. 创建一个HashMap.
 * 2. 统计S里面每个word的freq。
 * 3. 遍历T的words，统计差距。
 * 
 * Solution 2: 时间复杂度n, 空间复杂度n
 * 优化：因为T是S的子字符串，所以顺序是对应的。只需要用两个指针一一对应查找即可。
 */

/**Solution 1 */
class Solution {
    public List<String> missingWords(String S, String T){
        List<String> result = new ArrayList<>();
        if(S == null){
            return result;
        }
        if(T == null){
            return S.split(" ");
        }
        String[] ss = S.split(" ");
        String[] tt = T.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for(String str : ss){
            if(map.containsKey(str)){
                map.put(str, map.get(str) + 1);
            }else{
                map.put(str, 1);
            }
        }
        for(String str : tt){
            map.put(str, map.get(str) - 1);
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() > 0){
                for(int i = 0; i < entry.getValue(); i++){
                    result.add(entry.getKey());
                }
            }
        }
        return result;
    }
}

/**Solution 2 */
class Solution {
    public List<String> missingWords(String S, String T){
        List<String> result = new ArrayList<>();
        if(S == null){
            return result;
        }
        if(T == null){
            return S.split(" ");
        }
        String[] ss = S.split(" ");
        String[] tt = T.split(" ");
        for(int i = 0, j = 0; i < ss.length && j < tt.length; i++){
            if(ss[i] != tt[j]){
                result.add(ss[i]);
            }else{
                j++;
            }
        }
        return result;
    }
}
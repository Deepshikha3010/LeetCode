/**
 * backtracking: 相当于嵌套for循环。
 * 每次迭代先将上次迭代的结果加入result，不往回看。
 * 
 * Solution: -- 时间复杂度n2，空间复杂度1
 * 1. index记录上次迭代的终止位置。
 * 2. record要在每次迭代一开始进行。
 * 3. result.add(new ArrayList<>(record));
 */

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        
        helper(nums, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void helper(int[] nums, int index, List<Integer> record, List<List<Integer>> result){
        result.add(new ArrayList<>(record));
        for(int i = index; i < nums.length; i++){
            record.add(nums[i]);
            helper(nums, i + 1, record, result);
            record.remove(record.size() - 1);
        }
    }
}

/**
 * Godaddy
 * 变形：Build Subsequences 返回输入String的所有Subsequence
 * 限制：
 * 1. 空String不算。
 * 2. 不能有重复的。
 * 3. 返回数组按照字母升序排列。
 * 例子：输入“bab”， 返回["a", "ab", "b", "ba", "bab”]
 * 
 */

 class Solution {
    public List<String> subsets(String word){
        List<String> result = new ArrayList<>();
        if(str == null || word.length() == 0){
            return result;
        }
        Set<String> record = new HashSet<>();
        helper(word, "", 0, record);
        Comparator<String> comp = new Comparator<String>(){
            public int compare(String str1, String str2){
                return str2.compareTo(str1);
            }
        };
        PriorityQueue<String> pq = new PriorityQueue<>(comp);
        for(String str : set){
            pq.offer(str);
        }
        while(pq.size() > 0){
            result.add(pq.poll());
        }
        return result;
    }

    private void helper(String word, String str, int index, Set<String> record){
        if(str.length() > 0){
            record.add(str);
        }
        if(index < word.length()){
            for(int i = index; i < word.length(); i++){
                str += word.charAt(i);
                helper(word, str, index + 1, record);
                str.substring(0, str.length() - 1);
            }
        }
    }
 }
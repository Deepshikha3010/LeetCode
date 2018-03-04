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
        if(index < nums.length){
            for(int i = index; i < nums.length; i++){
                record.add(nums[i]);
                helper(nums, i + 1, record, result);
                record.remove(record.size() - 1);
            }
        }    
    }
}
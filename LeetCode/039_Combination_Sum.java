/**
 * Type: Backtracking
 * Time: 2^n (w/ pruning)
 * Space: n
 */

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        
        Arrays.sort(candidates);  
        helper(candidates, 0, 0, new ArrayList<>(), target, res);
        
        return res;
    }
    
    private void helper(int[] candidates, int index, int sum, List<Integer> record, int target, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(record));
            return;
        }
        
        for (int i = index; i < candidates.length; i++) {
            int cur = candidates[i];
            if (sum + cur > target) {
                break;
            }
            record.add(cur);
            helper(candidates, i, sum + cur, record, target, res);
            record.remove(record.size() - 1);
        }
    }
}
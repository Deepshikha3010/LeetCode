class Solution {
    int goal;
    
    private class Check {
        int index;
        int sum;
        Check(int index, int sum) {
            this.index = index;
            this.sum = sum;
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        goal = target;
        Arrays.sort(candidates);
        helper(candidates, new Check(0, 0), new ArrayList<>(), result);
        return result;
    }
    
    private void helper(int[] candidates, Check check, List<Integer> record, List<List<Integer>> result) {
        if (check.sum == goal) {
            result.add(new ArrayList<>(record));
            return;
        }
        int index = check.index;
        for (int i = index; i < candidates.length; i++) {
            int cur = candidates[i];
            if (check.sum + cur <= goal) {
                record.add(cur);
                helper(candidates, new Check(i, check.sum + cur), record, result);
                record.remove(record.size() - 1);
            }
        }
    }
}
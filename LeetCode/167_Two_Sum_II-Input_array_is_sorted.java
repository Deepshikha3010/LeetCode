class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null ||numbers.length == 0) {
            return new int[0];
        }
        
        int start = 0, end = numbers.length - 1;
        while (start < end) {
            int cur = numbers[start] + numbers[end];
            if (cur == target) {
                return new int[]{start + 1, end + 1};
            } else if (cur < target) {
                start++;
            } else {
                end--;
            }
        }
        
        return new int[0];
    }
}
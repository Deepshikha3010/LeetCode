// Long
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        long pre = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            long next = i == nums.length - 1 ? Long.MIN_VALUE : (long) nums[i + 1];
            if (pre < cur && cur > next) {
                return i;
            }
            pre = (long)cur;
        }
        
        return -1;
    }
}

// Best Solution
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }
}

// Binary Search
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] < nums[end]) {
            return end;
        }
        return start;
    }
}
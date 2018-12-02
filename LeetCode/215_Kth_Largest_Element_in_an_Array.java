/**
 * Heap
 * Time: nlogk
 * Space: k
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        return pq.peek();
    }
}

/**
 * Quick Select
 * Time: n (worst n^2)
 * Space: 1
 * 
 * Explain time complexity: https://www.jiuzhang.com/qa/1489/
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return -1;
        }
        
        int left = 0, right = nums.length - 1;
        while (true) {
            int i = partition(nums, left, right);
            if (i + 1 == k) {
                return nums[i];
            } else if (i + 1 < k) {
                left = i + 1;
            } else {
                right = i - 1;
            }
        }

    }
    
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1;
        int r = right;
        while (l <= r) {
            while (l <= r && nums[l] >= pivot) {
                l++;
            }
            while (l <= r && nums[r] <= pivot) {
                r--;
            }
            if (l <= r && nums[l] < pivot && nums[r] > pivot) {
                swap(nums, l, r);
                l++;
                r--;
            }
        }
        swap(nums, left, r);
        return r;
    }
    
    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}


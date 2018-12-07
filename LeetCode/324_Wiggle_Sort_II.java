/**
 * 3 way swap: Color Sort
 * 1. i指向需要被替换的数字位置，
 * 2. newIndex(left)指下一个大于median的元素将插入的位置。
 * 3. newIndex(right)指下一个小于median的元素将插入的位置。
 */

class Solution {
  public void wiggleSort(int[] nums) {
      if (nums == null || nums.length < 2) {
          return;
      }

      // Divide arr into 2 parts, left nums are bigger than right nums.
      // Put left and right nums into the arr intervally.
      
      int median = findKthLargest(nums, (nums.length + 1) / 2);
      int n = nums.length;

      int left = 0, index = 0, right = n - 1;
      while (index <= right) {
          if (nums[newIndex(index, n)] > median) {
              swap(nums, newIndex(left++, n), newIndex(index++, n));
          } else if (nums[newIndex(index, n)] < median) {
              swap(nums, newIndex(right--, n), newIndex(index, n));
          } else {
              index++;
          }
      }
  }
  
  private int newIndex(int index, int n) {
      return (1 + 2 * index) % (n | 1);
  }
  
  private  int findKthLargest(int[] nums, int k) {
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
      int l = left + 1, r = right;
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
// Merge Sort
public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        int[] temp = new int[A.length];
        mergeSort(A, temp, 0, temp.length - 1);
    }
    
    private void mergeSort(int[] A, int[] temp, int start, int end) {
        if (start >= end) {
            return;
        }
        
        int mid = start + (end - start) / 2;
        mergeSort(A, temp, start, mid);
        mergeSort(A, temp, mid + 1, end);
        
        int index = start;
        int left = start;
        int right = mid + 1;
        
        while(left <= mid && right <= end) {
            int leftNum = A[left];
            int rightNum = A[right];
            if (leftNum < rightNum) {
                temp[index] = leftNum;
                left++;
            } else {
                temp[index] = rightNum;
                right++;
            }
            index++;
        }
        while(left <= mid) {
            int leftNum = A[left];
            temp[index] = leftNum;
            index++;
            left++;
        }
        while(right <= end) {
            int rightNum = A[right];
            temp[index] = rightNum;
            index++;
            right++;
        }
        for (int i = start; i <= end; i++) {
            A[i] = temp[i];
        }
    } 
}

// Quick Sort
public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        quickSort(A, 0, A.length - 1);
    }
    
    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int mid = start + (end - start) / 2;
        int pivot = nums[mid];
        
        while(left < right) {
            while(left <= right && nums[left] < pivot) {
                left++;
            }
            while(left <= right && nums[right] > pivot) {
                right--;
            }
            
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        
        quickSort(nums, start, right);
        quickSort(nums, left, end);
    }
}

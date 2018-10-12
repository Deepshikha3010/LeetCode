class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        
        if (n % 2 == 0) {
            return (
                findKth(nums1, 0, nums2, 0, n / 2) +
                findKth(nums1, 0, nums2, 0, n / 2 + 1)
            ) / 2.0;
        }
        
        return findKth(nums1, 0, nums2, 0, n / 2 + 1);
    }
    
    private int findKth(int[] nums1, int startA, int[] nums2, int startB, int k) {
        if (startA >= nums1.length) {
            return nums2[startB + k - 1];
        }
        if (startB >= nums2.length) {
            return nums1[startA + k - 1];
        }
        
        if (k == 1) {
            return Math.min(nums1[startA], nums2[startB]);
        }
        
        int halfKthA = startA + k / 2 - 1 < nums1.length ? nums1[startA + k / 2 - 1] : Integer.MAX_VALUE;
        int halfKthB = startB + k / 2 - 1 < nums2.length ? nums2[startB + k / 2 - 1] : Integer.MAX_VALUE;
        
        if (halfKthA < halfKthB) {
            return findKth(nums1, startA + k / 2, nums2, startB, k - k / 2);
        }
        return findKth(nums1, startA, nums2, startB + k / 2, k - k / 2);
    }
}
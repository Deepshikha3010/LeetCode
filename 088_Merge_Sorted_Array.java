/**
 * Two Pointers: 不能增加空间复杂度，从大数组的后面开始排序。
 * 注意：merged数组的最后一个index应该是m + n - 1;
 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pt1 = m - 1;
        int pt2 = n - 1;
        int index = m + n - 1;
        while(pt1 >= 0 && pt2 >= 0){
            if(nums1[pt1] > nums2[pt2]){
                nums1[index] = nums1[pt1];
                pt1--;
            }else{
                nums1[index] = nums2[pt2];
                pt2--;
            }
            index--;
        }
        while(pt1 >= 0){
            nums1[index] = nums1[pt1];
            pt1--;
            index--;
        }
        while(pt2 >= 0){
            nums1[index] = nums2[pt2];
            pt2--;
            index--;
        }
    }
}
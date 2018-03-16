/**
 * Sort + Two Pointers
 * 
 * Solution 1:时间复杂度n2, 空间复杂度n
 * 注意：
 * 1. 起点指针在i > 0的时候value不能与前一位的value相同，防止重复结果。因为后面的双指针会将此起点的所有情况排列出来，所以可以放心跳过。
 * 2. start与end指针在不是起点的时候不因与上一个位置的值相同，同样是防止重复结果。因为前面一个相同的值如果符合题目要求，便已经把本位置的情况考虑进去了。如果是起点位置，可以不用考虑，因为一定是与前一次遍历不同的值。
 * 
 * Solution 2:时间复杂度n2,空间复杂度n
 * 相对于Solution 1的优化：
 * 1. 将startNum + endNum == target的情况放到while循环的第一位，因为一定不与之前的重复。
 * 2. startNum + endNum == target的情况考虑完后再用while排除重复。
 */

/**Solution 1 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int target = -nums[i];
            List<List<Integer>> record = helper(nums, i + 1, target);
            result.addAll(new ArrayList<>(record));
        }
        return result;
    }
    
    private List<List<Integer>> helper(int[] nums, int index, int target){
        List<List<Integer>> record = new ArrayList<>();
        int start = index, end = nums.length - 1;
        while(start < end){
            while(start < end && start != index && nums[start] == nums[start - 1]){
                start++;
            }
            while(start < end && end != nums.length - 1 && nums[end] == nums[end + 1]){
                end--;
            }
            if(start < end){
                int startNum = nums[start];
                int endNum = nums[end];
                if(startNum + endNum == target){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(-target);
                    temp.add(startNum);
                    temp.add(endNum);
                    record.add(temp);
                    start++;
                    end--;
                }else if(startNum + endNum < target){
                    start++;
                }else{
                    end--;
                } 
            }
            
        }
        return record;
    }
}

/**Solution 2 */
public class Solution {
    /**
     * @param nums : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        
        if (nums == null || nums.length < 3) {
            return results;
        }
        
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // skip duplicate triples with the same first numebr
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1, right = nums.length - 1;
            int target = -nums[i];
            
            twoSum(nums, left, right, target, results);
        }
        
        return results;
    }
    
    public void twoSum(int[] nums,
                       int left,
                       int right,
                       int target,
                       List<List<Integer>> results) {
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                ArrayList<Integer> triple = new ArrayList<>();
                triple.add(-target);
                triple.add(nums[left]);
                triple.add(nums[right]);
                results.add(triple);
                
                left++;
                right--;
                // skip duplicate pairs with the same left
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                // skip duplicate pairs with the same right
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
    }
}
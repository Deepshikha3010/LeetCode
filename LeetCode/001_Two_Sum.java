/**
 * 因为不是sort array，只能使用HashMap记录位置。
 * 
 * 时间复杂度n, 空间复杂度n
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return null;
        }
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int value = nums[i];
            if(map.containsKey(target - value)){
                result[0] = map.get(target - value);
                result[1] = i;
                return result;
            }else{
                map.put(value, i);
            }
        }
        return result;
    }
}
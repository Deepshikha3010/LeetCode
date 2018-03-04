/**
 * Godaddy
 * Count Duplicates
 * 返回输入数组中重复数字的个数，举个例子以免误解。输入是[1, 3, 3, 4, 4, 5, 5, 5, 6, 6, 6]，那么返回4， 因为有4个数字重复出现过。
 * 
 * Solution: 时间复杂度n, 空间复杂度n
 * 1. 创建Map，将数组元素放入Map。统计freq。
 * 2. 遍历Map，统计freq大于1的元素的个数。
 */

class Solution {
    public int countDuplicate(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else{
                map.put(num, 1);
            }
        }
        int result = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int freq = entry.getValue();
            if(freq > 1){
                result++;
            }
        }
        return result;
    }
}
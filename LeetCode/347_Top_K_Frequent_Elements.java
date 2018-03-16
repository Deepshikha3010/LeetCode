/**
 * HashMap + PriorityQueue: 解法与 692. Top K Frequent Words 完全一样
 * 
 * Solution 1: 时间复杂度klogn, 空间复杂度n
 */

/**Solution 1 */
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else{
                map.put(num, 1);
            }
        }
        Comparator<Map.Entry<Integer, Integer>> comp = new Comparator<Map.Entry<Integer, Integer>>(){
            public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2){
                return entry1.getValue().compareTo(entry2.getValue());
            }
        };
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(comp);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer(entry);
            if(pq.size() > k){
                pq.poll();
            }
        }
        while(!pq.isEmpty()){
            result.add(pq.poll().getKey());
        }
        Collections.reverse(result);
        return result;
    }
}
/**
 * PriorityQueue 默认小的靠前。
 * 在Comparator内，freq和alphabelta order需要相反处理，freq越大越靠前，alpha越大越靠后。
 * 
 * Solution 1: -- 时间复杂度nlogn，空间复杂度n
 * 1. 用HashMap统计freq。
 * 2. 用PriorityQueue存放HashMap的元素。
 * 3. 取出前k个元素。
 * 
 * Solution 2：-- 时间复杂度nlogk，空间复杂度n
 * 相比Solution 1，在priorityqueue中反向排序，用poll控制priorityqueue的size。最后反向result list。
 */


/**Solution 1 */
class Solution {
    private class FreqNode{
        String word;
        int freq;
        FreqNode(String word, int freq){
            this.word = word;
            this.freq = freq;
        }
    }
    
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
            if(!map.containsKey(word)){
                map.put(word, 1);
            }else{
                map.put(word, map.get(word) + 1);
            }
        }
        int len = 0;
        FreqNode[] nodes = new FreqNode[k];
        
        Comparator<FreqNode> comp = new Comparator<FreqNode>(){
            public int compare(FreqNode node1, FreqNode node2){
                if(node1.freq != node2.freq){
                    return node2.freq - node1.freq;
                }else{
                    return alphabeticalOrder(node1.word, node2.word);
                }
            }
        };
        PriorityQueue<FreqNode> pq = new PriorityQueue<>(comp);
        
        for(String word : map.keySet()){
            int freq = map.get(word);
            pq.offer(new FreqNode(word, freq));
        }
        
        List<String> result = new ArrayList<>();
        for(int i = 0; i < k; i++){
            result.add(pq.poll().word);
        }
        return result;
    }
    
    private int alphabeticalOrder(String str1, String str2){
        char[] sc1 = str1.toCharArray();
        char[] sc2 = str2.toCharArray();
        int len = sc1.length < sc2.length ? sc1.length : sc2.length;
        for(int i = 0; i < len; i++){
            char c1 = sc1[i];
            char c2 = sc2[i];
            if(c1 > c2){
                return 1;
            }else if(c1 < c2){
                return -1;
            }
        }
        if(sc1.length < sc2.length){
            return -1;
        }else{
            return 1;
        }
    }
}

/**Solution 2 */
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
            if(map.containsKey(word)){
                map.put(word, map.get(word) + 1);
            }else{
                map.put(word, 1);
            }
        }
        
        Comparator<Map.Entry<String, Integer>> comp = new Comparator<Map.Entry<String, Integer>>(){
            public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2){
                if(m1.getValue() == m2.getValue()){
                    return m2.getKey().compareTo(m1.getKey());
                }else{
                    return m1.getValue() - m2.getValue();
                }
            }
        };
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(comp);
        
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            pq.offer(entry);
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        while(pq.size() > 0){
            result.add(pq.poll().getKey());
        }
        
        Collections.reverse(result);
        return result;
    }
}
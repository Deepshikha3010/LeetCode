class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        
        Map<Character, Set<Character>> graph = constructGraph(words);
        return topologicalSorting(graph);
    }
    
    private Map<Character, Set<Character>> constructGraph(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                if (!graph.containsKey(c)) {
                    graph.put(c, new HashSet<>());
                }
            }
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            int index = 0;
            while (index < words[i].length() && index < words[i + 1].length()) {
                if (words[i].charAt(index) != words[i + 1].charAt(index)) {
                    graph.get(words[i].charAt(index)).add(words[i + 1].charAt(index));
                    break;
                }
                index++;
            }
        }
        
        return graph;
    }
    
    private Map<Character, Integer> getIndegree(Map<Character, Set<Character>> graph) {
        Map<Character, Integer> indegree = new HashMap<>();
        for (char u : graph.keySet()) {
            indegree.put(u, 0);
        }
        
        for (char u : graph.keySet()) {
            for (char v : graph.get(u)) {
                indegree.put(v, indegree.get(v) + 1);
            }
        }
        
        return indegree;
    }
    
    private String topologicalSorting(Map<Character, Set<Character>> graph) {
        Map<Character, Integer> indegree = getIndegree(graph);
        
        Queue<Character> queue = new PriorityQueue<>();
        
        for (char u : indegree.keySet()) {
            if (indegree.get(u) == 0) {
                queue.offer(u);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char cur = queue.poll();
            sb.append(cur);
            for (char next : graph.get(cur)) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }
        
        if (sb.length() != indegree.size()) {
            return "";
        }
        
        return sb.toString();
    }
}
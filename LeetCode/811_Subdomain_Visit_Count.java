class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>();
        if (cpdomains == null || cpdomains.length == 0) {
            return res;
        }
        
        Map<String, Integer> map = new HashMap<>();
        for (String s : cpdomains) {
            String[] ss = s.split(" ");
            int count = Integer.parseInt(ss[0]);
            
            String[] subs = ss[1].split("\\.");
            String record = "";
            for (int i = subs.length - 1; i >= 0; i--) {
                record = subs[i] + record;
                if (!map.containsKey(record)) {
                    map.put(record, 0);
                }
                map.put(record, map.get(record) + count);
                record = "." + record;
            }
        }
        
        for (String s : map.keySet()) {
            res.add("" + map.get(s) + " " + s);
        }
        
        return res;
    }
}
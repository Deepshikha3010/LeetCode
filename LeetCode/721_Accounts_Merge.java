class Solution {
    private class UF {
        Map<String, String> map;
        
        UF(Set<String> set) {
            this.map = new HashMap<>();
            for (String s : set) {
                map.put(s, s);
            }
        }
        
        String find(String s) {
            if (map.get(s) == s) {
                return s;
            }
            map.put(s, find(map.get(s)));
            return map.get(s);
        }
        
        void connect(String a, String b) {
            String root_a = find(a);
            String root_b = find(b);
            if (!root_a.equals(root_b)) {
                map.put(root_a, root_b);
            }
        }
    }
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        if (accounts == null || accounts.size() == 0 || accounts.get(0).size() == 0) {
            return res;
        }
        
        Map<String, String> emailToName = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                set.add(account.get(i));
                if (!emailToName.containsKey(account.get(i))) {
                    emailToName.put(account.get(i), name);
                }
            }
        }
        
        UF uf = new UF(set);
        
        for (List<String> account : accounts) {
            String name = account.get(0);
            String root = uf.find(account.get(1));
            for (int i = 2; i < account.size(); i++) {
                uf.connect(account.get(i), root);
            }
        }
        
        Map<String, Set<String>> rootToEmails = new HashMap<>();
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                String root = uf.find(account.get(i));
                if (!rootToEmails.containsKey(root)) {
                    rootToEmails.put(root, new HashSet<>());
                }
                rootToEmails.get(root).add(account.get(i));
            }
        }
        
        for (String root : rootToEmails.keySet()) {
            List<String> record = new ArrayList<>(rootToEmails.get(root));
            Collections.sort(record);
            record.add(0, emailToName.get(root));
            res.add(record);
        }
        
        return res;
    }
}
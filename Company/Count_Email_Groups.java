/**
input：一个array 里面是一组代表email的string, 每个string的格式是local@domain，eg. ['a@example.com', ' a+b@example.com', 'a.b@example.com', 'ab@exam.ple.com’] 
规则：对于local的部分，如果遇见’.’则自动忽略，如果遇见’+’则忽略后面所有字符
         对于domain部分，local的法则不适用，所以’a@example.com’和’a@exam.ple.com’是不同的email
运用上述规则后，把相同的email放在一个组，然后返回组内超过2个email的组的个数
 */

public class Solution {
    /**
     * @param emails: Original email
     * @return: Return the count of groups which has more than one email address in it.
     */
    public int countGroups(List<String> emails) {
        if (emails == null || emails.size() == 0) {
            return 0;
        }
        
        Map<String, Integer> map = new HashMap<>();
        for (String str : emails) {
            String s = transformStr(str);
            if (!map.containsKey(s)) {
                map.put(s, 0);
            }
            map.put(s, map.get(s) + 1);
        }
        
        int res = 0;
        for (String key : map.keySet()) {
            if (map.get(key) >= 2) {
                res++;
            }
        }
        
        return res;
    }
    
    private String transformStr(String s) {
        String[] parts = s.split("@");
        
        StringBuilder sb = new StringBuilder();
        for (char c : parts[0].toCharArray()) {
            if (c == '.') {
                continue;
            }
            if (c == '+') {
                break;
            }
            sb.append(c);
        }
        
        sb.append("@" + parts[1]);
        
        return sb.toString();
    }
}
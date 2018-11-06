class Solution {
    public String nearestPalindromic(String n) {
        int len = n.length();
        long num = Long.parseLong(n);
        long minDiff = Long.MAX_VALUE;
        long res = Long.MAX_VALUE;
        
        Set<Long> set = new HashSet<>();
        
        set.add((long)Math.pow(10, len) + 1);
        set.add((long)Math.pow(10, len - 1) - 1);
        
        long prefix = Long.parseLong(n.substring(0, (len + 1) / 2));
        
        for (int i = -1; i <= 1; i++) {
            String pre = Long.toString(prefix + i);
            String str;
            if (len % 2 == 0) {
                str = pre + new StringBuilder(pre).reverse().toString();
            } else {
                str = pre + new StringBuilder(pre.substring(0, pre.length() - 1)).reverse().toString();
            }
            set.add(Long.parseLong(str));
        }
        
        set.remove(num);
        for (long a : set) {
            System.out.println(a);
            long diff = Math.abs(a - num);
            if (diff < minDiff) {
                minDiff = diff;
                res = a;
            } else if (diff == minDiff) {
                res = Math.min(res, a);
            }
        }
        
        return Long.toString(res);
    }
}
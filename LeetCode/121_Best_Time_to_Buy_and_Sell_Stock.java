class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int cur = prices[i];
            min = Math.min(cur, min);
            max = Math.max(cur - min, max);
        }
        return max;
    }
}
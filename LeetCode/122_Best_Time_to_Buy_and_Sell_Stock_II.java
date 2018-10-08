class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int index = 0;
        int len = prices.length;
        int sum = 0;
        while(index < len) {
            while(index + 1 < len && prices[index] >= prices[index + 1]) {
                index++;
            }
            if (index + 1 < len) {
                sum += prices[index + 1] - prices[index];
            }
            index++;
        }
        return sum;
    }
}
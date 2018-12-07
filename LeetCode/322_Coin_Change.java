/**
 * Type: DP
 * Time: m*n
 * Space: m
 * 
 */
class Solution {
  public int coinChange(int[] coins, int amount) {
      if (coins == null || coins.length == 0) {
          return -1;
      }
      
      int[] f = new int[amount + 1];
      Arrays.fill(f, Integer.MAX_VALUE);
      f[0] = 0;
      
      for (int i = coins.length - 1; i >= 0; i--) {
          for (int j = 0; j <= amount; j++) {
              if (j >= coins[i]) {
                  int pre = f[j - coins[i]];
                  if (pre < Integer.MAX_VALUE) {
                      f[j] = Math.min(f[j], pre + 1);
                  }
              }
          }
      }
      
      return f[amount] != Integer.MAX_VALUE ? f[amount] : -1;
  }
}
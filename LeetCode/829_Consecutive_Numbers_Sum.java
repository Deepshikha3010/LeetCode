/**
 * Type: Math
 * Time: n^0.5
 * Space: 1
 * 
N can be expressed as k + 1, k + 2, ..., k + i, where k is a positive integer; therefore

N = k * i + (i + 1) * i / 2 =>
N - (i + 1) * i / 2 = k * i, which implies that as long as N - (i + 1) * i / 2 is k times of i, we get a solution corresponding to i; Hence iteration of all possible values of i, starting from 1, will cover all cases of the problem.

Since for i = 1, N can always be written as one number sequence: N, we can start from i = 2, ans = 1.

 */

class Solution {
  public int consecutiveNumbersSum(int N) {
      int res = 1;
      for (int i = 2; i * (i + 1) / 2 <= N; i++) {
          if ((N - i * (i + 1) / 2) % i == 0) {
              res++;
          }
      }
      return res;
  }
}
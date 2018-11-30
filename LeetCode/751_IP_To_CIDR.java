class Solution {
  public List<String> ipToCIDR(String ip, int n) {
      String[] ips = ip.split("\\.");
      long x = 0;
      for (int i = 0; i < ips.length; i++) {
          x = Integer.parseInt(ips[i]) + x * 256;    
      }
      
      List<String> res = new ArrayList<>();
      while (n > 0) {
          long steps = x & -x;
          while (steps > n) {
              steps /= 2;
          }
          String s = helper(x, (int) steps);
          res.add(s);
          x += steps;
          n -= steps;
      }
      
      return res;
  }
  
  private String helper(long x, int steps) {
      int[] ans = new int[4];
      ans[0] = (int) (x & 255);
      x >>= 8;
      ans[1] = (int) (x & 255);
      x >>= 8;
      ans[2] = (int) (x & 255);
      x >>= 8;
      ans[3] = (int) (x & 255);
      
      int len = 33;
      while (steps > 0) {
          len--;
          steps /= 2;
      }
      
      return ans[3] + "." + ans[2] + "." + ans[1] + "." + ans[0] + "/" + len;
  }
}
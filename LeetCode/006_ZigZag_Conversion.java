class Solution {
  public String convert(String s, int numRows) {
      if (s == null || s.length() == 0 || numRows == 0) {
          return "";
      }
      
      StringBuilder[] sbs = new StringBuilder[numRows];
      for (int i = 0; i < numRows; i++) {
          sbs[i] = new StringBuilder();
      }
      
      int i = 0;
      int len = s.length();
      
      while (i < len) {
          for (int index = 0; index < numRows && i < len; index++) {
              sbs[index].append(s.charAt(i++));
          }
          for (int index = numRows - 2; index >= 1 && i < len; index--) {
              sbs[index].append(s.charAt(i++));
          }
      }
      
      for (int n = 1; n < sbs.length; n++) {
          sbs[0].append(sbs[n]);
      }
      return sbs[0].toString();
  }
}
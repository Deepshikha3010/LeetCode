// diff: number of space
class Solution {
  public List<String> fullJustify(String[] words, int maxWidth) {
      List<String> res = new ArrayList<>();
      if (words == null || words.length == 0) {
          return res;
      }
      
      int index = 0;
      while (index < words.length) {
          int count = words[index].length();
          int last = index + 1;
          while (last < words.length && count + 1 + words[last].length() <= maxWidth) {
              count += 1 + words[last++].length();
          }
          
          StringBuilder sb = new StringBuilder();
          sb.append(words[index]);
          
          int diff = last - index - 1;
          if (last == words.length || diff == 0) {
              for (int i = index + 1; i < last; i++) {
                  sb.append(" ");
                  sb.append(words[i]);
              }
              for (int i = sb.length(); i < maxWidth; i++) {
                  sb.append(" ");
              }
          } else {
              int space = (maxWidth - count) / diff;
              int r = (maxWidth - count) % diff;
              for (int i = index + 1; i < last; i++) {
                  for (int k = space; k > 0; k--) {
                      sb.append(" ");
                  }
                  if (r > 0) {
                      sb.append(" ");
                      r--;
                  }
                  sb.append(" ");
                  sb.append(words[i]);
              }
          }
          index = last;
          res.add(sb.toString());
      }
      
      return res;
  }
}
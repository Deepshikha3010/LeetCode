/**
 * 时间复杂度n，空间复杂度n
 * 1. 将s split成array。
 * 2. 遍历array，将每个string反转，加入stringbuilder
 */

class Solution {
    public String reverseWords(String s) {
        if(s == null){
            return null;
        }
        if(s.length() == 0){
            return "";
        }
        String[] ss = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ss.length; i++){
            String str = ss[i];
            for(int j = str.length() - 1; j >= 0; j--){
                char c = str.charAt(j);
                sb.append(c);
            }
            if(i != ss.length - 1){
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
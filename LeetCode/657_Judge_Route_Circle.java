/**
 * 时间复杂度n, 空间复杂度1
 */

class Solution {
    public boolean judgeCircle(String moves) {
        if(moves == null || moves.length() == 0){
            return true;
        }
        int[] pos = new int[]{0, 0};
        for(int i = 0; i < moves.length(); i++){
            char c = moves.charAt(i);
            if(c == 'U'){
                pos[0]++;
            }else if(c == 'D'){
                pos[0]--;
            }else if(c == 'L'){
                pos[1]++;
            }else{
                pos[1]--;
            }
        }
        return pos[0] == 0 && pos[1] == 0;
    }
}
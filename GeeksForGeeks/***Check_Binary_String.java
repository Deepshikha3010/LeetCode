/**
 * 
 * Solution 1: 时间复杂度n，空间复杂度1
 * 1. 用两个boolean记录之前的0和1的状态: hasOne, thenHasZero.
 * 2. 先看当前是不是1，如果是1则考虑之前是不是已经有1和0了(hasOne && thenHasZero)。如果有则返回INVALID。如果没有则hasOne == true.
 * 3. 如果当前是0,则开启thenHasZero = true。为后面的判断1做准备。
 */

 /**Solution 1 */
class GFG {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i = 0; i < n; i++){
		    String cur = in.next();
		    System.out.println(isValid(cur));
		}
	}
	
	private static String isValid(String str){
        boolean hasOne = false;
        boolean thenHasZero = false;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c == '1'){
                if(hasOne && thenHasZero){
                    return "INVALID";
                }else{
                    hasOne = true;
                }
            }else if(hasOne){
                thenHasZero = true;
            }
        }
        return "VALID";
	}
}
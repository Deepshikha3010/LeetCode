/**
 * 名人的条件：
 * 1. 所有人都不认识
 * 2. 不认识所有人
 * 
 * Solution 1: 嵌套循环+标记 -- 时间复杂度~n2，空间复杂度n (前面判定过的非候选人依旧要与当下候选人进行认识判定，造成时间损失。除非当下候选人被判定不是候选人才会跳出循环)
 * 1. 用一个boolean array记录名人状态，预设true。
 * 2. 每次先判定是不是候选人，如果不是直接跳过。
 * 3. 如果不被人认识或认识别人，则不是候选人，跳出循环。否则别人不是候选人。 -- 每次判定都能判定出一个人是不是候选人，除非因为当下不是候选人而中断。
 * 4. 最后检查array中是不是有人仍然为true。
 * 
 * Solution 2: Two Pass -- 时间复杂度n，空间复杂度1
 * 1. 寻找候选人：一次遍历（n），只有不认识别人的人能保留下来。因为是遍历，所有人都被认证认不认识别人。没保留下来的人都是或多或少认识别人。
 * 2. 判定候选人资格： 一次遍历（n），与所有其他人进行判定，确保不认识所有人，也被所有人认识。
 */

/**Solution 1*/
public class Solution extends Relation {
    public int findCelebrity(int n) {
        boolean[] check = new boolean[n];
        Arrays.fill(check, Boolean.TRUE);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (check[i] && i != j) {
                    if (knows(i, j) || !knows(j, i)) {
                        check[i] = false;
                        break;
                    } else {
                        check[j] = false;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (check[i]) {
                return i;
            }
        }
        return -1;
    }
}

/**Solution 2*/
public class Solution extends Relation {
    public int findCelebrity(int n) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (knows(res, i)) {
                res = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if ((res != i && knows(res, i)) || !knows(i, res)) {
                return -1;
            }
        }
        return res;
    }
}

/**
Description
Given a list of salaries, find out a cap to make the adjusted salary totals or larger then to target. cap is defined as: the current salary is smaller than cap, then cap is used as the new salary, otherwise Keep the original salary

The length of the list does not exceed 100000100000
The salaries do not exceed 1000010000

Example
Give a=[1,2,3,4],target=13,
return 3.

Explanation:
If cap=3, the list will change into [3,3,3,4].
Give a=[1,2,3,4],target=16,
return 4.

Explanation:
If cap=4, the list will change into [4,4,4,4].
 */

public class Solution {
    /**
     * @param a: the list of salary
     * @param target: the target of the sum
     * @return: the cap it should be
     */
    public int getCap(int[] a, int target) {
        if (a == null || a.length == 0) {
            return 0;
        }
        
        Arrays.sort(a);
        
        for (int i = a.length - 1; i >= 0; i--) {
            int cur = a[i];
            int restNum = i + 1;
            if (cur * restNum < target) {
                return target / restNum;
            }
            target -= cur;
        }
        
        return a[0];
    }
}
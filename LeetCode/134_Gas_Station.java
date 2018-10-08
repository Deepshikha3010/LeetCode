class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
            return -1;
        }
        
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            int n = 0;
            int j;
            for (j = 0; j < len; j++) {
                int index = (j + i) % gas.length;
                n += gas[index];
                if (n < cost[index]) {
                    break;       
                }
                n -= cost[index];
            }
            if (j == len) {
                return i;
            }
        }
        return -1;
    }
}

/**
Greedy
http://fisherlei.blogspot.com/2013/11/leetcode-gas-station-solution.html
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
            return -1;
        }
        
        int total = 0, sum = 0, index = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0) {
                sum = 0;
                index = i + 1;
            }
        }
        return total < 0 ? -1 : index;
    }
}
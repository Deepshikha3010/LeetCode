/**
这题给你两个 array, 都是一维的，而是都是int
int houses[] and int stores[], 分别代表各house/store 的location.
让你找出每个houses 最近的 stores。
return 一个int array[], index = houses index, value = 最近的stores的location[br] !!!注意： 可以有多个stores 或 houses 的location都相同。
也想想如果两个都是空集怎么办，虽然题目没有写，但是自己要考虑到吧。
比如： house＝ ［2，6，12，18］
store ＝ ［5， 8， 9 ， 20］
return result ＝ ［5，5，9，20］ 
因为house［0］ ＝ 2， 与store［0］＝ 5 最近， 因此类推
 */

class Solution {
    public int[] storesAndHouses(int[] houses, int[] stores) {
        if (houses == null || houses.length == 0 || stores == null || stores.length == 0) {
            return new int[0];
        }

        Arrays.sort(stores);

        int[] res = new int[houses.length];
        for (int i = 0; i < houses.length; i++) {
            int target = houses[i];

            int start = 0, end = stores.length - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (stores[mid] < target) {
                    start = mid;
                } else {
                    end = mid;
                }
            }

            if (Math.abs(target - stores[start]) < Math.abs(target - stores[end])) {
                res[i] = start;
            } else {
                res[i] = end;
            }
        }

        return res;
    }
}
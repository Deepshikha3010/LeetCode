/**
http://www.cnblogs.com/grandyang/p/5928417.html

1, Sort: make shorter items to the back, so when insert them in new list in the future, higher item will be replaced behind.
2, Make same height lower index item to the front, so they can be insert into the new array first.
 */

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return people;
        }
        
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });
        
        List<int[]> res = new ArrayList<>();
        
        for (int i = 0; i < people.length; i++) {
            int[] cur = people[i];
            res.add(cur[1], cur);
        }
        
        return res.toArray(new int[people.length][]);
    }
}
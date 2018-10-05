/**Wish */

class Solution {
    public int entryTime(String s, String keypad) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Set<Character>> map = getMap(keypad);
        int steps = 0;
        char pre = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char num = s.charAt(i);
            if (pre == num) {
                continue;
            }
            if (map.get(pre).contains(num)) {
                steps += 1;
            } else {
                steps += 2;
            }
            pre = num;
        }
        return steps;
    }

    private Map<Character, Set<Character>> getMap(String keypad) {
        char[] chars = keypad.toCharArray();
        Map<Character, Set<Character>> map = new HashMap<>();
        List<Character[]> list = new ArrayList<>();
        list.add(new Character[]{chars[1], chars[3], chars[4]});
        list.add(new Character[]{chars[0], chars[2], chars[3], chars[4], chars[5]});
        list.add(new Character[]{chars[1], chars[4], chars[5]});
        list.add(new Character[]{chars[0], chars[1], chars[4], chars[6], chars[7]});
        list.add(new Character[]{chars[0], chars[1], chars[2], chars[3], chars[5], chars[6], chars[7], chars[8]});
        list.add(new Character[]{chars[1], chars[2], chars[4], chars[7], chars[8]});
        list.add(new Character[]{chars[3], chars[4], chars[7]});
        list.add(new Character[]{chars[3], chars[4], chars[5], chars[6], chars[8]});
        list.add(new Character[]{chars[4], chars[5], chars[7]});
        for (int i = 0; i < keypad.length(); i++) {
            char c = keypad.charAt(i);
            map.put(c, new HashSet<>(Arrays.asList(list.get(i))));
        }
        return map;
    }
}
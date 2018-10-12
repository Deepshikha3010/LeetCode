class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        if (rowIndex == 0) {
            return res;
        }
        
        while(rowIndex != 0) {
            List<Integer> temp = new ArrayList<>();
            int pre = 0;
            for (int i = 0; i < res.size(); i++) {
                int cur = res.get(i);
                temp.add(pre + cur);
                pre = cur;
            }
            temp.add(1);
            res = temp;
            rowIndex--;
        }
        
        return res;
    }
}
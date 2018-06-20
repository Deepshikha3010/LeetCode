/**
 * Solution 1: 时间复杂度n, 空间复杂度n
 * 1. 利用queue先进先出的特性，保持遍历的先后顺序。
 * 2. 每层循环的长度用size = queue.size()确定。
 * 
 * Solution 2: 时间复杂度n, 空间复杂度n
 * 1. inorder递归，用Map记录每一层的List。
 * 2. 结束递归，for循环讲map中的list放入result。
 */

/**Solution 1 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> subList = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                subList.add(cur.val);
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
            result.add(subList);
        }
        return result;
    }
}

/**Solution 2 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        helper(root, 0, map);
        for(int key : map.keySet()){
            result.add(map.get(key));
        }
        return result;
    }
    
    private void helper(TreeNode node, int level, Map<Integer, List<Integer>> map){
        if(node == null){
            return;
        }
        helper(node.left, level + 1, map);
        if(map.containsKey(level)){
            map.get(level).add(node.val);
        }else{
            List<Integer> record = new ArrayList<>();
            record.add(node.val);
            map.put(level, record);
        }
        helper(node.right, level + 1, map);
    }
}
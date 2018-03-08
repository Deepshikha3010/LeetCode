/**
 * 1. 利用queue先进先出的特性，保持遍历的先后顺序。
 * 2. 每层循环的长度用size = queue.size()确定。
 * 
 * Solution 1: 时间复杂度n, 空间复杂度n
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
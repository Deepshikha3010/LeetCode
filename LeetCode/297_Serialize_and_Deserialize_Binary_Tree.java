/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                sb.append(cur.val + ",");
                if (cur.left != null) {
                    queue.offer(cur.left);
                } else {
                    queue.offer(null);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                } else {
                    queue.offer(null);
                }
            } else {
                sb.append("#,");
            }
            
        }
        
        sb.deleteCharAt(sb.length() - 1);
        
        while (sb.charAt(sb.length() - 1) == '#') {
            sb.delete(sb.length() - 2, sb.length());
        }
        
        sb.append("]");

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0 || data.equals("[]")) {
            return null;
        }
        
        String[] s = data.substring(1, data.length() - 1).split(",");
        
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        
        int i = 1;
        
        boolean isLeft = true;
        TreeNode parent = root;
        while (i < s.length) {
            String cur = s[i];
            TreeNode child;
            if (cur.equals("#")) {
                child = null;
            } else {
                child = new TreeNode(Integer.parseInt(cur));
                queue.offer(child);
            }
            
            if (isLeft) {
                parent.left = child;
            } else {
                parent.right = child;
                parent = queue.poll();
            }
            
            isLeft = !isLeft;
            i++;
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
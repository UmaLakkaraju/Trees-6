import java.util.LinkedList;
import java.util.Queue;

//TC-O(N) is linear  and SC-O(N)
public class SerializeAndDeSerializeBinaryTree {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            StringBuilder sb = new StringBuilder();

            while (!q.isEmpty()) {
                TreeNode curr = q.poll();

                if (curr == null) {
                    sb.append("# ");
                } else {
                    sb.append(curr.val).append(" ");
                    q.add(curr.left);
                    q.add(curr.right);
                }
            }
            System.out.println(sb.toString());
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.isEmpty() || data.equals("#")) return null;

            String[] strArr = data.split(" ");
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.parseInt(strArr[0]));
            queue.add(root);
            int i = 1;

            while (!queue.isEmpty() && i < strArr.length) {
                TreeNode current = queue.poll();

                // Process left child
                if (i < strArr.length && !strArr[i].equals("#")) {
                    TreeNode left = new TreeNode(Integer.parseInt(strArr[i]));
                    current.left = left;
                    queue.add(left);
                }
                i++;

                // Process right child
                if (i < strArr.length && !strArr[i].equals("#")) {
                    TreeNode right = new TreeNode(Integer.parseInt(strArr[i]));
                    current.right = right;
                    queue.add(right);
                }
                i++;
            }

            return root;
        }
    }



public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }


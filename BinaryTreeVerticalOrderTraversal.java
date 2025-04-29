import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//TC-O(N) SC-O(N)
public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null)
            return result;
        //map to store the horizontal distance and node list as key and value.
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        Queue<TreeNode> tq=new LinkedList<>();
        Queue<Integer> colq=new LinkedList<>();
        int min=0 ; int max=0;
        tq.add(root);
        colq.add(0);
        map.put(0,new ArrayList<>());
        map.get(0).add(root.val);
        while(!tq.isEmpty()){
            TreeNode curr=tq.poll();
            int col=colq.poll();

            if(curr.left != null){
                if(!map.containsKey(col-1)){
                    map.put(col-1,new ArrayList<Integer>());
                }
                map.get(col-1).add(curr.left.val);
                tq.add(curr.left);
                colq.add(col-1);
            }
            if(curr.right !=null){
                if(!map.containsKey(col+1)){
                    map.put(col+1,new ArrayList<Integer>());
                    map.get(col+1).add(curr.right.val);
                }else{
                    map.get(col+1).add(curr.right.val);
                }
                tq.add(curr.right);
                colq.add(col+1);

            }
            min=Math.min(col-1,min);
            max=Math.max(col+1,max);

        }
        for(int i=min+1 ; i<max;i++){
            result.add(map.get(i));
        }
        return result;
    }
    public class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}

/*
List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        // Map to hold HD -> list of node values
        Map<Integer, List<Integer>> columnMap = new HashMap<>();
        // Queue to hold pairs of (node, HD)
        //Pair<TreeNode, Integer> is from javafx.util.Pair or you can create your own simple Pair class if you don't want to import.
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));
        int min = 0, max = 0;

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int hd = pair.getValue();

            columnMap.computeIfAbsent(hd, k -> new ArrayList<>()).add(node.val);

            if (node.left != null)
                queue.offer(new Pair<>(node.left, hd - 1));
            if (node.right != null)
                queue.offer(new Pair<>(node.right, hd + 1));

            min = Math.min(min, hd);
            max = Math.max(max, hd);
        }

        // Collect results from min to max HD
        for (int i = min; i <= max; i++) {
            result.add(columnMap.get(i));
        }

        return result;
    }
 */
}

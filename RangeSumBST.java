import java.util.LinkedList;
import java.util.Queue;

//TC - O(N) SC- O
public class RangeSumBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null)
            return 0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int sum=0;
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr.val >= low && curr.val <= high){
                sum=sum+curr.val;
            }
            if(curr.left!=null && curr.val>low){
                q.add(curr.left);
            }
            if(curr.right!=null && curr.val<high){
                q.add(curr.right);
            }

        }

        return sum;
    }
}

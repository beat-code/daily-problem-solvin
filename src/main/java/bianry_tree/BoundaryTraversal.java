package bianry_tree;

import java.util.LinkedList;
import java.util.Queue;

public class BoundaryTraversal {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

    public void boundaryTraversal(TreeNode root){
        //combine everything
        //don't print leaves in left & right
    }

    public void leftView(TreeNode root){
        if(root==null) return;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            for(int i=0; i<n; i++){
                TreeNode node = queue.poll();
                if(i==0){
                    System.out.println(node.val);
                }
                if(node.left != null)queue.add(node.left);
                if(node.right != null)queue.add(node.right);

            }
        }
    }

    private static int max;
    public void leftViewRec(TreeNode root, int level){
        if(root==null) return;
        if(max < level){
            System.out.println(root.val);
            max+=1;
        }
        leftViewRec(root.left, level+1);
        leftViewRec(root.right, level+1);
    }

    public void rightView(TreeNode root){
        if(root==null) return;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            for(int i=0; i<n; i++){
                TreeNode node = queue.poll();
                if(i==0){
                    System.out.println(node.val);
                }
                if(node.right != null)queue.add(node.right);
                if(node.left != null)queue.add(node.left);

            }
        }
    }

    public void topView(TreeNode root){
        //use horizontal distance and treemap
    }

    public void bottomView(TreeNode root){
        //use horizontal distance and treemap
    }
}

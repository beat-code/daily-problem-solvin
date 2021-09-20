package bianry_tree;

public class FindLCA {

    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

    public TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q){
        if(root==null) return null;
        if(root==p || root==q) return root;

        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);
        if(left != null && right != null) return root;
        if(left==null) return right;
        return left;
    }
}

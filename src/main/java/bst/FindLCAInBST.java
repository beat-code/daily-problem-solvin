package bst;

public class FindLCAInBST {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

    public TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q){
        if(p.val > q.val) return findLCA(root, q, p);

        if(root==null) return null;
        if(root.val==p.val || root.val==q.val) return root;
        if(root.val > p.val && root.val < q.val) return root;
        if(root.val > p.val) return findLCA(root.left, p,q);
        return findLCA(root.right,p,q);
    }
}

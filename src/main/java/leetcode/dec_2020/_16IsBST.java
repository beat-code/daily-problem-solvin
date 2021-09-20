package leetcode.dec_2020;

public class _16IsBST {

    private static class TreeNode{
        int val;
        TreeNode right;
        TreeNode left;
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if(root==null) return true;

        if(min != null && root.val <= min) return false;
        if(max != null && root.val >= max) return false;

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}

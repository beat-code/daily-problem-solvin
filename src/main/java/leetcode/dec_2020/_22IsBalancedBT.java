package leetcode.dec_2020;

public class _22IsBalancedBT {
    private static class TreeNode{
        int val;
        TreeNode right;
        TreeNode left;
    }
    private static class Res{
        int res;
    }
    public boolean isBalanced(TreeNode root) {
        Res res = new Res();
        height(root, res);
        return res.res <= 1;
    }

    public int height(TreeNode root, Res max) {
        if(root==null) return 0;
        int rh = height(root.right, max);
        int lh = height(root.left, max);
        if(Math.abs(lh-rh) > max.res) max.res = Math.abs(lh-rh);
        return Integer.max(lh, rh) + 1;
    }
}

package bst;

public class CheckIfBST {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    public boolean checkIfBST(TreeNode root){
        return checkIfBST(root, null, null);
    }

    private boolean checkIfBST(TreeNode root, Integer min, Integer max){
        if(root==null) return true;
        if(min != null && root.val <= min) return false;
        if(max != null && root.val >= max) return false;
        return checkIfBST(root.left, min, root.val) && checkIfBST(root.right, root.val, max);
    }
}

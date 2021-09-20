package bst;

public class FindInorderPredecessorSuccessor {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    /*
     * Let us create following BST
     *          50
     *         /  \
     *        30   70
     *       /  \ /  \
     *      20 40 60  80
     */
    public TreeNode findPredecessor(TreeNode root, int key){
        if(root==null) return null;

        if(root.val > key){
            return findPredecessor(root.left, key);
        } else if (root.val < key) {
            return findPredecessor(root.right, key);
        }
        if(root.left==null) return null;
        root=root.left;
        while(root.right != null) root=root.right;
        return root;
    }

    public TreeNode findSuccessor(TreeNode root, int key, TreeNode parent){
        if(root==null) return null;

        if(root.val > key){
            return findSuccessor(root.left, key, root);
        } else if (root.val < key) {
            return findSuccessor(root.right, key, parent);
        }
        if(root.right==null) return parent;
        root=root.right;
        while (root.left != null) root=root.left;
        return root;
    }
}

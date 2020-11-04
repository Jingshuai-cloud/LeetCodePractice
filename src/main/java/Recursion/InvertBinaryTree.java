package Recursion;

import BinaryTree.PreorderTraversal;

public class InvertBinaryTree {
    public static void main(String[] args) {
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        invertBinaryTree.createBinaryTree();
        TreeNode result = invertBinaryTree.recrusion(invertBinaryTree.root);
        System.out.println(result);
    }

    private TreeNode recrusion(TreeNode root) {
        //terminator
        if (root == null) return root;

        //process current logic
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //drill down
        recrusion(root.left);
        recrusion(root.right);

        return root;
    }

    private TreeNode root;

    public class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int val;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public  void createBinaryTree() {
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = five;
    }
}

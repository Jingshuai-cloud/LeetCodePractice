package BinaryTree;

import java.util.LinkedList;
import java.util.List;

public class InorderTraversal {
    public static void main(String[] args) {
        InorderTraversal It = new InorderTraversal();
        It.createBinaryTree();
        It.inOrder(It.root);
        System.out.println(It.inOrderTraversal(It.root));
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

    public void createBinaryTree() {
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

    //Using recursion
    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    //Use Stack and interation
    public List<Integer> inOrderTraversal (TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        LinkedList<Integer> output = new LinkedList<Integer>();

        while(root != null || !stack.isEmpty()) {
            while(root != null){
                stack.add(root);
                root = root.left;
            }
            root = stack.pollLast();
            output.add(root.val);
            root = root.right;
        }

        return output;
    }

}

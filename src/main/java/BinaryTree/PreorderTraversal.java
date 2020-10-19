package BinaryTree;

import java.util.LinkedList;
import java.util.List;

public class PreorderTraversal {
    public static void main(String[] args) {
        PreorderTraversal pt = new PreorderTraversal();
        pt.createBinaryTree();
        pt.preOrder(pt.root);
        System.out.println(pt.preOrderTraversal(pt.root));
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

    //Using recursion
    public void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //Use Stack and interation
    public List<Integer> preOrderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        LinkedList<Integer> output = new LinkedList<Integer>();

        if (root == null) return output;
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if (node.right != null) stack.add(node.right);
            if (node.left != null) stack.add(node.left);
        }

        return output;
    }
}

package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {
    public static void main(String[] args) {
        MaxDepth maxDepth = new MaxDepth();
        maxDepth.createBinaryTree();
        int result = maxDepth.recursion(maxDepth.root);
        System.out.println(result);
        System.out.print( maxDepth.getMaxDepth(maxDepth.root));
    }

    //recursion Time O(n)/
    private int recursion(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = recursion(root.left);
        int rightHeight = recursion(root.right);
        return Math.max(leftHeight, rightHeight) + 1;

    }

    //Time O(n)  Space Bad O(n)
    //BFS
    private int getMaxDepth(TreeNode root) {
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int layerSize = queue.size();
            while (layerSize != 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                layerSize--;
            }
            res++;
        }
        return res;
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

}

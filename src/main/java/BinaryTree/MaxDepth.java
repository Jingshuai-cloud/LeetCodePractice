package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {
    public static void main(String[] args) {
        MaxDepth maxDepth = new MaxDepth();
        maxDepth.createBinaryTree();
        System.out.print( maxDepth.getMaxDepth(maxDepth.root));
    }

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

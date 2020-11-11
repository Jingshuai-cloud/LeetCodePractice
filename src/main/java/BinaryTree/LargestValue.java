package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValue {
    public static void main(String[] args) {
        LargestValue largestValue = new LargestValue();
        largestValue.createBinaryTree();
        TreeNode root = largestValue.root;
        List<Integer> res = largestValue.BFS(root);
        System.out.println(res);
        List<Integer> res2 = largestValue.DFS(root, 0);
        System.out.println(res2);

    }

    //Time O(N) Space O(n)
    List<Integer> result = new ArrayList<>();
    private List<Integer> DFS(TreeNode root, int level) {
        //Terminator
        if (root == null) return result;
        //current logic
        if (result.size() <= level) {
            result.add(root.val);
        }
        int largerValue = Math.max(result.get(level), root.val);
        result.set(level, largerValue);

        //drill down
        DFS(root.left, level + 1);
        DFS(root.right, level + 1);

        return result;
    }

    //Time O(n) Space O(n)
    private List<Integer> BFS(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int val = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                val = Math.max(val, node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            list.add(val);
        }
        return list;
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
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);

        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = five;
        third.right = six;
        six.right = seven;
    }
}

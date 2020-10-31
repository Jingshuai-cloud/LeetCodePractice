package BinaryTree;

import java.util.TreeMap;

public class SumRootToLeaf {
    TreeNode root;
    public static void main(String[] args) {
        SumRootToLeaf sumRootToLeaf = new SumRootToLeaf();
        TreeNode root = sumRootToLeaf.createBinaryTree();
       int result = dfs(root,0);
       System.out.println(result);
    }

    private static int dfs(TreeNode root, int prevSum) {
        if (root == null) return prevSum;
        int sum = 10 * prevSum + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }else {
           return  dfs(root.left, sum) + dfs(root.right,sum);
        }
    }
    public class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int val;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public TreeNode createBinaryTree() {
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
        return root;
    }


}

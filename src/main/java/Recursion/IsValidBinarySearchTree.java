package Recursion;

public class IsValidBinarySearchTree {
    public static void main(String[] args) {
        IsValidBinarySearchTree isValidBinarySearchTree = new IsValidBinarySearchTree();
        isValidBinarySearchTree.createBinaryTree();
        TreeNode root = isValidBinarySearchTree.root;
        boolean result = isValidBinarySearchTree.helper(root, null, null);
        System.out.println(result);
    }

    private boolean helper(TreeNode node, Integer lower, Integer upper) {
      //Terminator
        if (node == null) return true;

        //current logic
        if (lower != null && node.val <= lower) return false;
        if (upper != null && node.val >= upper) return false;

        //drill down
        if (!helper(node.left, lower, node.val)) return false;
        if (! helper(node.right, node.val, upper)) return false;

        return true;


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
        TreeNode first = new TreeNode(5);
        TreeNode second = new TreeNode(3);
        TreeNode third = new TreeNode(8);
        TreeNode fourth = new TreeNode(1);
        TreeNode five = new TreeNode(4);
        TreeNode six = new TreeNode(7);
        TreeNode seven = new TreeNode(9);

        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = five;
        third.left = six;
        third.right = seven;
    }
}

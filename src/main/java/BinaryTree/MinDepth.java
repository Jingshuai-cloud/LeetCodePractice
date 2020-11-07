package BinaryTree;

public class MinDepth {
    public static void main(String[] args) {
        MinDepth minDepth = new MinDepth();
        minDepth.createBinaryTree();
        int result = minDepth.recursion(minDepth.root);
        System.out.println(result);
    }

    private int recursion(TreeNode root) {
        //Terminator
        if (root == null) return 0;
        int left = recursion(root.left);
        int right = recursion(root.right);

        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
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

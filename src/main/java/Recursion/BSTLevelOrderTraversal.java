package Recursion;

import java.util.*;

public class BSTLevelOrderTraversal {
    public static void main(String[] args) {
        BSTLevelOrderTraversal bstLevelOrderTraversal = new BSTLevelOrderTraversal();
        bstLevelOrderTraversal.createBinaryTree();
        TreeNode root = bstLevelOrderTraversal.root;
        Collection<List<Integer>> list = new ArrayList<>();
        Collection<List<Integer>> result = bstLevelOrderTraversal.recursion(list, root,0);
        List<List<Integer>> res = bstLevelOrderTraversal.BFS(root);
        System.out.println(res);
        System.out.println(result);
    }

    //DFS  Time O(n) Space depth of recursion
    HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
    private Collection<List<Integer>> recursion(Collection<List<Integer>> list, TreeNode root, int level) {
        //terminator
        if (root == null) return list;
        //current logic
        List<Integer> subList = new ArrayList<>();
        if (hashMap.get(level) == null) {
            hashMap.put(level, subList);
        }
        hashMap.get(level).add(root.val);
        list = hashMap.values();
        //drill down
        recursion(list, root.left, level + 1);
        recursion(list, root.right, level + 1);


        return list;
    }

    //BFS  Time O(N)  Space O(N)
    public List<List<Integer>> BFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(list);
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

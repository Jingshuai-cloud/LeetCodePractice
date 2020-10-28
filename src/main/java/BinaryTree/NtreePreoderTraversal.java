package BinaryTree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NtreePreoderTraversal {
   public List<Integer> preorder(Node root) {
         ArrayList<Integer> list = new ArrayList();
            if (root == null) return list;

            list.add(root.val);
            for(Node node: root.children)
                preorder(node);

            return list;

    }

    public List<Integer> preorder2(Node root) {
        ArrayList<Integer> list = new ArrayList();
        if (root == null) return list;

        Stack<Node> stack = new Stack();
        stack.add(root);

        while (!stack.empty()) {
            root = stack.pop();
            list.add(root.val);
            for (int i = root.children.size() - 1; i >= 0; i--)
                stack.add(root.children.get(i));
        }

        return list;
    }

    public class Node {
        public ArrayList<Node> children;
        private int val;
        public Node(int val){
            this.val = val;
        }
    }
}

package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NtreePostorderTraversal {

    public List<Integer> postorder2(Node root) {
        List<Integer> list = new ArrayList();
        if (root == null) return list;

        Stack<Node> stack = new Stack();
        stack.add(root);

        while(!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            for(Node node: root.children)
                stack.add(node);
        }
        Collections.reverse(list);
        return list;
    }

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList();
        if (root == null)
            return list;

        for(Node node: root.children)
            postorder(node);

        list.add(root.val);

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

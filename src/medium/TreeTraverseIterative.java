package medium;

import util.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class TreeTraverseIterative {
    /**
     * store integer values in an ArrayList while traversing the tree in in-order
     */
    public List<Integer> inOrderTraverseIterative(TreeNode root) {

        List<Integer> result = new ArrayList<>();       // to store the traverse result
        if (root == null)
            return result;                              // when null input, return empty result

        Stack<TreeNode> stack = new Stack<>();          // to store nodes visited

        TreeNode current = root;                        // initialize current node

        while (current != null || !stack.isEmpty()) {
            /**
             * In-order traverse:  (left -> root -> right)
             *   get down left side till leaf, while pushing into stack
             *   when reach leaf,
             *     pop from stack, and use, move curr to right
             *   repeat until null curr and empty stack
             */
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            // reached left bottom, use and move to right
            current = stack.pop();
            result.add(current.value);
            current = current.right;
        }

        return result;
    }

    public List<Integer> preOrderTraverseIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();       // to store the traverse result
        if (root == null)
            return result;                              // when null input, return empty result

        Stack<TreeNode> stack = new Stack<>();          // to store nodes visited

        TreeNode current = root;                        // initialize current node

        while (current != null || !stack.empty()) {
            /**
             * Pre-order traverse: (root -> left -> right)
             */
            while (current != null) {                   // loop down left side
                result.add(current.value);              // record root value
                if (current.right != null)              // save non-null right into stack
                    stack.push(current.right);
                current = current.left;                 // traverse down the left
            }                                           // till reach the leaf

            if (!stack.empty())                         // after reaching leaf
                current = stack.pop();                  // go back up by popping stack
        }
        return result;

    }

    public static void main(String[] args) {
        /**
         * create a new tree:
         *    1
         *   / \
         *  2   3
         *     / \
         *    5   4
         */
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n3.left = n5;
        n3.right = n4;

        TreeTraverseIterative sol = new TreeTraverseIterative();

        List<Integer> result = sol.inOrderTraverseIterative(n1);

        System.out.println("\nIn-Order Traverse Recursive Solution:");
        System.out.println(result);

        result = sol.preOrderTraverseIterative(n1);

        System.out.println("\nPre-Order Traverse Recursive Solution:");
        System.out.println(result);
    }
}

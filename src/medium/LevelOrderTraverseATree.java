package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import util.TreeNode;


public class LevelOrderTraverseATree {
    /**
     * store integer value in an ArrayList while traversing the tree in level-order
     */
    public List<Integer> levelOrderTraverse(TreeNode root) {

        List<Integer> result = new ArrayList<>();       // to store the traverse result

        Queue<TreeNode> queue = new LinkedList<>();     // to store the nodes to visit (FIFO order)

        queue.add(root);                                // initialize the queue with root

        while (!queue.isEmpty()) {                      // loop till queue depletes

            TreeNode temp = queue.poll();               // poll() dequeues head; visit current Node
            result.add(temp.value);                     //   and store the value

            if (temp.left != null)
                queue.add(temp.left);                   // enqueue left children for next level

            if (temp.right != null)
                queue.add(temp.right);                  // enqueue right children, and move on to next level
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

        LevelOrderTraverseATree sol = new LevelOrderTraverseATree();

        List<Integer> result = sol.levelOrderTraverse(n1);

        System.out.println("\nLevel-Order Traverse Solution:");
        System.out.println(result);
    }
}

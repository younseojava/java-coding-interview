package util;

/**
 * Elementary (Binary) Tree Node, as utility class
 * Instead of using access methods for member variables,
 * they are just defined as public. This is only for convenience of coding practice.
 * Regular object-oriented way should define the members private and use public accessor methods.
 *
 *        value
 *        /   \
 *     left   right
 */
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int value;

    /**
     * Constructor
     */
    public TreeNode(int val) {
        this.value = val;
    }
}


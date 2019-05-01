package low;

/**
 * Elementary node class defined as inner class.
 * No need for creating a separate LinkedList class, which will be cumbersome.
 * Can create a LL by chaining, i.e. n1.next = n2, as in the main function
 */
class Node {
    int val;
    Node next;
    Node(int d) {
        val = d;
        next = null;
    }
}

/**
 * Main class including reverse and print functions
 */
public class ReverseLinkedList {

    /**
     * function to reverse the LL. Note the three Nodes: prev, curr, next
     * order of node assignment in while loop is important
     *
     *   null <--- prev ->   curr ->   next ->  (moving this direction)
     *                       |
     *                       v
     *                 node: 1 -> 2 -> 3 -> 4 -> null
     */
    Node reverse(Node node) {
        Node prev = null;
        Node curr = node;           // original head
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node = prev;               // new head to return
        return node;
    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("Null");
    }

    public static void main(String[] args) {
        /**
         * instantiate nodes
         */
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        /**
         * link them into LL
         */
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ReverseLinkedList sol = new ReverseLinkedList();
        /**
         *  print before
         */
        sol.printList(n1);
        /**
         *  main operation
         */
        Node rev = sol.reverse(n1);
        /**
         *  print after
         */
        sol.printList(rev);

    }
}

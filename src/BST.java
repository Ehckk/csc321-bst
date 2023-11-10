import java.util.*;

public class BST {
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    TreeNode root;

    TreeNode insert(TreeNode node, int value) {
        if (node == null) { // Node DNE, create it
//            System.out.println("Inserted: " + value);
            return new TreeNode(value);
        }
//        System.out.print("Node: " + node.value + ", Value: " + value + ": ");
        if (node.value > value) { // Insert left
//            System.out.println("Left");
            node.left = insert(node.left, value);
        }
        if (node.value < value) { // Insert right
//            System.out.println("Right");
            node.right = insert(node.right, value);
        }
        return node; // No duplicates
    }

    boolean search(TreeNode node, int value) {
        if (node == null) { // Node is null -> does not exist in tree
            return false;
        }
        if (node.value > value) { // Node value > search key -> node is to the left
            return search(node.left, value);
        }
        if (node.value < value) { // Node value < search key -> node is to the right
            return search(node.right, value);
        }
        return true; // Node value matches value -> found in tree
    }

    // Left Root Right
    void inOrderTraversal(TreeNode node, List<String> order) {
        if (node.left != null) {
            inOrderTraversal(node.left, order);
        }
        order.add(Integer.toString(node.value));
        if (node.right != null) {
            inOrderTraversal(node.right, order);
        }
    }

    // BFS
    void preOrderTraversal(TreeNode node, List<String> order) {
        order.add(Integer.toString(node.value));
        if (node.left != null) {
            preOrderTraversal(node.left, order);
        }
        if (node.right != null) {
            preOrderTraversal(node.right, order);
        }
    }

    // DFS
    void postOrderTraversal(TreeNode node, List<String> order) {
        if (node.left != null) {
            postOrderTraversal(node.left, order);
        }
        if (node.right != null) {
            postOrderTraversal(node.right, order);
        }
        order.add(Integer.toString(node.value));
    }

    public static void main(String[] args) {
        BST bst = new BST();
        int[] nums = { 25, 20, 65, 5, 2, 14, 70, 96, 85, 10, 15, 23, 22, 27 };
        for (int num : nums) {
            bst.root = bst.insert(bst.root, num);
        }

        // Search
        System.out.println("Search (3): " + bst.search(bst.root, 3));
        System.out.println("Search (70): " + bst.search(bst.root, 70));

        // In-Order Traversal
        System.out.print("In-Order: ");
        List<String> inOrder = new ArrayList<>();
        bst.inOrderTraversal(bst.root, inOrder);
        System.out.println(String.join(",", inOrder));

        // Pre-Order Traversal
        System.out.print("Pre-Order: ");
        List<String> preOrder = new ArrayList<>();
        bst.preOrderTraversal(bst.root, preOrder);
        System.out.println(String.join(",", preOrder));

        // Post-Order Traversal
        System.out.print("Post-Order: ");
        List<String> postOrder = new ArrayList<>();
        bst.postOrderTraversal(bst.root, postOrder);
        System.out.println(String.join(",", postOrder));
    }
}
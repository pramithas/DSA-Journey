package trees;

import java.util.Scanner;

import static trees.TreePrinter.printNode;

public class BinaryTree {
    private TreeNode root;

    public BinaryTree() {
    }

    public TreeNode getRoot() {
        return root;
    }

    public void populate(Scanner scanner) {
        System.out.println("Enter the root TreeNode: ");
        int val = scanner.nextInt();
        root = new TreeNode(val);
        populate(scanner, root);
    }

    private void populate(Scanner scanner, TreeNode TreeNode) {

        System.out.println("Do you want to enter left of: " + TreeNode.val);
        boolean left = scanner.nextBoolean();

        if (left) {
            System.out.println("Enter the val of the left of: " + TreeNode.val);
            int val = scanner.nextInt();
            TreeNode.left = new TreeNode(val);
            populate(scanner, TreeNode.left);
        }

        System.out.println("Do you want to enter right of: " + TreeNode.val);
        boolean right = scanner.nextBoolean();

        if (right) {
            System.out.println("Enter the val of the right of: " + TreeNode.val);
            int val = scanner.nextInt();
            TreeNode.right = new TreeNode(val);
            populate(scanner, TreeNode.right);
        }
    }

    public void display() {
        printNode(root);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.display();
    }

}

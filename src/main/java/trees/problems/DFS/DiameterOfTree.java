package trees.problems.DFS;

import trees.BinaryTree;
import trees.TreeNode;

import java.util.Scanner;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 */
public class DiameterOfTree {

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        height(root);
        return diameter - 1;
    }

    private int height(TreeNode node) {

        if (node == null) {
            return 0;
        }

        // Find the height of left subtree.
        int left = height(node.left);
        // Find the height of right subtree.
        int right = height(node.right);

        // Find diameter for the particular node.
        int dia = left + right + 1;
        // update the global diameter.
        diameter = Math.max(dia, diameter);

        // To the parent node, return the max height between left and right.
        // Why plus 1? To include the current node.
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.populate(new Scanner(System.in));
        binaryTree.display();
        System.out.println(new DiameterOfTree().diameterOfBinaryTree(binaryTree.getRoot()));
    }
}

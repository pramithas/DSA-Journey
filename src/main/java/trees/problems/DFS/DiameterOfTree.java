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

        int left = height(node.left);
        int right = height(node.right);

        int dia = left + right + 1;
        diameter = Math.max(dia, diameter);

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.populate(new Scanner(System.in));
        binaryTree.display();
        System.out.println(new DiameterOfTree().diameterOfBinaryTree(binaryTree.getRoot()));
    }
}

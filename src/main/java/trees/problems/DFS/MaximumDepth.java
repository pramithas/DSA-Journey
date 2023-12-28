package trees.problems.DFS;

import trees.BinaryTree;
import trees.TreeNode;

import java.util.Scanner;

public class MaximumDepth {

    public int maxDepth(TreeNode root) {
        return depth(root);
    }

    private int depth(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int left = depth(node.left);
        int right = depth(node.right);

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.populate(new Scanner(System.in));
        binaryTree.display();
        System.out.println(new MaximumDepth().maxDepth(binaryTree.getRoot()));
    }
}

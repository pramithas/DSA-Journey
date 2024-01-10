package trees.problems.DFS;

import trees.BinaryTree;
import trees.TreeNode;

import java.nio.file.Path;
import java.util.Scanner;

/**
 * Revised on Jan 10, 2024.
 * 1. Visit every node in left/right order.
 * 2. Once you visit a node, add the value of that node to the existing sum and check if
 *    it is equal to the target sum.
 * 3. Check if the target sum was found in the left or right branches.
 * 4. Return left or right.
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        return hasPthSum(root, targetSum, 0);
    }

    private boolean hasPthSum(TreeNode root, int targetSum, int currentSum) {

        // This condition meeting means that we encountered a null node
        // without first encountering the leaf node. So, the null node is not leaf node.
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return (currentSum + root.val) == targetSum;
        }


        boolean foundInLeft = hasPthSum(root.left, targetSum, currentSum + root.val);
        boolean foundInRight = hasPthSum(root.right, targetSum, currentSum + root.val);

        return foundInLeft || foundInRight;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.populate(new Scanner(System.in));
        binaryTree.display();

        PathSum pathSum = new PathSum();
        pathSum.hasPathSum(binaryTree.getRoot(), 1);
    }
}

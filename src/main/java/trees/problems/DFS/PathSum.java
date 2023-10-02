package trees.problems.DFS;

import trees.BinaryTree;
import trees.TreeNode;

import java.nio.file.Path;
import java.util.Scanner;

public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        return hasPthSum(root, targetSum, 0);
    }

    private boolean hasPthSum(TreeNode root, int targetSum, int currentSum) {

        // This condition meeting means that we encountered a null node without first encountering the leaf node. So, the null node is not lead node.
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return (currentSum + root.val) == targetSum;
        }


        boolean foundInLeft = hasPthSum(root.left, targetSum, currentSum + root.val);
        Boolean foundInRight = hasPthSum(root.right, targetSum, currentSum + root.val);

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

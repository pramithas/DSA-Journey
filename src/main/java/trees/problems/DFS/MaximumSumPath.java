package trees.problems.DFS;

import trees.BinaryTree;
import trees.TreeNode;

import java.util.Scanner;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 */
public class MaximumSumPath {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        max(root);
        return maxSum;
    }

    private int max(TreeNode root) {

        if (root == null) {
            return 0;
        }


        int left = max(root.left);
        int right = max(root.right);

        // Why not check if the node is negative?? Because we are trying to find the
        // maximum sum passing through that node.
        left = Math.max(left, 0);
        right = Math.max(right, 0);

        int sum = left + right + root.val;

        maxSum = Math.max(sum, maxSum);
        // doing max(left, right) because you need to find the maximum sum for a path.
        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.populate(new Scanner(System.in));
        binaryTree.display();
        System.out.println(new MaximumSumPath().maxPathSum(binaryTree.getRoot()));
    }
}

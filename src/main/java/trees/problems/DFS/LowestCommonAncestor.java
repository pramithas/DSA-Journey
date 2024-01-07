package trees.problems.DFS;

import trees.BinaryTree;
import trees.TreeNode;

import java.util.Scanner;

/**
 * Revised on December, 29.
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * 3 true 5 true 6 false false true 2 true 7 false false true 4 false false true 1 true 0 false false true 8 false false
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.populate(new Scanner(System.in));
        binaryTree.display();
        TreeNode result = new LowestCommonAncestor().lowestCommonAncestor(binaryTree.getRoot(), new TreeNode(2), new TreeNode(8));
        System.out.println("The result is: " + result.val);
    }

    /*
      We have to find the answer as soon as possible closer to the root.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        // Don't we need to check whether the other node exists or not? Because, we are assuming
        // that the other node definitely exists.
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        // So, the left will be either null or the matching node.
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // The right will be either null or matching node.
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // You have found the lowest common ancestor. So, just return the parent.
        if (left != null && right != null) {
            return root;

            // The node we were trying to find ancestor of was not found on the left. So, return the right.
            // btw, the right might be null as well.
        } else if (left == null) {
            return right;
        } else {
            return left;
        }
    }
}

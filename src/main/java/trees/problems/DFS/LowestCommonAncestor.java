package trees.problems.DFS;

import trees.TreeNode;

/**
 * Revised on December, 29.
 */
public class LowestCommonAncestor {

    /*
      We have to find the answer as soon as possible closer to the root.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        // Don't we need to check whether the other node exists or not?
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        // So, the left will be either null or the matching node.
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // The right will be either null or matching node.
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (left == null) {
            return right;
        } else {
            return left;
        }
    }
}

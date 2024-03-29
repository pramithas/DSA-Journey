package trees.problems.BFS;

import trees.TreeNode;

/**
 * Revised on Dec, 26.
 */
public class CousinsInBinaryTree {

    public boolean isCousins(TreeNode root, int x, int y) {

        if (root == null) {
            return false;
        }

        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);

        return getLevel(root, xx, 0) == getLevel(root, yy, 0) && !areSiblings(root, xx, yy);
    }

    /*
     The nodes will be sibling if there exists a node for which they are left and right node. And, we recursively check this for all the nodes.
     */
    private boolean areSiblings(TreeNode node, TreeNode xx, TreeNode yy) {

        if (node == null) {
            return false;
        }

        return ((node.left == xx && node.right == yy) || (node.right == xx && node.left == yy) || areSiblings(node.left, xx, yy) || areSiblings(node.right, xx, yy));
    }

    /*
     We are basically searching the whole tree for a particular node to find its level. We are starting
     at the root level and recursively searching it on the left and right children.
     */
    private int getLevel(TreeNode root, TreeNode xx, int lev) {

        if (root == null) {
            return 0;
        }

        if (root == xx) {
            return lev;
        }

        int l = getLevel(root.left, xx, lev + 1);

        if (l != 0) {
            return l;
        }
        return getLevel(root.right, xx, lev + 1);
    }

    private TreeNode findNode(TreeNode node, int x) {

        if (node == null) {
            return null;
        }

        if (node.val == x) {
            return node;
        }

        TreeNode n = findNode(node.left, x);

        if (n != null) {
            return n;
        }

        return findNode(node.right, x);
    }
}

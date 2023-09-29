package trees.problems.DFS;

import trees.TreeNode;

public class MaximumDepth {

    int depth = 0;

    public int maxDepth(TreeNode root) {
        depth(root);
        return depth;
    }

    private int depth(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int left = depth(node.left);
        int right = depth(node.right);

        return Math.max(left, right) + 1;
    }
}

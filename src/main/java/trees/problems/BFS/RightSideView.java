package trees.problems.BFS;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Beats 66% submissions in leetcode. Need to optimize more.
 * https://leetcode.com/problems/binary-tree-right-side-view/
 */
public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNode currentNode = null;
            for (int i = 0; i < levelSize; i++) {
                currentNode = queue.poll();
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            // currentNode will always contain the last element.
            result.add(currentNode.val);
        }
        return result;
    }
}

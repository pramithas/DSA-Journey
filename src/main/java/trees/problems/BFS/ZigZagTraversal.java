package trees.problems.BFS;

import trees.BST;
import trees.TreeNode;

import java.util.*;

public class ZigZagTraversal {
    public List<List<Integer>> zigZagTraversal(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reversed = false;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {

                TreeNode currentNode;

                if (reversed) {
                    currentNode = queue.pollLast();
                    currentLevel.add(currentNode.val);

                    if (currentNode.right != null) {
                        queue.offerFirst(currentNode.right);
                    }

                    if (currentNode.left != null) {
                        queue.offerFirst(currentNode.left);
                    }

                } else {
                    currentNode = queue.poll();
                    currentLevel.add(currentNode.val);

                    if (currentNode.left != null) {
                        queue.offerLast(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue.offerLast(currentNode.right);
                    }
                }
            }
            reversed = !reversed;
            result.add(currentLevel);
        }
        return result;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        bst.populatedSorted(arr);
        bst.display();
        ZigZagTraversal zigZagTraversal = new ZigZagTraversal();
        zigZagTraversal.zigZagTraversal(bst.getRoot());
    }
}

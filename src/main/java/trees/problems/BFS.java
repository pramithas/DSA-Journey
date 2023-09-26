package trees.problems;

import trees.BST;
import trees.TreeNode;

import java.util.*;

public class BFS {

    public List<List<Integer>> bsf(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        bst.populatedSorted(arr);
        bst.display();
        BFS bfs = new BFS();
        bfs.bsf(bst.getRoot());
    }

}

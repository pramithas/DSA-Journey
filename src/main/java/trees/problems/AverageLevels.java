package trees.problems;

import trees.BST;
import trees.BinaryTree;
import trees.TreeNode;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class AverageLevels {
    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            long sum = 0;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                sum += currentNode.val;
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add((double) sum / levelSize);
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.populate(new Scanner(System.in));
        binaryTree.display();
        AverageLevels averageLevels = new AverageLevels();
        List<Double> avgLevels = averageLevels.averageOfLevels(binaryTree.getRoot());
        avgLevels.forEach(al -> System.out.println(al));
    }
}
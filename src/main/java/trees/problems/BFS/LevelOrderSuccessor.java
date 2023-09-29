package trees.problems.BFS;

import trees.BinaryTree;
import trees.TreeNode;

import java.util.*;

public class LevelOrderSuccessor {

    public TreeNode levelOrderSuccessor(TreeNode root, int key) {

        List<Double> result = new ArrayList<>();

        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode currentNode = queue.poll();

            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }

            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
            if (currentNode.val == key) {
                break;
            }
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.populate(new Scanner(System.in));
        binaryTree.display();
        LevelOrderSuccessor levelOrderSuccessor = new LevelOrderSuccessor();
        TreeNode res = levelOrderSuccessor.levelOrderSuccessor(binaryTree.getRoot(), 3);
        System.out.println(res.val);
    }
}

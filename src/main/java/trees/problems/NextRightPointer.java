package trees.problems;

import trees.BST;
import trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class NextRightPointer {
    public TreeNode connect(TreeNode root) {

        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                if (!queue.isEmpty()) {
                    currentNode.next = queue.peek();
                } else {
                    currentNode.next = null;
                }

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
        return root;
    }

    // Efficient approach.
    public TreeNode connect1(TreeNode root) {

        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        root.next = null;
        queue.offer(root);

        TreeNode currentNode;

        while (!queue.isEmpty()) {

            currentNode = queue.poll();

            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }

            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }

            if (currentNode.left != null && currentNode.right != null) {
                currentNode.left.next = currentNode.right;
                if (currentNode.next != null) {
                    currentNode.right.next = currentNode.next.left;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        bst.populatedSorted(arr);
        bst.display();
        NextRightPointer bfs = new NextRightPointer();
        bfs.connect1(bst.getRoot());
    }
}
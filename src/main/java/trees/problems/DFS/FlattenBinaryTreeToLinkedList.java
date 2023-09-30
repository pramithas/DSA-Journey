package trees.problems.DFS;

import com.sun.source.tree.Tree;
import trees.BinaryTree;
import trees.TreeNode;

import java.time.temporal.Temporal;
import java.util.Scanner;

public class FlattenBinaryTreeToLinkedList {

    TreeNode result;

//    public void flatten(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        flattenTree(root, queue);
//        TreeNode result = queue.poll();
//        TreeNode temp = result;
//        while (!queue.isEmpty()) {
//            temp.right = queue.poll();
//            temp.left = null;
//            temp = temp.right;
//        }
//        root = result;
//    }
//
//    private void flattenTree(TreeNode node, Queue<TreeNode> queue) {
//
//        if (node == null) {
//            return;
//        }
//
//        queue.add(node);
//        flattenTree(node.left, queue);
//        flattenTree(node.right, queue);
//    }


//    public void flatten(TreeNode root) {
//        TreeNode res = flattenTree(root, null);
//        root = res;
//    }
//
//    private TreeNode flattenTree(TreeNode node, TreeNode temp) {
//
//        if (node == null) {
//            return node;
//        }
//
//        if (result == null) {
//            result = new TreeNode(node.val);
//            temp = result;
//        } else {
//            TreeNode result1 = new TreeNode(node.val);
//            result.right = result1;
//            result = result.right;
//            result.left = null;
//        }
//        flattenTree(node.left, temp);
//        flattenTree(node.right, temp);
//        return temp;
//    }

    public void flatten(TreeNode root) {
        flatten(root, root);
    }

    public void flatten(TreeNode root, TreeNode rootCache) {

        if (rootCache == null) {
            return;
        }
        TreeNode temp = rootCache;

        TreeNode left = temp.left;

        if (left != null) {
            TreeNode right = left == null ? null : left.right;

            while (left != null && right != null && right.right != null) {
                right = right.right;
            }
            if (right == null) {
                left.right = rootCache.right;
            } else {
                right.right = rootCache.right;
            }

            rootCache.right = null;
            TreeNode temp2 = rootCache.left;
            rootCache.left = null;
            rootCache.right = temp2;

            flatten(root, rootCache.right);
        } else {
            flatten(root, rootCache.right);
        }

    }

    public void flattenKunal(TreeNode root) {

        // Not modifying the root, but only changing the structure. Thus, using the proxy to the root instead of using root directly.
        TreeNode current = root;
        while (current != null) {

            if (current.left != null) {
                TreeNode temp = current.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                temp.right = current.right;
                current.right = current.left;
                current.left = null;
            }

            current = current.right;
        }


    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.populate(new Scanner(System.in));
        binaryTree.display();
        FlattenBinaryTreeToLinkedList flattenBinaryTreeToLinkedList = new FlattenBinaryTreeToLinkedList();
        flattenBinaryTreeToLinkedList.flatten(binaryTree.getRoot());
        System.out.println("");
    }

}

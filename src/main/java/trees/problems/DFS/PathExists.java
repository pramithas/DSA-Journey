package trees.problems.DFS;

import trees.BinaryTree;
import trees.TreeNode;

import java.util.Scanner;

public class PathExists {

    public boolean findPath(TreeNode root, int[] arr) {
        if (root == null) {
            return arr.length == 0;
        }

        return helper(root, arr, 0);
    }

    // Not sure if it is the correct solution.
    private boolean helper(TreeNode root, int[] arr, int index) {

        if (root == null) {
            return false;
        }

        if (index >= arr.length || root.val != arr[index]) {
            return false;
        }

        if (root.left == null && root.right == null && index == arr.length - 1) {
            return true;
        }

        if(arr[index] == root.val){
            return true;
        }

        return helper(root.left, arr, index + 1) || helper(root.right, arr, index + 1);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.populate(new Scanner(System.in));
        binaryTree.display();
        int[] arr= {3,9,19};
        System.out.println(new PathExists().findPath(binaryTree.getRoot(), arr));
    }
}
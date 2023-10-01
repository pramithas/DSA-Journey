package trees.problems.DFS;

import trees.BinaryTree;
import trees.TreeNode;

import java.util.Scanner;

public class KthSmallest {
    private static int number = 0;
    private static int count = 0;

//    public int kthSmallest(TreeNode root, int k) {
//        find(root, q);
//        int count = 1;
//        int elem = 0;
//        while(!q.isEmpty()){
//            elem = q.poll();
//            if(count == k){
//                break;
//            }
//            count++;
//        }
//        return elem;
//    }
//
//    private void find(TreeNode root, Queue<Integer> q) {
//
//        if (root == null) {
//            return;
//        }
//
//        find(root.left, q);
//        q.offer(root.val);
//        find(root.right, q);
//    }

//    public int kthSmallest(TreeNode root, int k) {
//        return helper(root, k).val;
//    }
//
//    private TreeNode helper(TreeNode root, int k) {
//
//        if (root == null) {
//            return null;
//        }
//
//        TreeNode left = helper(root.left, k);
//
//        if (left != null) {
//            return left;
//        }
//
//        count++;
//
//        if (count == k) {
//            return root;
//        }
//
//        return helper(root.right, k);
//    }

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return number;
    }

    private void helper(TreeNode n) {

        if (n.left != null) {
            helper(n.left);
        }

        count--;

        if (count == 0) {
            number = n.val;
            return;
        }
        if (n.right != null) {
            helper(n.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.populate(new Scanner(System.in));
        binaryTree.display();
        KthSmallest kthSmallest = new KthSmallest();
        int res = kthSmallest.kthSmallest(binaryTree.getRoot(), 3);
        System.out.println(res);
    }

}

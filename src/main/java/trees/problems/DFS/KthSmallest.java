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

    public int kthSmallestKunal(TreeNode root, int k) {
        return helper(root, k).val;
    }

    private TreeNode helper(TreeNode root, int k) {

        if (root == null) {
            return null;
        }

        // It does not return the left node of root.
        // Until the desired value is got hold of, it will keep on returning null.
        TreeNode left = helper(root.left, k);

        if (left != null) {
            return left;
        }

        count++;

        if (count == k) {
            return root;
        }

        // This will keep on returning null until the value is found.
        TreeNode right =  helper(root.right, k);
        return right;
    }

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return number;
    }

    /**
     * Basically, you are traversing the nodes in right node, current node, and left node format. And, we decrease count in each node and checked whether
     * the count is zero in each node.
     *
     * @param tree
     */
    private void helper(TreeNode tree) {

        if (tree == null) {
            return;
        }

        helper(tree.left);


        count--;

        if (count == 0) {
            number = tree.val;
            return;
        }


        helper(tree.right);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.populate(new Scanner(System.in));
        binaryTree.display();
        KthSmallest kthSmallest = new KthSmallest();
        int res = kthSmallest.kthSmallestKunal(binaryTree.getRoot(), 5);
        System.out.println(res);
    }

}

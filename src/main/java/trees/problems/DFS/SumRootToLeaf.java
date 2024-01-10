package trees.problems.DFS;

import trees.BinaryTree;
import trees.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Revised on Jan 10.
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
public class SumRootToLeaf {

    List<Integer> result = new ArrayList<>();

    public int sumNumbers(TreeNode root) {

        if (root == null) {
            return 0;
        }

        String currSum = "";
        hasPthSum(root, currSum);

        int sum = 0;
        for (Integer elem : result) {
            sum += elem;
        }

        return sum;
    }

    private void hasPthSum(TreeNode root, String currentSum) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            currentSum+=root.val;
            result.add(Integer.valueOf(currentSum));
        }

        hasPthSum(root.left, currentSum + root.val + "");
        hasPthSum(root.right, currentSum + root.val + "");
    }

    public static void main(String[] args) {
        //4 true 9 true 5 false false true 1 false false true 0 false false
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.populate(new Scanner(System.in));
        binaryTree.display();

        SumRootToLeaf pathSum = new SumRootToLeaf();
        pathSum.sumNumbers(binaryTree.getRoot());
    }
}

package trees.problems.DFS;

import trees.BinaryTree;
import trees.TreeNode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 */
public class ConstructBTFromIoTAndPoT {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);

        int mid = 0;
        for (; inorder[mid] != root.val && mid < inorder.length; mid++) {
        }


        root.left = buildTree(Arrays.copyOfRange(preorder, 1, mid + 1), Arrays.copyOfRange(inorder, 0, mid));
        root.right = buildTree(Arrays.copyOfRange(preorder, mid + 1, preorder.length), Arrays.copyOfRange(inorder, mid + 1, inorder.length));

        return root;
    }

    public static void main(String[] args) {
        ConstructBTFromIoTAndPoT constructBTFromIoTAndPoT = new ConstructBTFromIoTAndPoT();
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};
        constructBTFromIoTAndPoT.buildTree(preOrder, inOrder);
    }
}

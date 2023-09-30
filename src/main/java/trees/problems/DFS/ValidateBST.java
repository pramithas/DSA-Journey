package trees.problems.DFS;

import trees.BinaryTree;
import trees.TreeNode;

import java.util.Scanner;

public class ValidateBST {

    boolean leftCondition = true;
    boolean rightCondition = true;

    public boolean isValidBST(TreeNode root) {
        return helper(root, null,null);
    }

    private boolean helper(TreeNode root, Integer start, Integer end) {

        if(root == null){
            return true;
        }

        if(start != null && start >= root.val){
            return false;
        }

        if(end != null && end <= root.val){
            return false;
        }

        boolean left = helper(root.left, start, root.val);
        boolean right = helper(root.right, root.val, end);

        return left && right;
    }


//    public boolean isValidBST(TreeNode root) {
//        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
//    }
//
//    private boolean validate(TreeNode root, long start, long end){
//
//        if(root == null){
//            return true;
//        }
//
//        if(root.left == null && root.right == null){
//            return true;
//        }
//
//        if(root.left != null){
//            leftCondition = leftCondition && root.left.val < root.val && start < root.left.val && root.left.val < end;
//            validate(root.left, start, root.val);
//        }
//
//        if(root.right != null){
//            rightCondition = rightCondition && root.right.val > root.val && start < root.right.val && root.right.val < end;
//            validate(root.right, root.val, end);
//        }
//
//        return leftCondition && rightCondition;
//    }
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.populate(new Scanner(System.in));
        binaryTree.display();
        ValidateBST validateBST = new ValidateBST();
        System.out.println(validateBST.isValidBST(binaryTree.getRoot()));
    }
}

package trees.problems.algoexpert;

/**
 * Check if the tree is the valid BST.
 * <p>
 * Just making the check in each node that the left is smaller than current node and right is greater than the current node is not enough.
 * For example, a node in the right should be greater than the parent node but should be smaller than the node in whose subtree it lies. So,
 * for each node we should calculate the allowed range of values.
 */
public class ValidBST {

    public static boolean validateBst(BST tree) {
       return validate(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean validate(BST tree, Integer start, Integer end) {

        if(tree == null){
            return true;
        }

        if(tree.value > start){
            return true;
        }

        if(tree.value < end){
            return true;
        }

        boolean leftValid = validate(tree.left, Integer.MIN_VALUE, tree.value);
        boolean rightValid = validate(tree.right, tree.value, Integer.MAX_VALUE);

        return leftValid && rightValid;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}

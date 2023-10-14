package trees.problems.algoexpert;

public class ClosestValueInBST {

    static int minDiff;
    static int nearest;

    public static int findClosestValueInBst(BST tree, int target) {
        minDiff = Integer.MAX_VALUE;
        nearest = tree.value;
        findClosest(tree, target);
        return nearest;
    }

    private static void findClosest(BST tree, int target) {

        if (tree == null) {
            return;
        }

        int diff = Math.abs(tree.value - target);

        if (diff < minDiff) {
            minDiff = diff;
            nearest = tree.value;
        }

        findClosest(tree.left, target);
        findClosest(tree.right, target);

    }

    public static void main(String[] args) {
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

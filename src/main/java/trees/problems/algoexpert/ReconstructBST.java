package trees.problems.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReconstructBST {

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    /**
     * Here,just to to the right from index 1 until you find a value which is less than the root value. And, that is the mid value.
     *
     * @param preOrderTraversalValues
     * @return
     */
    public static BST reconstructBst(List<Integer> preOrderTraversalValues) {

        if (preOrderTraversalValues.size() == 0) {
            return null;
        }

        BST root = new BST(preOrderTraversalValues.get(0));

        int mid = 1;
        for (; mid < preOrderTraversalValues.size() && preOrderTraversalValues.get(mid) < root.value; mid++) {
        }


        root.left = reconstructBst(preOrderTraversalValues.subList(1, mid));
        root.right = reconstructBst(preOrderTraversalValues.subList(mid, preOrderTraversalValues.size()));

        return root;
    }

    public static void main(String[] args) {
        List<Integer> preOrderTraversalValues = new ArrayList<>(Arrays.asList(10, 4, 2, 1, 5, 17, 19, 18));
        BST result = reconstructBst((ArrayList<Integer>) preOrderTraversalValues);
        System.out.println();
    }
}

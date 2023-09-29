package trees.problems.BFS;

import trees.BinaryTree;
import trees.TreeNode;

import java.util.*;

public class SymetricBinaryTree {

    public boolean isSymmetric(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentLevel);
        }


        for (List<Integer> list : result) {
            for (int i = 0; i < list.size() / 2; i++) {
                if (list.get(i) != list.get(list.size() - 1 - i) ) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSymmetricEfficient(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()){

            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if(left == null && right == null){
                continue;
            }

            if(left == null || right == null){
                return false;
            }

            if(left.val != right.val){
                return false;
            }

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

    public boolean isSymmetricRec(TreeNode root){
        if(root == null){
            return true;
        }

        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if(left == null && right == null){
            return true;
        }

        if(left == null || right == null){
            return false;
        }

        return left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.populate(new Scanner(System.in));
        binaryTree.display();

        SymetricBinaryTree symetricBinaryTree = new SymetricBinaryTree();
        symetricBinaryTree.isSymmetric(binaryTree.getRoot());
    }
}

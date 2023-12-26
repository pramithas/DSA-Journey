package trees;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    // Need this in specific problems.
    public TreeNode next;


    public int height;

    public TreeNode(int value) {
        this.val = value;
    }

    public int getValue() {
        return this.val;
    }

}
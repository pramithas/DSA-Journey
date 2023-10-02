package trees.problems.DFS;

import trees.BinaryTree;
import trees.TreeNode;

import java.net.Inet4Address;
import java.util.*;

public class SerializeDeserializeBT {

    private String data;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        String s = serialize(root, "");
        s = s.replaceAll("[,]+",",");
        if(s.startsWith(",")){
            s = s.substring(1);
        }
        if(s.endsWith(",")){
            s = s.substring(0, s.length() - 1);
        }
        return s;
    }

    public String serialize(TreeNode root, String result) {

        if (root == null) {
            return "null";
        }

        String rootVal = root.val + "";
        String left = serialize(root.left, result);
        String right = serialize(root.right, result);
        result += "," + rootVal + "," + left + "," + right + ",";
        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data == null || data.isEmpty()) {
            return null;
        }
        String[] strArray = data.split(",");
        List<String> list = new ArrayList<String>(Arrays.asList(strArray));
        Collections.reverse(list);
        return helper(list);
    }

    private TreeNode helper(List<String> list) {

        if (list == null || list.size() == 0) {
            return null;
        }
        String val = list.remove(list.size() - 1);

        if (val.charAt(0) == 'n') {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));

        node.left = helper(list);
        node.right = helper(list);

        return node;
    }


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.populate(new Scanner(System.in));
        binaryTree.display();
        SerializeDeserializeBT ser = new SerializeDeserializeBT();
        SerializeDeserializeBT deser = new SerializeDeserializeBT();
        String serialized = ser.serialize(binaryTree.getRoot());
        //String serialized = "1,2,null,null,3,4,null,null,5,null,null";
        //  String serialized = "1,2,null,null,3,4,null,null,5,null,null";
        TreeNode ans = deser.deserialize(serialized);
        System.out.println("");
    }
}

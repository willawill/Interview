 // Definition for binary tree
 import java.util.*;
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class PostOrderTraversal {
    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if (root == null) return result;
        Stack<TreeNode> tree = new Stack<TreeNode>();
        Stack<TreeNode> output = new Stack<TreeNode>();
        tree.push(root);
        TreeNode current = null;
        while (!tree.empty()){
            current = tree.pop();
            output.push(current);
            if (current.left != null) tree.push(current.left);
            if (current.right != null) tree.push(current.right);
        }
        while (!output.empty()) {
            result.add(output.pop().val);
        }
        return result;
    }

public static void main(String[] args) {
    PostOrderTraversal solution = new PostOrderTraversal();
    TreeNode bst = new TreeNode(1);
    TreeNode left = new TreeNode(2);
    TreeNode right = new TreeNode(3);
    bst.right = left;
    left.left = right;
    System.out.println(solution.postorderTraversal(bst));

    }
}
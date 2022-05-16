package _99_代码随想录._07_二叉树._01_二叉树的属性;

import _99_代码随想录._07_二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName _257_二叉树的所有路径
 * @Description
 * @Author StarLee
 * @Date 2022/5/4
 */
public class _257_二叉树的所有路径 {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> result = new ArrayList<>();
        if (root != null){
            binaryTreePaths(result, "",root);
        }
        return result;
    }

    private void binaryTreePaths(List<String> result, String prefix, TreeNode root){
        StringBuilder sb = new StringBuilder(prefix);
        sb.append(root.val);
        if (root.left == null && root.right == null){
            result.add(sb.toString());
        }
        String newPrefix = sb.append("->").toString();
        if (root.left != null){
            binaryTreePaths(result,newPrefix,root.left);
        }
        if (root.right != null){
            binaryTreePaths(result,newPrefix,root.right);
        }
    }
}

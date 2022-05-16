package _99_代码随想录._07_二叉树._00_二叉树的遍历方式;

import 算法面试._05_树操作.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName _107_二叉树的层序遍历II
 * @Description
 * @Author StarLee
 * @Date 2022/4/23
 */

public class _107_二叉树的层序遍历II {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        int levelSize = 1;
        List<Integer> levelNodes = new ArrayList<>();
        while (!nodes.isEmpty()){
            TreeNode cur = nodes.poll();
            levelNodes.add(cur.val);
            levelSize--;
            if (cur.left != null) nodes.add(cur.left);
            if (cur.right != null) nodes.add(cur.right);
            if (levelSize == 0){
                levelSize = nodes.size();
                result.add(levelNodes);
                levelNodes = new ArrayList<>();
            }
        }
        int left = 0, right = result.size() - 1;
        while (left < right){
            List<Integer> tmp = result.get(left);
            result.set(left,result.get(right));
            result.set(right,tmp);
            left++;
            right--;
        }
        return result;
    }
}

package _99_代码随想录._07_二叉树._00_二叉树的遍历方式;

import 算法面试._05_树操作.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName _199_二叉树的右视图
 * @Description
 * @Author StarLee
 * @Date 2022/4/23
 */

public class _199_二叉树的右视图 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        int levelSize = 1;
        while (!nodes.isEmpty()){
            TreeNode cur = nodes.poll();
            levelSize--;
            if (cur.left != null) nodes.add(cur.left);
            if (cur.right != null) nodes.add(cur.right);
            if (levelSize == 0){  //这一层遍历完,此时的cur就是最后一个节点
                levelSize = nodes.size();
                result.add(cur.val);
            }
        }
        return result;
    }
}

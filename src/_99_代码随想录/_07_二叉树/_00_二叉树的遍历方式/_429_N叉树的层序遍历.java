package _99_代码随想录._07_二叉树._00_二叉树的遍历方式;


import _99_代码随想录._07_二叉树.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName _429_N叉树的层序遍历
 * @Description
 * @Author StarLee
 * @Date 2022/4/23
 */

public class _429_N叉树的层序遍历 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        int levelSize = 1;
        List<Integer> levelNodes = new ArrayList<>();
        while (!nodes.isEmpty()){
            Node cur = nodes.poll();
            levelNodes.add(cur.val);
            levelSize--;
            for (Node child : cur.children) {
                if (child == null) continue;
                nodes.add(child);
            }
            if (levelSize == 0){
                levelSize = nodes.size();
                result.add(levelNodes);
                levelNodes = new ArrayList<>();
            }
        }
        return result;
    }
}

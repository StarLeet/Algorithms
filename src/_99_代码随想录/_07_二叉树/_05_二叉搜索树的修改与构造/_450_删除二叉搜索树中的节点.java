package _99_代码随想录._07_二叉树._05_二叉搜索树的修改与构造;

import _99_代码随想录._07_二叉树.TreeNode;

import java.util.PrimitiveIterator;

/**
 * @ClassName _450_删除二叉搜索树中的节点
 * @Description
 * @Author StarLee
 * @Date 2022/5/7
 */
public class _450_删除二叉搜索树中的节点 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            TreeNode left = root.left;
            TreeNode right = root.right;
            //寻找右侧最小的叶子节点
            while (right != null && right.left != null) {
                right = right.left;
            }
            //如果存在右侧最小的叶子节点，将root的左子树拼接到右侧最小叶子节点的左子树
            if (right != null) {
                right.left = left;
                return root.right;
            } else {//如果不存在右侧最小的叶子节点，root的右子树为空，直接返回左子树
                return left;
            }
        }
        return root;
    }

    public TreeNode deleteNode1(TreeNode root, int key) {
        if (root == null) return null;
        TreeNode curNode = root;
        TreeNode parent = null;
        while (curNode != null){
            if (curNode.val > key){
                parent = curNode;
                curNode = curNode.left;
            }else if (curNode.val < key){
                parent = curNode;
                curNode = curNode.right;
            }else {  // 找到了
                /*  情况一：有后继节点,删除某节点变成删除某节点的后继节点【此时parent一定不为null】
                *   情况二：度为1且parent为null,说明删除的是根节点,直接返回左右子树即可
                *   情况三：度为1且parent不为null,可以是情况一变化得来
                * */
                if (curNode.right != null){  // 存在后继节点
                    parent = curNode;
                    TreeNode successor = curNode.right;
                    while (successor.left != null){
                        parent = successor;
                        successor = successor.left;
                    }
                    // 找到后继了,将后继的值覆盖当前值
                    curNode.val = successor.val;
                    curNode = successor;  // 删除某节点变成删除它的后继节点
                }
                // 度一定为1
                if (parent == null) return curNode.left;
                if (parent.left == curNode){
                    parent.left = curNode.left == null ? curNode.right : curNode.left;
                }else {
                    parent.right = curNode.left == null ? curNode.right : curNode.left;
                }
                break;
            }
        }
        return root;
    }
}

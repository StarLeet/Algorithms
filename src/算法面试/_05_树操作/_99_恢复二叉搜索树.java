package 算法面试._05_树操作;
// https://leetcode-cn.com/problems/recover-binary-search-tree/

/**
 * @ClassName _99_恢复二叉搜索树
 * @Description
 * @Author StarLee
 * @Date 2022/1/16
 */

public class _99_恢复二叉搜索树 {
    /**
     * 给你二叉搜索树的根节点root ，该树中的两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树
     */
    private TreeNode prev;  // 存放前驱节点,以判断逆序对
    private TreeNode[] errNodes = new TreeNode[2];  // 存放错位的两个节点
    // 递归中序遍历
    public void recoverTree(TreeNode root) {
        // 存放错误的两个节点
        // 找出错误的节点
        findWrongNodes(root);
        int tmp = errNodes[0].val;
        errNodes[0].val = errNodes[1].val;
        errNodes[1].val = tmp;
    }

    private void findWrongNodes(TreeNode root){
        if (root == null) return;
        findWrongNodes(root.left);
        reversePair(root); // 寻找逆序对
        findWrongNodes(root.right);
    }

    private void reversePair(TreeNode node){
        if (prev != null && prev.val > node.val){
            // 第2个错误节点：最后一个逆序对中较小的那个节点
            errNodes[1] = node;
            // 第1个错误节点：第一个逆序对中较大的那个节点
            if (errNodes[0] != null) return;
            errNodes[0] = prev;
        }
        prev = node;
    }

    /**
     * 二叉树的Morris遍历,建立线索二叉树
     * 相比于递归遍历时间复杂度为O(2n),空间复杂度为O(1)
     */
    public void recoverTree1(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            if (node.left != null) {
                // 找到前驱节点(predecessor)
                TreeNode pred = node.left;
                while (pred.right != null && pred.right != node) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    // 将前驱节点的right指向自己,构建线索二叉树
                    pred.right = node;
                    node = node.left;
                } else { // pred.right == node,之前已经建立过线索二叉树
                    reversePair(node);
                    // 消除线索二叉树,保持树的结构
                    pred.right = null;
                    node = node.right;
                }
            } else {
                reversePair(node);
                node = node.right;
            }
        }

        // 交换2个错误节点的值
        int tmp = errNodes[0].val;
        errNodes[0].val = errNodes[1].val;
        errNodes[1].val = tmp;
    }
}

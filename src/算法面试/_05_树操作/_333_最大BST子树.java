package 算法面试._05_树操作;
// https://leetcode-cn.com/problems/largest-bst-subtree/

/**
 * @ClassName _333_最大BST子树
 * @Description
 * @Author StarLee
 * @Date 2022/1/17
 */

public class _333_最大BST子树 {
    /**
     * 保存BST的信息
     */
    private static class Info{
        private TreeNode root;
        private int size;
        private int min;
        private int max;

        public Info(TreeNode root, int size, int min, int max) {
            this.root = root;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    /**
     *   求一棵树的最大BST子树,判断依据为子树的节点
     */
    public int largestBSTSubtree(TreeNode root) {
        return (root == null) ? 0 : getInfo(root).size;
    }

    /**
     * 返回以root为根节点的最大BST子树的信息
     */
    private Info getInfo(TreeNode root){
        if (root == null) return null;
        // 后续遍历,先判断子树是否是BST,再用子树判断父节点
        Info leftInfo = getInfo(root.left);
        Info rightInfo = getInfo(root.right);
        // 处理逻辑
        /*
        有4种情况，以root为根节点的二叉树就是一棵BST，最大BST子树就是其本身
        ① li != null && ri != null
        && li.root == root.left && root.val > li.max
        && ri.root == root.right && root.val < ri.min

        ② li != null && ri == null
        && li.root == root.left && root.val > li.max

        ③ li == null && ri != null
        && ri.root == root.right && root.val < ri.min

        ④ li == null && ri == null
        */
        int leftSize = -1, rightSize = -1, max = root.val, min = root.val;
        if (leftInfo == null){
            leftSize = 0;
        }else if (leftInfo.root == root.left && leftInfo.max < root.val){
            leftSize = leftInfo.size;
            min = leftInfo.min;
        }
        if (rightInfo == null){
            rightSize = 0;
        }else if (rightInfo.root == root.right && rightInfo.min < root.val){
            rightSize = rightInfo.size;
            max = rightInfo.max;
        }

        if (leftSize >= 0 && rightSize >= 0){
            // 因为min与max缺省值为root.val所以在左右子树信息为null时,不需要特殊处理
            return new Info(root,leftSize + rightSize + 1,min,max);
        }

        // 说明BST子树虽然存在,但不是该root的直接子树
        // 返回较大的那颗BST子树
        if (leftSize == -1 && rightSize == -1)
            return (leftInfo.size > rightInfo.size) ? leftInfo : rightInfo;

        return (leftInfo != null) ? leftInfo : rightInfo;
    }
}

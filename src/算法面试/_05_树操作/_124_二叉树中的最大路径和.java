package 算法面试._05_树操作;

/**
 * @ClassName _124_二叉树中的最大路径和
 * @Description
 * @Author StarLee
 * @Date 2022/3/14
 */

public class _124_二叉树中的最大路径和 {
    public int maxPathSum(TreeNode root) {
        return getMaxPath(root)[1];
    }

    /**
     *  @MethodName getMaxPath
     *  @Description
     *  @Param [root]
     *  @return int[] [root为根单边最大路径和,root为根当前最大路径和(含子树)]
     */
    private int[] getMaxPath(TreeNode root){
        if (root == null) return new int[]{0,Integer.MIN_VALUE};  // root为null时,不存在最大路径,所以给最小值
        int[] left = getMaxPath(root.left);
        int[] right = getMaxPath(root.right);
        int doubleSize = root.val + left[0] + right[0];  // 将root包含在内,求双边值
        int oneSize = doubleSize - Math.min(left[0],right[0]); // 为了传递给上一次,求上一层的双边值
        if (oneSize < 0) oneSize = 0;  // 除负操作,表示上层不拼接此子树
        int curMaxPath = Math.max(doubleSize, Math.max(left[1],right[1])); // 更新当前最大路径和
        return new int[]{oneSize,curMaxPath};
    }
}

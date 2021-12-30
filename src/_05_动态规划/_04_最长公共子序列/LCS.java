package _05_动态规划._04_最长公共子序列;

/**
 * @ClassName LCS
 * @Description 动态规划——最长公共子序列
 * @Author StarLee
 * @Date 2021/12/30
 */

public class LCS {
    /**
     *  leetCode题目
     * */
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) return 0;
        char[] chars1 = text1.toCharArray();
        if (chars1.length == 0) return 0;
        char[] chars2 = text2.toCharArray();
        if (chars2.length == 0) return 0;
        char[] rowsChars = chars1, colsChars = chars2;
        if (chars1.length < chars2.length) {
            colsChars = chars1;
            rowsChars = chars2;
        }
        int[] dp = new int[colsChars.length + 1];
        for (int i = 1; i <= rowsChars.length; i++) {
            int cur = 0;
            for (int j = 1; j <= colsChars.length; j++) {
                int leftTop = cur;
                cur = dp[j];
                if (rowsChars[i - 1] == colsChars[j - 1]) {
                    dp[j] = leftTop + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
            }
        }
        return dp[colsChars.length];
    }
    /**
     *  数组的长度取决于列,取较短的序列长度作为列,可以进一步压榨空间
     * */
    public static int lcs(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) return 0;
        if (nums2 == null || nums2.length == 0) return 0;
        int[] rowsNums = nums1, colsNums = nums2;
        if (nums1.length < nums2.length) {
            colsNums = nums1;
            rowsNums = nums2;
        }
        int[] dp = new int[colsNums.length + 1];
        for (int i = 1; i <= rowsNums.length; i++) {
            int cur = 0;
            for (int j = 1; j <= colsNums.length; j++) {
                int leftTop = cur;
                cur = dp[j];
                if (rowsNums[i - 1] == colsNums[j - 1]) {
                    dp[j] = leftTop + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
            }
        }
        return dp[colsNums.length];
    }
    /**
     * 非递归实现(滚动数组优化)
     */
    static int lcs3(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) return 0;
        if (nums2 == null || nums2.length == 0) return 0;
        int[][] dp = new int[2][nums2.length + 1]; //只用到上一行的数据,所以只需要开辟两行的数组

        for (int i = 1; i <= nums1.length; i++) {
            int row = i & 1;  //相当于模2
            int prevRow = (i - 1) & 1;
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[row][j] = dp[prevRow][j - 1] + 1;
                } else {
                    dp[row][j] = Math.max(dp[prevRow][j], dp[row][j - 1]);
                }
            }
        }
        return dp[nums1.length & 1][nums2.length];
    }

    /**
     * 非递归实现
     */
    static int lcs2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) return 0;
        if (nums2 == null || nums2.length == 0) return 0;
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }

    /**
     * 递归实现
     */
    public static int lcs1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) return 0; // 检测nums1是否是空串
        if (nums2 == null || nums2.length == 0) return 0; // 检测nums2是否是空串
        return lcs1(nums1, nums1.length, nums2, nums2.length);
    }
    /**
     *  @MethodName lcs1
     *  @Description  求nums1前i个元素和nums2前j个元素的最长g公共子序列长度
     *  @Param [nums1, i, nums2, j]
     *  @return int
     */
    private static int lcs1(int[] nums1, int i, int[] nums2, int j) {
        if (i == 0 || j == 0) return 0;
        // 如果最后一个元素相等, 返回前面的公共子序列长度 + 1
        if (nums1[i - 1] == nums2[j - 1]) {
            return lcs1(nums1, i - 1, nums2, j - 1) + 1;
        }
        // 如果不等,则需要分别将两者的最后一个与另一个数组(除最后一个元素)进行新的计算
        return Math.max(
                lcs1(nums1, i - 1, nums2, j),
                lcs1(nums1, i, nums2, j - 1)
        );
    }
}

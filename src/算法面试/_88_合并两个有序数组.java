package 算法面试;
// https://leetcode-cn.com/problems/merge-sorted-array/
/**
 * @ClassName _88_合并两个有序数组
 * @Description
 * @Author StarLee
 * @Date 2021/12/18
 */
@SuppressWarnings("all")
public class _88_合并两个有序数组 {

    /**
     *   要求： nums1 [2,4,7,0,0,0]
     *         nums2 [1,5,8]
     *   合并成 nums1 [1,2,4,5,7,8]
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n){
        int end = m + n - 1;  //nums1最大索引
        for(int i = end;i >= 0; i--){ // 从后往前合并
            if(n == 0) break; // n==0，nums中元素合并完成，合并结束
            if(m == 0) { // nums2中有元素，但是nums1中原有的元素已经合并结束
                while (n > 0){
                    nums1[i--] = nums2[--n];
                }
                break;
            }
            // n!=0 m!=0
            if(nums1[m-1] > nums2[n-1]){
                nums1[i] = nums1[--m];
            }else{
                nums1[i] = nums2[--n];
            }
        }
    }

    public static void main(String[] args) {

    }
}

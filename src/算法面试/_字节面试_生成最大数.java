package 算法面试;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName _字节面试_生成最大数
 * @Description
 * @Author StarLee
 * @Date 2022/4/19
 */

public class _字节面试_生成最大数 {
    /**
     *  给定数字n,还有一组个位数组成的数组,求小于n的最大数
     *  比如：2500 [1,2,3,4,9]  ——> 2499
     *    2449
     *  前一个数比你小,后一个数就挑最大
     */
    private ArrayList<Integer> num = new ArrayList<>();
    private int max = 0;
    private int[] result;  // 存储选择的每一个数
    private final int[][] contain = new int[10][2];  // 存在与否  小于自己的第一个数的索引
    public int maxNum(int n, int[] arr){
        if (arr == null || arr.length == 0) return 0;
        Arrays.sort(arr);  // NlogN
        int tmp = n;
        // 计算n的长度
        while (tmp != 0){
            num.add(tmp % 10);
            tmp /= 10;
        }
        // 维护hash数组
        for (int i : arr) { //N
            contain[i][0]++;
        }
        // 维护hash数组最小链
        int small = -1;
        for (int i = 0; i < contain.length; i++) {
            contain[i][1] = small;
            if (contain[i][0] != 0){
                small = i;
            }
        }
        result = new int[num.size()];
        int head = num.get(num.size() - 1);
        // 分情况处理  1. 最高位存在,则进行dfs   2. 最高位不存在但是存在一个比它小的值(2500 不存在2但是有1)
        // 3. 剩余位填充数组里的最大值即可
        if (contain[head][0] != 0){
            if(dfs(0,arr,n)) return max;
        }else if (contain[head][1] != -1){
            max = contain[head][1];
        }
        for (int i = 0; i < num.size() - 1; i++) {
            max = max * 10 + arr[arr.length - 1];
        }
        // 提供的数字都大于n最高位,只能返回n-1位长度
        return max;
    }

    private boolean dfs(int depth, int[] arr, int n){
        if (depth == num.size()){
            return arrToInt() < n;
        }
        // 如果前一位已经小于模式数了,剩下的直接选择最大值比如(4 5 00与4 4 99)
        if (depth > 1 && result[depth - 1] < num.get(num.size() - depth)){
            while (depth < num.size()){
                result[depth++] = arr[arr.length - 1];
            }
            return true;
        }
        // 到此说明前一位仍是选择了相同的数,dfs不可能选择大于的,因为这样得到的数必然大于n
        int cur = num.get(num.size() - 1 - depth);
        // 存在则选择,不存在选更小的
        cur = contain[cur][0] != 0 ? cur : contain[cur][1];
        while (cur != -1) {
            result[depth] = cur;
            if (dfs(depth + 1,arr,n)) return true;
            cur = contain[cur][1];
        }
        return false;
    }

    private int arrToInt(){
        int sum = 0;
        for (int j : result) {
            sum = sum * 10 + j;
        }
        return sum;
    }

    public static void main(String[] args) {
        _字节面试_生成最大数 v = new _字节面试_生成最大数();
        v.maxNum(10000000,new int[]{1,2,3,4,9});
        System.out.println();
    }
}

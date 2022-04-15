package 算法面试._00_排序算法;

import _0_Tools.Integers;

/**
 * @ClassName QuickSort
 * @Description
 * @Author StarLee
 * @Date 2022/4/12
 */

public class QuickSort {
    public void quickSort(Integer[] arr){
        if (arr == null || arr.length <= 1) return;
        sort(arr,0,arr.length);
    }

    private void sort(Integer[] arr, int begin, int end){
        if (end - begin < 2) return;
        int pIndex = findPoint(arr,begin,end);
        sort(arr,begin,pIndex);
        sort(arr,pIndex + 1,end);
    }

    private int findPoint(Integer[] arr, int begin, int end){
        int randomIndex = begin + (int) (Math.random() * (end - begin));
        Integer selectedInt = arr[randomIndex];
        arr[randomIndex] = arr[begin];
        arr[begin] = selectedInt;
        end--;
        while (begin < end){
            while (begin < end){
                if (arr[end] < selectedInt){
                    arr[begin++] = arr[end];
                    break;
                }else {
                    end--;
                }
            }
            while (begin < end){
                if (arr[begin] > selectedInt){
                    arr[end--] = arr[begin];
                    break;
                }else {
                    begin++;
                }
            }
        }
        arr[begin] = selectedInt;
        return begin;
    }

    public static void main(String[] args) {
        Integer[] random = Integers.random(15, 0, 200);
        QuickSort sort = new QuickSort();
        sort.quickSort(random);
        for (Integer integer : random) {
            System.out.print(integer + " ");
        }
    }
}

package _01_递归._03_Hanoi;

/**
 * @ClassName Hanoi
 * @Description  汉诺塔实现
 * @Author StarLee
 * @Date 2021/12/26
 */

public class Hanoi {
    /**
     *  @MethodName hanoi
     *  @Param [num 盘子数量, source 当前所在盘子, middle 辅助盘子, dest 目标盘子]
     *  时间复杂度O(2^n)  空间复杂度O(n)
     */
    public static void hanoi(int num,String source,String middle,String dest){
        if (num == 1){
            move(num,source,dest);
            return;
        }
        hanoi(num-1,source,dest,middle);
        move(num,source,dest);
        hanoi(num - 1,middle,source,dest);
    }

    /**
     *  @MethodName move
     *  @Param [name 盘子编号, from 目前所在盘子, to 目标盘子]
     */
    private static void move(int name,String from,String to){
        System.out.println("将" + name + "号盘子从" + from + "移到" + to);
    }
}

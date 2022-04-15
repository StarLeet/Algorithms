package 算法面试._11_困难题;

/**
 * @ClassName _780_到达终点
 * @Description
 * @Author StarLee
 * @Date 2022/4/9
 */

public class _780_到达终点 {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx > 0 && ty > 0){
            if (sx == tx && sy == ty) return true;
            // 确保ty > tx
            if (tx > ty){
                // 如果写成 tx - ty 会出现超减的情况
                tx -= Math.max(((tx - sx) / ty),1) * ty;
            }else {  // 1,1   3,5
                ty -= Math.max(((ty - sy) / tx),1) * tx;
            }
            System.out.println(tx + " " + ty);
        }
        return false;
    }

    public static void main(String[] args) {
        _780_到达终点 v = new _780_到达终点();
        v.reachingPoints(2,7,45,32);
    }
}

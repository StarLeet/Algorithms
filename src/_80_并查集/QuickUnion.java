package _80_并查集;

/**
 * @ClassName QuickUnion
 * @Description
 * @Author StarLee
 * @Date 2022/5/13
 */
public class QuickUnion extends UnionFind{

    public QuickUnion(int capacity) {
        super(capacity);
    }


    @Override
    public void union(int e1, int e2) {
        // 约定e1集合向e2集合合并
        unionFind[find(e1)] = find(e2);
    }

    @Override
    public int find(int e) {
        while (unionFind[e] != e){
            e = unionFind[e];
        }
        return e;
    }

    @Override
    public boolean isSame(int e1, int e2) {
        return find(e1) == find(e2);
    }

    public static void main(String[] args) {
        QuickUnion quickUnion = new QuickUnion(10);
        quickUnion.union(7,8);
        quickUnion.union(8,9);
        quickUnion.union(2,1);
        quickUnion.union(4,1);
        System.out.println(quickUnion.find(7));
    }
}

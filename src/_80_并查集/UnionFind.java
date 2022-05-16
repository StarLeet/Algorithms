package _80_并查集;

/**
 * @ClassName UnionFind
 * @Description
 * @Author StarLee
 * @Date 2022/5/13
 */
public abstract class UnionFind {
    protected final int[] unionFind;

    public UnionFind(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("并查集的容量设置过小");
        this.unionFind = new int[capacity];
        for (int i = 0; i < unionFind.length; i++) {
            unionFind[i] = i;
        }
    }

    public abstract void union(int e1, int e2);
    public abstract int find(int e);
    public abstract boolean isSame(int e1, int e2);
}

public class ConnectingGraph2 {
    private int[] f;
    private int[] size;
    
    /*
    * @param n: An integer
    */public ConnectingGraph2(int n) {
        f = new int[n + 1];
        size = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            f[i] = i;
            size[i] = 1;
        }
    }
    
    private int find(int x) {
        if (f[x] == x) {
            return x;
        }
        return f[x] = find(f[x]);
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);
        if (root_a != root_b) {
            f[root_a] = root_b;
            size[root_b] += size[root_a];
        }
    }

    /*
     * @param a: An integer
     * @return: An integer
     */
    public int query(int a) {
        return size[find(a)];
    }
}
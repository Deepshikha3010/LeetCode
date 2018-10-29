public class ConnectingGraph3 {
    private int[] f;
    private int count;
    
    public ConnectingGraph3(int n) {
        f = new int[n + 1];
        count = n;
        for (int i = 1; i < n + 1; i++) {
            f[i] = i;
        }
    }
    
    private int find(int x) {
        if (f[x] == x) {
            return x;
        }
        return f[x] = find(f[x]);
    }
    
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);
        if (root_a != root_b) {
            f[root_a] = root_b;
            count--;
        }
    }

    /**
     * @return: An integer
     */
    public int query() {
        return count;
    }
}
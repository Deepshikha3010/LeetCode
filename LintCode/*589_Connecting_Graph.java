public class ConnectingGraph {
    
    private int[] f;
    /*
    * @param n: An integer
    */public ConnectingGraph(int n) {
        f = new int[n + 1];
        for (int i = 1; i < n; i++) {
            f[i]= i;
        }
        // do intialization if necessary 
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
        }
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: A boolean
     */
    public boolean query(int a, int b) {
        return find(a) == find(b);
    }
}
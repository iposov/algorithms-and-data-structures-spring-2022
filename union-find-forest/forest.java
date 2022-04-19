public class forest {

    private int[] forest;

    public forest(int size) {
        forest = new int[size];
        for (int i = 0; i < size; i++) {
            forest[i] = i;
        }
    }

    public int get(int x) {
        if (forest[x] != x) {
            forest[x] = get(forest[x]);
        }
        return forest[x];
    }

    public boolean union(int x, int y) {
        x = get(x);
        y = get(y);

        if (x != y) {
            forest[x] = y;
            return false;
        }

        return true;
    }

}
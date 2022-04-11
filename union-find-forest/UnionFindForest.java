public class UnionFindForest {
    private int[] parents;
    private int[] rank;

    public UnionFindForest(int size){
        parents = new int[size];
        rank = new int[size];
        for(int i = 0; i < size; i++){
            parents[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x){
        int y = x;
        while(parents[x] != x)
            x = parents[x];
        while(parents[y] != y){
            y = parents[y];
            parents[y] = x;
        }
        return x;
    }

    public boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a == b)
            return false;
        if(rank[a] > rank[b])
            parents[a] = b;
        else
            parents[b] = a;
        ++rank[a];
        ++rank[b];
        return true;
    }

    // Считает количество подмножеств
    public int numberOfSets(){
        int[] uniqueSets = new int[parents.length];
        int size = 0;
        for(int a : parents){
            boolean flag = true;
            int representative = find(a);
            for(int i = 0; i < size; i++)
                if(uniqueSets[i] == representative){
                    flag = false;
                    break;
                }
            if(flag){
                uniqueSets[size] = representative;
                size++;
            }
        }
        return size;
    }
}

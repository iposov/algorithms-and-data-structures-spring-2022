public class third {
    private int size;
    private int maxSize;
    private int[] heap;

    public third(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.heap = new int[maxSize];
    }

    private void swap(int firstPos, int secondPos) {
        int tmp = heap[firstPos];
        heap[firstPos] = heap[secondPos];
        heap[secondPos] = tmp;
    }

    private void siftDown(int i) {
        while (2 * i + 1 < size) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int j = left;
            if (right < size && heap[right] > heap[left]) {
                j = right;
            }
            if (heap[i] >= heap[j]) {
                break;
            }
            swap(i, j);
            i = j;
        }
    }

    private void siftUp(int i) {
        while (heap[i] > heap[(i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public int extractMin() {
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        siftDown(0);
        return max;
    }

    public void insert(int key) {
        size++;
        heap[size - 1] = key;
        siftUp(size - 1);
    }
}
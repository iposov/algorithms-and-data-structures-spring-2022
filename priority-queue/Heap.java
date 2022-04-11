import java.util.ArrayList;
import java.util.List;

public class Heap {
    private int[] heap;
    private int size;
    private int maxSize;

    public Heap(int maxSize){
        this.maxSize = maxSize;
        this.size = 0;
        this.heap = new int[maxSize];
    }

    public void add(int value){
        size++;
        heap[size - 1] = value;
        siftUp(size - 1);
    }

    public int get(){
        int value = heap[0];
        heap[0] = heap[size - 1];
        size--;
        siftDown(0);
        return value;
    }

    public void siftUp(int i){
        while(heap[i] > heap[(i - 1)/2]){
            swap(i, (i - 1)/2);
            i = (i - 1)/2;
        }
    }

    public void siftDown(int i){
        while(2 * i + 1 < size){
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int j = left;
            if(right < size && heap[right] > heap[left])
                j = right;
            if(heap[i] >= heap[j])
                break;
            swap(i, j);
            i = j;
        }
    }

    private void swap(int i1, int i2){
        int tmp = heap[i1];
        heap[i1] = heap[i2];
        heap[i2] = tmp;
    }
//    private List<Integer> heap;
//
//    public Heap(){
//        heap = new ArrayList<>();
//    }
//
//    public void add(int value){
//        heap.add(value);
//        siftUp(heap.size() - 1);
//    }
//
//    public int get(){
//        int value = heap.get(0);
//        heap.set(0, heap.get(heap.size() - 1));
//        heap.remove(heap.size() - 1);
//        siftDown(0);
//        return value;
//    }
//
//    public void siftUp(int i){
//        while(heap.get(i) > heap.get((i - 1)/2)){
//            swap(i, (i - 1)/2);
//            i = (i - 1)/2;
//        }
//    }
//
//    public void siftDown(int i){
//        while(2 * i + 1 < heap.size()){
//            int left = 2 * i + 1;
//            int right = 2 * i + 2;
//            int j = left;
//            if(right < heap.size() && heap.get(right) > heap.get(left))
//                j = right;
//            if(heap.get(i) >= heap.get(j))
//                break;
//            swap(i, j);
//            i = j;
//        }
//    }
//
//    private void swap(int i1, int i2){
//        int tmp = heap.get(i1);
//        heap.set(i1, heap.get(i2));
//        heap.set(i2, tmp);
//    }
}

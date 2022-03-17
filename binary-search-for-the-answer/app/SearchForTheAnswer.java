import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SearchForTheAnswer {
    private List<Integer> array;
    private int left;
    private int right;
    private int middle;

    public static void main(String[] args) {
        SearchForTheAnswer search = new SearchForTheAnswer();
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int k = scan.nextInt();
        search.array = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            search.array.add(scan.nextInt());
        }
        search.array = search.array.stream().sorted().collect(Collectors.toList());
        search.left = 0;
        search.right = search.array.get(size - 1) - search.array.get(0) + 1;
        while (search.right - search.left > 1) {
            search.middle = (search.left + search.right) / 2;
            if (search.check(search.middle, k)){
                search.left = search.middle;
            }
            else{
                search.right = search.middle;
            }
        }
        System.out.println(search.left);
    }

    private boolean check(int x, int k) {
        int c = 1;
        int last_c = array.get(0);
        for (int i : array) {
            if (i - last_c >= x) {
                c++;
                last_c = i;
            }
        }
        return c > k;
    }
}

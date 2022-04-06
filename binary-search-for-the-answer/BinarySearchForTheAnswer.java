import java.util.Scanner;
import java.util.stream.IntStream;

public class BinarySearchForTheAnswer {
    private int[] array;

    private boolean checkForSearch(int x, int k) {
        int lines = 1;
        int lastLine = array[0];
        for (int j : array) {
            if (j - lastLine >= x) {
                lines++;
                lastLine = j;
            }
        }
        return lines > k;
    }

    public int solveForSearch(int k) {
        int left = 0;
        int right = (array[array.length-1] - array[0]) + 1;
        while (right - left > 1) {
            int mid = (left + right) / 2;
            if(checkForSearch(mid, k)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        BinarySearchForTheAnswer search = new BinarySearchForTheAnswer();
        //Сканер для чтения входных данных
        Scanner scanner = new Scanner(System.in);
        //Получаем размер массива и количество точек
        int sizeN = Integer.parseInt(scanner.nextLine());
        //Получаем количество отрезков
        int sizeK = Integer.parseInt(scanner.nextLine());
        //Создаем новый массив...
        search.array = new int[sizeN];
        //...И заполняем координатами точек
        IntStream.range(0, sizeN).forEach(
                i -> search.array[i] = Integer.parseInt(scanner.nextLine())
        );
        //Проверяем следующие K чисел
        System.out.println(search.solveForSearch(sizeK));
    }
}

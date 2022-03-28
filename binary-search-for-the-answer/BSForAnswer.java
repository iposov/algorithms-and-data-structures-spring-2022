import java.util.Scanner;

public class BSForAnswer {

    private int[] array;

    private boolean check(int x, int k) {
        int lines = 1;
        int last_line = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] - last_line >= x) {
                lines++;
                last_line = array[i];
            }
        }
        return lines > k;
    }

    public int solve(int k) {
        int left = 0;
        int right = array[array.length-1]-array[0]+1;
        while (right - left > 1) {
            int mid = (left + right) / 2;
            if(check(mid, k)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;

    }

    public static void main(String[] args) {
        BSForAnswer binSearchForAnswer = new BSForAnswer();
        Scanner scanner = new Scanner(System.in); //для чтения входных данных
        //первая строка входных данных - размер массива и количество точек
        int N = Integer.parseInt(scanner.nextLine()); //"приводим" полученную строку с числом к Integer
        //количество отрезков
        int k = Integer.parseInt(scanner.nextLine()); //"приводим" полученную строку с числом к Integer

        binSearchForAnswer.array = new int[N]; //создаем новый массив
        for (int i = 0;i < N; i++) {
            binSearchForAnswer.array[i] = Integer.parseInt(scanner.nextLine()); //заполняем координатами точек
        }

        System.out.println(binSearchForAnswer.solve(k)); //читаем и проверяем K чисел

    }
}

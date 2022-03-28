import java.util.Scanner;


public class BS {
    private int[] array; //сюда помещаются входные данные


    public int binarySearch(int value) {
        int left = 0; //граница диапазона
        int right = array.length - 1; //другая граница
        int mid; //показатель нахождения числа в левой или правой половине
        while (true) {
            if (left > right) {
                return -1;
            }
            mid = (left + right) / 2;
            if (array[mid] == value) {
                return mid;
            }
            if (array[mid] > value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }

    public static void main(String[] args) {
        BS binSearch = new BS();
        Scanner scanner = new Scanner(System.in); //для чтения входных данных
        //первая строка входных данных - размер массива, значит считаем ее в переменную
        int N = Integer.parseInt(scanner.nextLine()); //"приводим" полученную строку с числом к Integer
        String[] strArray = (scanner.nextLine()).split(" "); //получаем массив в виде строки и сразу же парсим по пробелу
        binSearch.array = new int[N]; //создаем новый массив
        for (int i = 0;i < N; i++) {
            binSearch.array[i] = Integer.parseInt(strArray[i]);
        }
        int K = Integer.parseInt(scanner.nextLine()); // количество значений на проверку
        for (int i = 0;i < K; i++) {
            System.out.println(binSearch.binarySearch(Integer.parseInt(scanner.nextLine()))); //читаем и проверяем K чисел
        }
    }
}
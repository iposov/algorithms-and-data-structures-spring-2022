import java.util.Scanner;

public class BinSearch {
    //Поле, которое содержит исходный массив
    private int[] array;
    //Функция двоичного поиска
    public int binSearch(int number) {
        int left = 0,
                right = array.length - 1,
                middle;
        while (true) {
            if (left > right)
                return -1;
            middle = (left + right) / 2;
            if (array[middle] == number)
                return middle;
            if (array[middle] > number) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
    }
    //Функция main
    public static void main(String[] args) {
        BinSearch search = new BinSearch();
        //Сканер для чтения входных данных
        Scanner scanner = new Scanner(System.in);
        //Запишем первую строку файла (размер массива) в отдельную переменную
        int sizeN = Integer.parseInt(scanner.nextLine());
        //Спарсим строку по пробелу
        String[] inputArray = (scanner.nextLine()).split(" ");
        //Создаем новый массив, куда в цикле запишем элементы массиве
        search.array = new int[sizeN];
        for (int i = 0; i < sizeN; i++) {
            search.array[i] = Integer.parseInt(inputArray[i]);
        }
        //Получаем количество значений на проверку
        int sizeK = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < sizeK; i++) {
            //Читаем и проверяем K чисел
            System.out.println(search.binSearch(Integer.parseInt(scanner.nextLine())));
        }
    }
}

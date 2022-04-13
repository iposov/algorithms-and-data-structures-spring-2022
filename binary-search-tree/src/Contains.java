import com.sun.source.tree.BinaryTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Contains {

    public static void main(String[] args) {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(bufferedReader.readLine());
            Set<Integer> set = new TreeSet<Integer>();
            for (int i = 0; i < N; i++) {
                int n = Integer.parseInt(bufferedReader.readLine());
                if (set.contains(n)) {
                    System.out.println("+");
                } else {
                    set.add(n);
                    System.out.println("-");
                }
            }

        }catch(Exception e) {

        }
    }
}

/*
Только проверка на вхождение элемента
В стандартном входе в первой строке написано число N,
оно означет количество чисел, которые будут даны дальше
для добавления в двоичное дерево. Заведите пустое
двоичное дерево поиска.
Дальшее в N строках находится по одному числу.
Для каждого числа вы сначала проверяете,
было ли это число в дереве, а потом добавляете число в дерево, если его не было.

В вывод в отдельную строку нужно написть + или - в зависимости от того, было ли число в дереве.

Т.е., встречалось ли оно раньше. Например, для входа

4 10 20 10 30 (в примере всё в одну строку) вы должны вывести - - + -.

Для проврки файлы с тестами заканчиваются на слово contains, например, 1.contains.out.
 */
import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class imageClasterization {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    int str;
    int stol;
    char[][] data;
    int[][] label;

    public imageClasterization(int r, int c) {
        this.data = new char[r][c];
        this.label = new int[r][c];
        this.str = r;
        this.stol = c;
    }

    public void work(int x, int y, int answ) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        while (!q.isEmpty()) {
            Point point = q.remove();
            if (point.x < 0 || point.y < 0 || point.x >= str || point.y >= stol)
                continue;
            if (label[point.x][point.y] != 0 || data[point.x][point.y] == '.')
                continue;
            label[point.x][point.y] = answ;
            for (int dir = 0; dir < 4; dir++)
                q.add(new Point(point.x + dx[dir], point.y + dy[dir]));
        }
    }

    public static void main(String[] args) {
        var iterator = new Scanner(System.in).tokens().iterator();
        var iC = new imageClasterization(parseInt(iterator.next()), parseInt(iterator.next()));
        for (int i = 0; i < iC.str; i++) {
            iC.data[i] = iterator.next().toCharArray();
        }
        int answer = 0;
        for (int i = 0; i < iC.str; i++)
            for (int j = 0; j < iC.stol; j++)
                if (iC.label[i][j] == 0 && iC.data[i][j] != '.')
                    iC.work(i, j, ++answer);
        System.out.println(answer);
    }
} 
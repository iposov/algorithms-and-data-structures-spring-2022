package com.solution;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class ImageClustering {
    int rows;
    int cols;
    char[][] data;
    int[][] label;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public ImageClustering(int r, int c) {
        this.rows = r;
        this.cols = c;
        this.data = new char[r][c];
        this.label = new int[r][c];
    }

    public void BFS(int x, int y, int currentIslandNum) {
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point point = queue.remove();

            if (point.x < 0 || point.y < 0 || point.x >= rows || point.y >= cols)
                continue;
            if (label[point.x][point.y] != 0 || data[point.x][point.y] == '.')
                continue;

            label[point.x][point.y] = currentIslandNum;

            for (int dir = 0; dir < 4; dir++)
                queue.add(new Point(point.x + dx[dir], point.y + dy[dir]));
        }
    }

    public int findIslands() {
        int islandNum = 0;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (label[i][j] == 0 && data[i][j] != '.')
                    BFS(i, j, ++islandNum);

        return islandNum;
    }

    public static void main(String[] args) {
        var iterator = new Scanner(System.in).tokens().iterator();

        var imageClustering = new ImageClustering(parseInt(iterator.next()), parseInt(iterator.next()));

        for (int i = 0; i < imageClustering.rows; i++) {
            imageClustering.data[i] = iterator.next().toCharArray();
        }

        System.out.println(imageClustering.findIslands());
    }
}

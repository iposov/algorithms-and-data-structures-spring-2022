import java.util.Scanner;

public class BinarySearchForTheAnswer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPoints = scanner.nextInt();
        int numberOfLines = scanner.nextInt();
        int[] coords = new int[numberOfPoints];
        for(int i = 0; i < numberOfPoints; i++)
            coords[i] = scanner.nextInt();
        System.out.println(solve(coords, numberOfLines));
    }


    private static boolean check(int[] coords, int mid, int numberOfLines) {
        int lines = 0;
        int lastLine = coords[0];
        for (int coord : coords) {
            if (coord - lastLine >= mid) {
                lines++;
                lastLine = coord;
            }
        }
        return lines >= numberOfLines;
    }

    private static int solve(int[] coords, int numberOfLines) {
        int left = 0;
        int right = coords[coords.length - 1] - coords[0] + 1;
        while (right - left > 1) {
            int mid = (left + right) / 2;
            if (check(coords, mid, numberOfLines)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
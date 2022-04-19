import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Integer[][] coordinates = new Integer[n][2];
        for (int i = 0; i < n; i++) {
            String[] buff = reader.readLine().split(" ");
            coordinates[i][0] = Integer.parseInt(buff[0]);
            coordinates[i][1] = Integer.parseInt(buff[1]);
        }

        Polygon polygon = new Polygon(coordinates);
        System.out.println(polygon.calculateArea());

    }

}
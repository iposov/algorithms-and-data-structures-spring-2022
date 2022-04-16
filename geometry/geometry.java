import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

class Poly {
    private Integer[][] x_y;
    public Poly(Integer[][] x_y) {
        this.x_y = x_y;
    }
    public double work() {
        double result = 0;
        for (int k = 0; k < x_y.length; k++) {
            result += x_y[k][0] * x_y[(k + 1) % x_y.length][1] -
                    x_y[(k + 1) % x_y.length][0] * x_y[k][1];
        }
        result = 0.5 * Math.abs(result);
        BigDecimal res = BigDecimal.valueOf(result);
        res = res.setScale(1, RoundingMode.HALF_UP);
        return res.doubleValue();
    }
}

public class geometry {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(read.readLine());
        Integer[][] x_y = new Integer[n][2];
        for (int k = 0; k < n; k++) {
            String[] buff = read.readLine().split(" ");
            x_y[k][0] = Integer.parseInt(buff[0]);
            x_y[k][1] = Integer.parseInt(buff[1]);
        }
        Poly Poly = new Poly(x_y);
        System.out.println(Poly.work());
    }
}
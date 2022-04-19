import java.math.BigDecimal;
import java.math.RoundingMode;

public class polygon {

    private Integer[][] coordinates;

    public polygon(Integer[][] coordinates) {
        this.coordinates = coordinates;
    }

    public double calculateArea() {
        double result = 0;
        for (int i = 0; i < coordinates.length; i++) {
            result += coordinates[i][0] * coordinates[(i + 1) % coordinates.length][1] -
                    coordinates[(i + 1) % coordinates.length][0] * coordinates[i][1];
        }
        result = 0.5 * Math.abs(result);

        return round(result, 1);
    }

    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
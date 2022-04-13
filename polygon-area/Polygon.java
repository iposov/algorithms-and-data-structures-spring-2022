
public class Polygon {

  private Integer[][] coordinates;

  public Polygon(Integer[][] coordinates) {
    this.coordinates = coordinates;
  }

  public double calculateArea() {
    double result = 0;
    for (int i = 0; i < coordinates.length; i++) {
      result += coordinates[i][0] * coordinates[(i + 1) % coordinates.length][1] -
          coordinates[(i + 1) % coordinates.length][0] * coordinates[i][1];
    }
    result = 0.5 * Math.abs(result);

    return result;
  }

}

package model;

public class CarreiraCultural {
  private String atuacaoCultural;
  private String segmentoCultural;
  private String coletivoCultural;

  public CarreiraCultural(String atuacaoCultural, String segmentoCultural, String coletivoCultural) {
    this.atuacaoCultural = atuacaoCultural;
    this.segmentoCultural = segmentoCultural;
    this.coletivoCultural = coletivoCultural;
  }

  public String toString() {
    return "CarreiraCultural{" +
        "atuacaoCultural='" + atuacaoCultural + '\'' +
        "segmentoCultural='" + segmentoCultural + '\'' +
        "coletivoCultural='" + coletivoCultural + '\'';
  }
}

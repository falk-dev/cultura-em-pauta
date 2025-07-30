package model;

public class CarreiraCultural {
  private String atuacaoCultural;
  private String segmentoCultural;
  private String grupoCultural;

  public CarreiraCultural(String atuacaoCultural, String segmentoCultural, String grupoCultural) {
    this.atuacaoCultural = atuacaoCultural;
    this.segmentoCultural = segmentoCultural;
    this.grupoCultural = grupoCultural;
  }

  public String getSegmentoCultural() {
    return segmentoCultural;
  }

  public String toString() {
    return "Atuação Cultural: " + atuacaoCultural + "\n" +
        "Segmento Cultural: " + segmentoCultural + "\n" +
        "Grupo Cultural: " + grupoCultural + "\n";
  }
}

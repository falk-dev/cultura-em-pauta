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

  public String getAtuacaoCultural() {
    return atuacaoCultural;
  }

  public String getSegmentoCultural() {
    return segmentoCultural;
  }

  public String getColetivoCultural() {
    return grupoCultural;
  }

  public void setAtuacaoCultural(String atuacaoCultural) {
    this.atuacaoCultural = atuacaoCultural;
  }

  public void setSegmentoCultural(String segmentoCultural) {
    this.segmentoCultural = segmentoCultural;
  }

  public void setColetivoCultural(String coletivoCultural) {
    this.grupoCultural = coletivoCultural;
  }

  public String toString() {
    return "Atuação Cultural: " + atuacaoCultural + "\n" +
        "Segmento Cultural: " + segmentoCultural + "\n" +
        "Grupo Cultural: " + grupoCultural + "\n";
  }
}

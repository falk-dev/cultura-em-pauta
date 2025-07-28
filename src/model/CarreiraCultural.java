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

  public String getAtuacaoCultural() {
    return atuacaoCultural;
  }

  public String getSegmentoCultural() {
    return segmentoCultural;
  }

  public String getColetivoCultural() {
    return coletivoCultural;
  }

  public void setAtuacaoCultural(String atuacaoCultural) {
    this.atuacaoCultural = atuacaoCultural;
  }

  public void setSegmentoCultural(String segmentoCultural) {
    this.segmentoCultural = segmentoCultural;
  }

  public void setColetivoCultural(String coletivoCultural) {
    this.coletivoCultural = coletivoCultural;
  }

  public String toString() {
    return "CarreiraCultural{" +
        "atuacaoCultural='" + atuacaoCultural + '\'' +
        "segmentoCultural='" + segmentoCultural + '\'' +
        "coletivoCultural='" + coletivoCultural + '\'';
  }
}

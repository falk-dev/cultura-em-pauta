package model;

public class Proposta {
  private static int contador = 0;

  private String id;
  private String titulo;
  private String descricao;
  private String segmentoCultural;

  public Proposta(String titulo, String descricao, String segmentoCultural) {
    this.id = "P" + (++contador);
    this.titulo = titulo;
    this.descricao = descricao;
    this.segmentoCultural = segmentoCultural;
  }

  public String getId() {
    return id;
  }

  public String getTitulo() {
    return titulo;
  }

  public String getSegmentoCultural() {
    return segmentoCultural;
  }

  @Override
  public String toString() {
    return "ID: " + id + "\n" +
        "Título: " + titulo + "\n" +
        "Descrição: " + descricao + "\n" +
        "Segmento Cultural: " + segmentoCultural + "\n" +
        "---------------------------\n";
  }
}
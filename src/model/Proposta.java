package model;

public class Proposta {
  private static int id = 0;
  private String titulo;
  private String descricao;
  private String segmentoCultural;

  public Proposta(String titulo, String descricao, String segmentoCultural) {
    id++;
    this.titulo = titulo;
    this.descricao = descricao;
    this.segmentoCultural = segmentoCultural;
  }

  public String getId() {
    return Integer.toString(id);
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
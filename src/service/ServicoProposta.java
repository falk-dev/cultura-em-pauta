package service;

import model.Proposta;
import repository.BDSimulado;

public class ServicoProposta {
  private Proposta p;

  public String cadastrarProposta(String idSessao, String titulo, String descricao, String segmentoCultural) {
    if (titulo.isBlank() || descricao.isBlank() || segmentoCultural.isBlank()) {
      return "Erro: todos os campos devem ser preenchidos.";
    }

    p = new Proposta(titulo, descricao, segmentoCultural);
    BDSimulado.addProposta(p);

    return "Proposta cadastrada com sucesso! ID: " + p.getId();
  }

  public String listarPropostas() {
    StringBuilder lista = new StringBuilder("\nLista de propostas cadastradas:\n\n");
    for (Proposta p : BDSimulado.getPropostas().values()) {
      lista.append(p.toString())
          .append("\n");
    }
    return lista.toString();
  }
}
package service;

import model.Proposta;
import model.Sessao;
import repository.BDSimulado;

public class ServicoProposta {
  private Proposta p;

  public String cadastrarProposta(String idSessao, String titulo, String descricao, String segmentoCultural) {
    if (titulo.isBlank() || descricao.isBlank() || segmentoCultural.isBlank()) {
      return "\n\u274C Erro: todos os campos devem ser preenchidos.";
    }

    Sessao s = BDSimulado.getSessoes().get(idSessao);
    if (s == null) {
      return "\n\u274C Erro: sessão não encontrada.";
    }

    p = new Proposta(titulo, descricao, segmentoCultural);
    BDSimulado.addProposta(p);

    s.adicionarProposta(p);

    return "\n\u2705 Proposta cadastrada com sucesso! ID: " + p.getId();
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
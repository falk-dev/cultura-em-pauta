package model.util;

import java.util.Optional;

import model.Sessao;
import repository.BDSimulado;

public class DadosMockadosSessao {
  public static void adicionarDadosMockados() {
    criarEAdicionarSessao(
        "1º Fórum de Expressões Culturais Regionais",
        "15/03/2023");

    criarEAdicionarSessao(
        "3º Fórum de Cultura Popular e Tradições",
        "28/04/2024");

    criarEAdicionarSessao(
        "1º Fórum de Patrimônio e Cultura",
        "10/06/2025");

    criarEAdicionarSessao(
        "5º Fórum de Linguagens Artísticas e Cidadania",
        "02/09/2024");

    criarEAdicionarSessao(
        "2º Fórum de Culturas Afro-Brasileiras e Indígenas",
        "18/11/2023");
  }

  private static void criarEAdicionarSessao(String sessao, String data) {
    Sessao s = new Sessao(
        sessao,
        data);
    BDSimulado.addSessao(s);
  }

  private static void adicionarParticipantesMock(String idSessao) {
    Sessao sessao = null;

    for (Sessao s : BDSimulado.getSessoes().values()) {
      if (s.getId().equals(idSessao)) {
        sessao = s;
        break;
      }
    }

    if (sessao == null) {
      System.out.println("Sessão com código " + idSessao + " não encontrada.");
      return;
    }

    Optional<Cpf> cpfCons1 = Cpf.getInstance("23097522077");
    Optional<Cpf> cpfCons2 = Cpf.getInstance("42075653020");
    Optional<Cpf> cpfOuv1 = Cpf.getInstance("46419746086");
    Optional<Cpf> cpfOuv2 = Cpf.getInstance("97957874037");

    Cpf cpfConselheiro1 = cpfCons1.get();
    Cpf cpfConselheiro2 = cpfCons2.get();
    Cpf cpfOuvinte1 = cpfOuv1.get();
    Cpf cpfOuvinte2 = cpfOuv2.get();

    sessao.adicionarConselheiro(cpfConselheiro1);
    sessao.adicionarConselheiro(cpfConselheiro2);
    sessao.adicionarOuvinte(cpfOuvinte1);
    sessao.adicionarOuvinte(cpfOuvinte2);

    System.out.println("Participantes adicionados à sessão " + sessao.getSessao());
  }

}
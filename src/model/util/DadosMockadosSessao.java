package model.util;

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
}
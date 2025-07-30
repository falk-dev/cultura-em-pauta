package model.util;

import model.Proposta;
import repository.BDSimulado;

public class DadosMockadosProposta {
  public static void adicionarDadosMockados() {
    criarEAdicionarProposta(
        "Revitalizar Teatro Municipal",
        "Reforma completa do espaço para eventos culturais",
        "Teatro");

    criarEAdicionarProposta(
        "Festival de Capoeira",
        "Organizar festival anual para promover a capoeira local",
        "Capoeira");

    criarEAdicionarProposta(
        "Exposição de Grafite",
        "Exposição de arte urbana no centro cultural",
        "Artes Visuais");

    criarEAdicionarProposta(
        "Ciclo de Cinema Documentário",
        "Exibição mensal de documentários culturais",
        "Cinema");

    criarEAdicionarProposta(
        "Oficina de Samba",
        "Oficinas semanais para formação musical",
        "Música");
  }

  private static void criarEAdicionarProposta(String titulo, String descricao, String segmentoCultural) {
    Proposta proposta = new Proposta(
        titulo,
        descricao,
        segmentoCultural);
    BDSimulado.addProposta(proposta);
  }
}
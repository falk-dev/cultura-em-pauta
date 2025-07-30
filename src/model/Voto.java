package model;

import contracts.Votante;

public class Voto {
  private Votante votante;
  private Proposta proposta;

  public Voto(Votante votante, Proposta proposta) {
    this.votante = votante;
    this.proposta = proposta;
  }

  public Votante getVotante() {
    return votante;
  }

  public Proposta getProposta() {
    return proposta;
  }
}
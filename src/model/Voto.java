package model;

import contracts.Votante;

public class Voto {
  private Votante votante;
  private Proposta proposta;
  private TipoVoto tipoVoto;

  public Voto(Votante votante, Proposta proposta, TipoVoto tipoVoto) {
    this.votante = votante;
    this.proposta = proposta;
    this.tipoVoto = tipoVoto;
  }

  public enum TipoVoto {
    SIM,
    NAO,
    ABSTENCAO
  }

  public Votante getVotante() {
    return votante;
  }

  public Proposta getProposta() {
    return proposta;
  }

  public TipoVoto getTipoVoto() {
    return tipoVoto;
  }
}
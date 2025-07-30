package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import contracts.Votante;
import model.Voto.TipoVoto;
import model.util.Cpf;

public class Sessao {
  private static int contador = 0;
  private String id;
  private String sessao;
  private String data;
  private List<Cpf> conselheirosPresentes;
  private List<Cpf> ouvintesPresentes;
  private List<Proposta> propostas;
  private Map<String, Voto> votos;
  private StatusSessao status;

  public Sessao(String sessao, String data) {
    this.id = "S" + (++contador);
    this.sessao = sessao;
    this.data = data;
    this.conselheirosPresentes = new ArrayList<>();
    this.ouvintesPresentes = new ArrayList<>();
    this.propostas = new ArrayList<>();
    this.votos = new HashMap<>();
    this.status = StatusSessao.CRIADA;
  }

  public enum StatusSessao {
    CRIADA,
    ATIVA,
    ENCERRADA
  }

  public String getId() {
    return id;
  }

  public String getSessao() {
    return sessao;
  }

  public String getData() {
    return data;
  }

  public List<Cpf> getConselheirosPresentes() {
    return conselheirosPresentes;
  }

  public List<Cpf> getOuvintesPresentes() {
    return ouvintesPresentes;
  }

  public List<Proposta> getPropostas() {
    return propostas;
  }

  public StatusSessao getStatus() {
    return status;
  }

  public List<Voto> getVotos() {
    return new ArrayList<>(votos.values());
  }

  public void iniciar() {
    if (status == StatusSessao.CRIADA) {
      status = StatusSessao.ATIVA;
    }
  }

  public void encerrar() {
    if (status == StatusSessao.ATIVA) {
      status = StatusSessao.ENCERRADA;
    }
  }

  public void adicionarConselheiro(Cpf c) {
    this.conselheirosPresentes.add(c);
  }

  public void adicionarOuvinte(Cpf c) {
    this.ouvintesPresentes.add(c);
  }

  public void adicionarProposta(Proposta p) {
    this.propostas.add(p);
  }

  public String registrarVoto(Votante votante, Proposta proposta, TipoVoto tipoVoto) {
    String id = votante.getId();

    if (votos.containsKey(id)) {
      return "\n\u274C Esse votante já registrou um voto nesta sessão.";
    }

    Voto voto = new Voto(votante, proposta, tipoVoto);
    votos.put(id, voto);
    return "\n\u2705 Voto registrado com sucesso.";
  }

  @Override
  public String toString() {
    return "ID: " + id + " | " + sessao + " | Data: " + data + " | Status: " + status;
  }
}
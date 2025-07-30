package repository;

import java.util.LinkedHashMap;
import java.util.Map;
import contracts.Votante;
import model.Pessoa;
import model.Proposta;
import model.Sessao;
import model.util.Cpf;

public class BDSimulado {
  private static Map<String, Pessoa> pessoas = new LinkedHashMap<String, Pessoa>();
  private static Map<String, Votante> votantes = new LinkedHashMap<String, Votante>();
  private static Map<String, Proposta> propostas = new LinkedHashMap<String, Proposta>();
  private static Map<String, Sessao> sessoes = new LinkedHashMap<String, Sessao>();

  // Métodos de Pessoa
  public static boolean addPessoa(Pessoa p) {
    if (pessoas.containsKey(p.getId())) {
      return false;
    }

    pessoas.put(p.getId(), p);
    return true;
  }

  public static void removerPessoa(Cpf cpf) {
    pessoas.remove(cpf.toString());
  }

  public static Map<String, Pessoa> getPessoas() {
    return pessoas;
  }

  // Métodos de Proposta
  public static void addProposta(Proposta p) {
    propostas.put(p.getId(), p);
  }

  public static Map<String, Proposta> getPropostas() {
    return propostas;
  }

  // Métodos de Sessão
  public static void addSessao(Sessao s) {
    sessoes.put(s.getId(), s);
  }

  public static Map<String, Sessao> getSessoes() {
    return sessoes;
  }

  // Métodos de Votante
  public static boolean addVotante(Votante v) {
    if (votantes.containsKey(v.getId())) {
      return false;
    }

    votantes.put(v.getId(), v);
    return true;
  }

}
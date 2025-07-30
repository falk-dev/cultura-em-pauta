package service;

import java.util.Optional;

import contracts.Votante;
import model.CarreiraCultural;
import model.Conselheiro;
import model.Ouvinte;
import model.Pessoa;
import model.util.Cpf;
import model.util.Email;
import repository.BDSimulado;

public class ServicoPessoa {
  private Pessoa p;

  public String cadastrarPessoa(String nome, String cpf, String email, String telefone, String pcd, String raca,
      String renda, String ocupacaoProfissional, String atuacaoCultural, String segmentoCultural,
      String coletivoCultural, String tipo) {

    Optional<Cpf> optCpf = Cpf.getInstance(cpf);
    Optional<Email> optEmail = Email.getInstance(email);

    if (optCpf.isEmpty() || optEmail.isEmpty()) {
      return "Erro: CPF ou e-mail inválido.";
    }

    Cpf cpfInstance = optCpf.get();
    Email emailInstance = optEmail.get();
    CarreiraCultural carreiraCultural = new CarreiraCultural(atuacaoCultural, segmentoCultural, coletivoCultural);

    if (tipo.equalsIgnoreCase("conselheiro")) {
      p = new Conselheiro(nome, cpfInstance, emailInstance, telefone, pcd, raca, renda, ocupacaoProfissional,
          carreiraCultural);
    } else if (tipo.equalsIgnoreCase("ouvinte")) {
      p = new Ouvinte(nome, cpfInstance, emailInstance, telefone, pcd, raca, renda, ocupacaoProfissional,
          carreiraCultural);
    }

    BDSimulado.addPessoa(p);

    if (p instanceof Votante) {
      BDSimulado.addVotante((Votante) p);
    }

    return tipo + " cadastrado com sucesso!";
  }

  public String listarPessoas() {
    StringBuilder lista = new StringBuilder("\nLista de pessoas cadastradas:\n");
    for (Pessoa p : BDSimulado.getPessoas().values()) {
      lista.append("- ")
          .append(p.getNome())
          .append(" | Segmento Cultural: ")
          .append(p.getCarreiraCultural().getSegmentoCultural())
          .append("\n");
    }
    return lista.toString();
  }

  public String listarConselheiros() {
    StringBuilder lista = new StringBuilder("\nLista de conselheiros:\n");
    for (Pessoa p : BDSimulado.getPessoas().values()) {
      if (p instanceof Conselheiro) {
        lista.append("- ")
            .append(p.getNome())
            .append(" | Segmento: ")
            .append(p.getCarreiraCultural().getSegmentoCultural())
            .append("\n");
      }
    }
    return lista.toString();
  }

  public String listarOuvintes() {
    StringBuilder lista = new StringBuilder("\nLista de ouvintes:\n");
    for (Pessoa p : BDSimulado.getPessoas().values()) {
      if (p instanceof Ouvinte) {
        lista.append("- ")
            .append(p.getNome())
            .append(" | Segmento: ")
            .append(p.getCarreiraCultural().getSegmentoCultural())
            .append("\n");
      }
    }
    return lista.toString();
  }

  public String buscarPessoaPorCpf(String cpf) {
    Optional<Cpf> optCpf = Cpf.getInstance(cpf);

    if (optCpf.isEmpty()) {
      return "CPF inválido.";
    }

    Pessoa p = BDSimulado.getPessoas().get(optCpf.get().toString());

    if (p == null) {
      return "Pessoa com CPF " + cpf + " não encontrada.";
    }

    return p.toString();
  }

  public String removerPessoaPorCpf(String cpf) {
    Optional<Cpf> optCpf = Cpf.getInstance(cpf);

    if (optCpf.isEmpty()) {
      return "CPF inválido.";
    }

    Pessoa p = BDSimulado.getPessoas().remove(optCpf.get().toString());

    if (p == null) {
      return "Pessoa com CPF " + cpf + " não encontrada.";
    }

    return "Pessoa '" + p.getNome() + "' removida com sucesso.";
  }
}
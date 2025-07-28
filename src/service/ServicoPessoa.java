package service;

import model.CarreiraCultural;
import model.Conselheiro;
import model.Ouvinte;
import model.Pessoa;
import model.util.Cpf;
import model.util.Email;
import repository.BDSimulado;

public class ServicoPessoa {
  private Pessoa p;

  public String cadastrarPessoa(String nome, Cpf cpf, Email email, String telefone, boolean pcd, String raca,
      String renda, String ocupacaoProfissional, CarreiraCultural carreiraCultura, String tipo) {
    if (!BDSimulado.verificarPessoa(p)) {
      return "Erro! O CPF já está cadastrado.";
    }

    if (tipo.equalsIgnoreCase("conselheiro")) {
      p = new Conselheiro(nome, cpf, email, telefone, pcd, raca, renda, ocupacaoProfissional, carreiraCultura);
    } else if (tipo.equalsIgnoreCase("ouvinte")) {
      p = new Ouvinte(nome, cpf, email, telefone, pcd, raca, renda, ocupacaoProfissional, carreiraCultura);
    }

    BDSimulado.addPessoa(p);
    return "Cadastro realizado com sucesso";
  }

  public void removerPessoa(Cpf cpf) {
    BDSimulado.removePessoa(cpf);
  }

  public String listarPessoas() {
    String lista = "\nLista de pessoas: \n";
    for (Pessoa p : BDSimulado.getPessoas().values()) {
      lista += p.listarPessoas() + "\n";
    }
    return lista;
  }
}
package model;

import java.util.List;

import model.util.Cpf;
import model.util.Email;
import contracts.Votante;

public class Conselheiro extends Pessoa implements Votante {
  private List<Proposta> propostas;

  public Conselheiro(String nome, Cpf cpf, Email email, String telefone, String pcd, String raca, String renda,
      String ocupacaoProfissional, CarreiraCultural carreiraCultural) {
    super(nome, cpf, email, telefone, pcd, raca, renda, ocupacaoProfissional, carreiraCultural);
  }

  public List<Proposta> getPropostas() {
    return propostas;
  }

  @Override
  public String getId() {
    return super.getId();
  }
}
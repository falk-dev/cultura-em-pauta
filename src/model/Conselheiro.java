package model;

import java.util.List;

import model.util.Cpf;
import model.util.Email;

public class Conselheiro extends Pessoa {
  private List<Proposta> propostas;

  public Conselheiro(String nome, Cpf cpf, Email email, String telefone, boolean pcd, String raca, String renda,
      String ocupacaoProfissional, CarreiraCultural carreiraCultural) {
    super(nome, cpf, email, telefone, pcd, raca, renda, ocupacaoProfissional, carreiraCultural);
  }
}

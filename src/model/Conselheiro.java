package model;

import model.util.Cpf;
import model.util.Email;
import contracts.Votante;

public class Conselheiro extends Pessoa implements Votante {
  public Conselheiro(String nome, Cpf cpf, Email email, String telefone, String pcd, String raca, String renda,
      String ocupacaoProfissional, CarreiraCultural carreiraCultural) {
    super(nome, cpf, email, telefone, pcd, raca, renda, ocupacaoProfissional, carreiraCultural);
  }

  @Override
  public String getId() {
    return super.getId();
  }

  @Override
  public String toString() {
    return super.toString() +
        "Tipo: Conselheiro\n" +
        "===============================================";
  }
}
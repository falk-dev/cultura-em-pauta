package model;

import model.util.Cpf;
import model.util.Email;

public class Ouvinte extends Pessoa {
  public Ouvinte(String nome, Cpf cpf, Email email, String telefone, String pcd, String raca, String renda,
      String ocupacaoProfissional, CarreiraCultural carreiraCultural) {
    super(nome, cpf, email, telefone, pcd, raca, renda, ocupacaoProfissional, carreiraCultural);
  }

  @Override
  public String toString() {
    return super.toString() +
        "Tipo: Ouvinte\n" +
        "===============================================";
  }
}
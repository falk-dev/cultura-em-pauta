package model;

import model.util.Cpf;
import model.util.Email;

public abstract class Pessoa {
  private String nome;
  private Cpf cpf;
  private Email email;
  private String telefone;
  private String pcd;
  private String raca;
  private String renda;
  private String ocupacaoProfissional;
  private CarreiraCultural carreiraCultural;

  public Pessoa(String nome, Cpf cpf, Email email, String telefone, String pcd, String raca, String renda,
      String ocupacaoProfissional, CarreiraCultural carreiraCultural) {
    this.nome = nome;
    this.cpf = cpf;
    this.email = email;
    this.telefone = telefone;
    this.pcd = pcd;
    this.raca = raca;
    this.renda = renda;
    this.ocupacaoProfissional = ocupacaoProfissional;
    this.carreiraCultural = carreiraCultural;
  }

  public String getId() {
    return cpf.toString();
  }

  public String getNome() {
    return nome;
  }

  public Cpf getCpf() {
    return cpf;
  }

  public CarreiraCultural getCarreiraCultural() {
    return carreiraCultural;
  }

  @Override
  public String toString() {
    return "\nNome: " + nome + "\n" +
        "CPF: " + cpf + "\n" +
        "Email: " + email + "\n" +
        "Telefone: " + telefone + "\n" +
        "PCD?: " + pcd + "\n" +
        "Raça: " + raca + "\n" +
        "Renda: R$ " + renda + "\n" +
        "Ocupação Profissional: " + ocupacaoProfissional + "\n" +
        carreiraCultural;
  }
}
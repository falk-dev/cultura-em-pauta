package model;

import model.util.Cpf;
import model.util.Email;

public abstract class Pessoa {
  private String nome;
  private Cpf cpf;
  private Email email;
  private String telefone;
  private boolean pcd;
  private String raca;
  private String renda;
  private String ocupacaoProfissional;
  private CarreiraCultural carreiraCultural;

  public Pessoa(String nome, Cpf cpf, Email email, String telefone, boolean pcd, String raca, String renda,
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

  public String toString() {
    return "Pessoa{" +
        "nome='" + nome + '\'' +
        "cpf='" + cpf + '\'' +
        ", email='" + email + '\'' +
        ", telefone=" + telefone + '\'' +
        ", pcd=" + pcd + '\'' +
        ", raça=" + raca + '\'' +
        ", renda=" + renda + '\'' +
        ", ocupacaoProfissional=" + ocupacaoProfissional + '\'' +
        ", carreiraCultural=" + carreiraCultural + '}';
  }
}
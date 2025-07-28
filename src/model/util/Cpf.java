package model.util;

import java.util.Optional;

public class Cpf {
  private String cpf;

  // Construtor privado para forçar o uso do getInstance
  private Cpf(String cpf) {
    this.cpf = cpf;
  }

  public static Optional<Cpf> getInstance(String cpf) {
    if (!validar(cpf))
      return Optional.empty();
    return Optional.of(new Cpf(cpf));
  }

  @Override
  public String toString() {
    return formatar(this.cpf);
  }

  public static String formatar(String cpf) {
    // Retirando os caracteres especiais caso tenha, deixando apenas números
    cpf = cpf.replaceAll("[^0-9]", "");

    // Transformando no formato: 123.456.789-00
    return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
  }

  public static boolean validar(String cpf) {
    // Retirando os caracteres especiais caso tenha, deixando apenas números
    String cpfApenasNumeros = cpf.replaceAll("[^0-9]", "");

    // CPF deve ter 11 dígitos e não pode ser formado por dígitos repetidos
    if (cpfApenasNumeros.length() != 11 || cpfApenasNumeros.matches("(\\d)\\1{10}")) {
      return false;
    }

    // Convertendo cada caractere do CPF para um dígito numérico
    int[] digitosCpf = new int[11];
    for (int posicao = 0; posicao < 11; posicao++) {
      digitosCpf[posicao] = cpfApenasNumeros.charAt(posicao) - '0';
    }

    // Cálculo do primeiro dígito verificador
    int somaParaPrimeiroDigito = 0;
    for (int posicao = 0; posicao < 9; posicao++) {
      somaParaPrimeiroDigito += digitosCpf[posicao] * (10 - posicao);
    }

    int restoPrimeiroDigito = somaParaPrimeiroDigito % 11;
    int primeiroDigitoVerificadorCalculado = (restoPrimeiroDigito < 2) ? 0 : (11 - restoPrimeiroDigito);

    // Cálculo do segundo dígito verificador
    int somaParaSegundoDigito = 0;
    for (int posicao = 0; posicao < 10; posicao++) {
      somaParaSegundoDigito += digitosCpf[posicao] * (11 - posicao);
    }

    int restoSegundoDigito = somaParaSegundoDigito % 11;
    int segundoDigitoVerificadorCalculado = (restoSegundoDigito < 2) ? 0 : (11 - restoSegundoDigito);

    // Compara os dígitos verificadores calculados com os informados no CPF
    int primeiroDigitoVerificadorInformado = digitosCpf[9];
    int segundoDigitoVerificadorInformado = digitosCpf[10];

    return (primeiroDigitoVerificadorCalculado == primeiroDigitoVerificadorInformado &&
        segundoDigitoVerificadorCalculado == segundoDigitoVerificadorInformado);
  }
}
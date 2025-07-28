package repository;

import java.util.HashMap;
import java.util.Map;

import model.Pessoa;
import model.util.Cpf;

public class BDSimulado {
  private static Map<String, Pessoa> pessoas = new HashMap<String, Pessoa>();

  public static boolean addPessoa(Pessoa p) {
    if (!verificarPessoa(p)) {
      return false;
    }

    pessoas.put(p.getId(), p);
    return true;
  }

  public static boolean verificarPessoa(Pessoa p) {
    if (pessoas.containsKey(p.getId())) {
      return false;
    }
    return true;
  }

  public static void removePessoa(Cpf cpf) {
    pessoas.remove(cpf.toString());
  }

  public static Pessoa getPessoa(Cpf cpf) {
    return pessoas.get(cpf.toString());
  }

  public static Map<String, Pessoa> getPessoas() {
    return pessoas;
  }
}

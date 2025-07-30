package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import contracts.Votante;
import model.Conselheiro;
import model.Ouvinte;
import model.Pessoa;
import model.Proposta;
import model.Sessao;
import model.Sessao.StatusSessao;
import model.Voto;
import model.Voto.TipoVoto;
import model.util.Cpf;
import repository.BDSimulado;

public class ServicoSessao {
  private Sessao s;

  public String cadastrarSessao(String sessao, String data) {
    s = new Sessao(sessao, data);
    BDSimulado.addSessao(s);

    return "Sessão criada com sucesso! ID: " + s.getId();
  }

  public String adicionarConselheirosASessao(String idSessao, Scanner teclado) {
    Sessao s = BDSimulado.getSessoes().get(idSessao);

    if (s == null) {
      return "Sessão não encontrada.";
    }

    // Lista de conselheiros disponíveis para serem adicionados à sessão
    List<Conselheiro> conselheiros = new ArrayList<>();
    for (Pessoa p : BDSimulado.getPessoas().values()) {
      if (p instanceof Conselheiro) {
        conselheiros.add((Conselheiro) p);
      }
    }

    if (conselheiros.isEmpty()) {
      return "Nenhum conselheiro disponível.";
    }

    System.out.println("Conselheiros disponíveis:");
    for (int i = 0; i < conselheiros.size(); i++) {
      System.out.println("[" + i + "] " + conselheiros.get(i).getNome());
    }

    System.out.print("Digite os números dos conselheiros que deseja adicionar (separados por vírgula): ");
    String[] idConselheiros = teclado.nextLine().split(",");

    for (String id : idConselheiros) {
      try {
        // Transformando em inteiro para acessar via índice na lista
        // Remoção de espaços do início e fim
        int i = Integer.parseInt(id.trim());

        s.adicionarConselheiro(((Pessoa) conselheiros.get(i)).getCpf());

      } catch (Exception e) {
        System.out.println("Erro ao adicionar conselheiro com índice: " + id);
      }
    }

    return "Conselheiros adicionados com sucesso à sessão " + idSessao + "!";
  }

  public String adicionarOuvintesASessao(String idSessao, Scanner teclado) {
    Sessao s = BDSimulado.getSessoes().get(idSessao);

    if (s == null) {
      return "Sessão não encontrada.";
    }

    // Lista de ouvintes disponíveis para serem adicionados à sessão
    List<Ouvinte> ouvintes = new ArrayList<>();
    for (Pessoa p : BDSimulado.getPessoas().values()) {
      if (p instanceof Ouvinte) {
        ouvintes.add((Ouvinte) p);
      }
    }

    if (ouvintes.isEmpty()) {
      return "Nenhum ouvinte disponível.";
    }

    System.out.println("Ouvintes disponíveis:");
    for (int i = 0; i < ouvintes.size(); i++) {
      System.out.println("[" + i + "] " + ouvintes.get(i).getNome());
    }

    System.out.print("Digite os números dos ouvintes que deseja adicionar (separados por vírgula): ");
    String[] idOuvintes = teclado.nextLine().split(",");

    for (String id : idOuvintes) {
      try {
        // Transformando em inteiro para acessar via índice na lista
        // Remoção de espaços do início e fim
        int i = Integer.parseInt(id.trim());

        s.adicionarOuvinte(((Pessoa) ouvintes.get(i)).getCpf());

      } catch (Exception e) {
        System.out.println("Erro ao adicionar ouvinte com índice: " + id);
      }
    }

    return "Ouvintes adicionados com sucesso à sessão " + idSessao + "!";
  }

  public String adicionarPropostasASessao(String idSessao, Scanner teclado) {
    Sessao s = BDSimulado.getSessoes().get(idSessao);

    if (s == null) {
      return "Sessão não encontrada.";
    }

    List<Proposta> listaPropostas = new ArrayList<>(BDSimulado.getPropostas().values());
    if (listaPropostas.isEmpty()) {
      return "Não há propostas para adicionar.";
    }

    System.out.println("Propostas disponíveis:");
    for (int i = 0; i < listaPropostas.size(); i++) {
      System.out.println(i + " - " + listaPropostas.get(i).getTitulo() + " | Segmento Cultural "
          + listaPropostas.get(i).getSegmentoCultural());
    }

    System.out.print("Informe os números das propostas que quer adicionar, separados por vírgula: ");
    String linha = teclado.nextLine();

    int totalPropostasAdicionadas = 0;
    String[] idProposta = linha.split(",");

    for (String id : idProposta) {
      id = id.trim();
      try {
        int i = Integer.parseInt(id);

        if (i >= 0 && i < listaPropostas.size()) {
          s.adicionarProposta(listaPropostas.get(i));
          totalPropostasAdicionadas++;
        } else {
          System.out.println("Número inválido (fora do intervalo): " + id);
        }

      } catch (Exception e) {
        System.out.println("Valor inválido ignorado: " + id);
      }
    }

    return totalPropostasAdicionadas + " proposta(s) adicionada(s) à sessão " + idSessao + ".";
  }

  public String iniciarSessao(String idSessao) {
    Sessao s = BDSimulado.getSessoes().get(idSessao);

    if (s == null) {
      return "Sessão não encontrada.";
    }

    if (s.getStatus() == StatusSessao.ATIVA) {
      return "Sessão já está ativa.";
    } else if (s.getStatus() == StatusSessao.ENCERRADA) {
      return "Sessão já foi encerrada e não pode ser reativada.";
    }
    s.iniciar();
    return "Sessão " + idSessao + " iniciada com sucesso!";
  }

  public String encerrarSessao(String idSessao) {
    Sessao s = BDSimulado.getSessoes().get(idSessao);
    if (s == null) {
      return "Sessão não encontrada.";
    }
    if (s.getStatus() != StatusSessao.ATIVA) {
      return "Só é possível encerrar sessões ativas.";
    }
    s.encerrar();
    return "Sessão " + idSessao + " encerrada com sucesso!";
  }

  public String listarSessoes() {
    StringBuilder lista = new StringBuilder("\nLista de propostas cadastradas:\n\n");
    for (Sessao s : BDSimulado.getSessoes().values()) {
      lista.append(s.toString())
          .append("\n");
    }
    return lista.toString();
  }

  public String consultarStatusSessao(String idSessao) {
    Sessao s = BDSimulado.getSessoes().get(idSessao);

    if (s == null) {
      return "Sessão não encontrada.";
    }

    StringBuilder lista = new StringBuilder();
    lista.append("\nSessão ID: ").append(s.getId()).append("\n");
    lista.append("Descrição: ").append(s.getSessao()).append("\n");
    lista.append("Data: ").append(s.getData()).append("\n");
    lista.append("Status: ").append(s.getStatus()).append("\n\n");

    lista.append("Conselheiros presentes:\n");
    if (s.getConselheirosPresentes().isEmpty()) {
      lista.append("  Nenhum conselheiro presente.\n");
    } else {
      for (Cpf c : s.getConselheirosPresentes()) {
        Pessoa p = BDSimulado.getPessoas().get(c.toString());
        if (p != null) {
          lista.append("  - ").append(p.getNome()).append("\n");
        } else {
          lista.append("  - CPF ").append(c).append(" não encontrado\n");
        }
      }
    }

    lista.append("\nOuvintes presentes:\n");
    if (s.getOuvintesPresentes().isEmpty()) {
      lista.append("  Nenhum ouvinte presente.\n");
    } else {
      for (Cpf c : s.getOuvintesPresentes()) {
        Pessoa p = BDSimulado.getPessoas().get(c.toString());
        if (p != null) {
          lista.append("  - ").append(p.getNome()).append("\n");
        } else {
          lista.append("  - CPF ").append(c).append(" não encontrado\n");
        }
      }
    }

    lista.append("\nPropostas na sessão:\n");
    if (s.getPropostas().isEmpty()) {
      lista.append("  Nenhuma proposta adicionada.\n");
    } else {
      for (Proposta p : s.getPropostas()) {
        lista.append("  - ").append(p.getTitulo()).append("\n");
      }
    }

    return lista.toString();
  }

  public static String registrarVoto(String idSessao, String cpf, int indiceProposta, TipoVoto tipoVoto) {
    Sessao s = BDSimulado.getSessoes().get(idSessao);
    if (s == null) {
      return "Sessão não encontrada.";
    }

    Pessoa p = BDSimulado.getPessoas().get(cpf);
    if (!(p instanceof Votante)) {
      return "Pessoa não tem direito a voto.";
    }

    Votante votante = (Votante) p;

    List<Proposta> propostas = s.getPropostas();
    if (indiceProposta < 0 || indiceProposta >= propostas.size()) {
      return "Proposta inválida.";
    }

    Proposta propostaEscolhida = propostas.get(indiceProposta);

    s.registrarVoto(votante, propostaEscolhida, tipoVoto);
    return "Voto registrado com sucesso.";
  }

  public static String listarVotosPorProposta(String idSessao) {
    Sessao sessao = BDSimulado.getSessoes().get(idSessao);

    if (sessao == null) {
      return "Sessão não encontrada.";
    }

    StringBuilder lista = new StringBuilder();
    lista.append("\nSessão ID: ").append(sessao.getId()).append("\n");
    lista.append("Descrição: ").append(sessao.getSessao()).append("\n");
    lista.append("Data: ").append(sessao.getData()).append("\n");
    lista.append("Status: ").append(sessao.getStatus()).append("\n\n");

    List<Proposta> propostas = sessao.getPropostas();
    List<Voto> votos = sessao.getVotos();

    if (propostas.isEmpty()) {
      return "Não há propostas nesta sessão.";
    }

    for (Proposta proposta : propostas) {
      lista.append("\n📌 Proposta: ").append(proposta.getTitulo()).append("\n");

      int votosSim = 0;
      int votosNao = 0;
      int votosAbstencao = 0;

      for (Voto voto : votos) {
        if (voto.getProposta().equals(proposta)) {
          TipoVoto tipo = voto.getTipoVoto();
          switch (tipo) {
            case SIM -> votosSim++;
            case NAO -> votosNao++;
            case ABSTENCAO -> votosAbstencao++;
          }
        }
      }

      if (votosSim == 0 && votosNao == 0 && votosAbstencao == 0) {
        lista.append("Nenhum voto registrado para essa proposta.\n");
      } else {
        lista.append("✔️ SIM: ").append(votosSim).append("\n");
        lista.append("❌ NÃO: ").append(votosNao).append("\n");
        lista.append("🤷 ABSTENÇÃO: ").append(votosAbstencao).append("\n");
      }
    }

    return lista.toString();
  }

}
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

    return "\n\u2705 Sessão criada com sucesso! ID: " + s.getId();
  }

  public String adicionarConselheirosASessao(String idSessao, Scanner teclado) {
    Sessao s = BDSimulado.getSessoes().get(idSessao);

    if (s == null) {
      return "\n\u274C Sessão não encontrada.";
    }

    // Lista de conselheiros disponíveis para serem adicionados à sessão
    List<Conselheiro> conselheiros = new ArrayList<>();
    for (Pessoa p : BDSimulado.getPessoas().values()) {
      if (p instanceof Conselheiro) {
        conselheiros.add((Conselheiro) p);
      }
    }

    if (conselheiros.isEmpty()) {
      return "\n\u274C Nenhum conselheiro disponível.";
    }

    System.out.println("\nConselheiros disponíveis:");
    for (int i = 0; i < conselheiros.size(); i++) {
      System.out.println("[" + i + "] " + conselheiros.get(i).getNome());
    }

    System.out.print("\nDigite os números dos conselheiros que deseja adicionar (separados por vírgula): ");
    String[] idConselheiros = teclado.nextLine().split(",");

    for (String id : idConselheiros) {
      try {
        // Transformando em inteiro para acessar via índice na lista
        // Remoção de espaços do início e fim
        int i = Integer.parseInt(id.trim());

        s.adicionarConselheiro(((Pessoa) conselheiros.get(i)).getCpf());

      } catch (Exception e) {
        System.out.println("\n\u274C Erro ao adicionar conselheiro com índice: " + id);
      }
    }

    return "\n\u2705 Conselheiros adicionados com sucesso à sessão " + idSessao + "!";
  }

  public String adicionarOuvintesASessao(String idSessao, Scanner teclado) {
    Sessao s = BDSimulado.getSessoes().get(idSessao);

    if (s == null) {
      return "\n\u274C Sessão não encontrada.";
    }

    // Lista de ouvintes disponíveis para serem adicionados à sessão
    List<Ouvinte> ouvintes = new ArrayList<>();
    for (Pessoa p : BDSimulado.getPessoas().values()) {
      if (p instanceof Ouvinte) {
        ouvintes.add((Ouvinte) p);
      }
    }

    if (ouvintes.isEmpty()) {
      return "\n\u274C Nenhum ouvinte disponível.";
    }

    System.out.println("\nOuvintes disponíveis:");
    for (int i = 0; i < ouvintes.size(); i++) {
      System.out.println("[" + i + "] " + ouvintes.get(i).getNome());
    }

    System.out.print("\nDigite os números dos ouvintes que deseja adicionar (separados por vírgula): ");
    String[] idOuvintes = teclado.nextLine().split(",");

    for (String id : idOuvintes) {
      try {
        // Transformando em inteiro para acessar via índice na lista
        // Remoção de espaços do início e fim
        int i = Integer.parseInt(id.trim());

        s.adicionarOuvinte(((Pessoa) ouvintes.get(i)).getCpf());

      } catch (Exception e) {
        System.out.println("\n\u274C Erro ao adicionar ouvinte com índice: " + id);
      }
    }

    return "\n\u2705 Ouvintes adicionados com sucesso à sessão " + idSessao + "!";
  }

  public String adicionarPropostasASessao(String idSessao, Scanner teclado) {
    Sessao s = BDSimulado.getSessoes().get(idSessao);

    if (s == null) {
      return "\n\u274C Sessão não encontrada.";
    }

    List<Proposta> listaPropostas = new ArrayList<>(BDSimulado.getPropostas().values());
    if (listaPropostas.isEmpty()) {
      return "\n\u274C Não há propostas para adicionar.";
    }

    System.out.println("\nPropostas disponíveis:");
    for (int i = 0; i < listaPropostas.size(); i++) {
      System.out.println(i + " - " + listaPropostas.get(i).getTitulo() + " | Segmento Cultural "
          + listaPropostas.get(i).getSegmentoCultural());
    }

    System.out.print("\nInforme os números das propostas que quer adicionar, separados por vírgula: ");
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
          System.out.println("\n\u274C Número inválido (fora do intervalo): " + id);
        }

      } catch (Exception e) {
        System.out.println("\n\u274C Valor inválido ignorado: " + id);
      }
    }

    return "\n\u2705 " + totalPropostasAdicionadas + " proposta(s) adicionada(s) à sessão " + idSessao + ".";
  }

  public String iniciarSessao(String idSessao) {
    Sessao s = BDSimulado.getSessoes().get(idSessao);

    if (s == null) {
      return "\n\u274C Sessão não encontrada.";
    }

    if (s.getStatus() == StatusSessao.ATIVA) {
      return "\n\u274C Sessão já está ativa.";
    } else if (s.getStatus() == StatusSessao.ENCERRADA) {
      return "\n\u274CSessão já foi encerrada e não pode ser reativada.";
    }
    s.iniciar();
    return "\n\u2705 Sessão " + idSessao + " iniciada com sucesso!";
  }

  public String encerrarSessao(String idSessao) {
    Sessao s = BDSimulado.getSessoes().get(idSessao);
    if (s == null) {
      return "\n\u274C Sessão não encontrada.";
    }
    if (s.getStatus() != StatusSessao.ATIVA) {
      return "\n\u274C Só é possível encerrar sessões ativas.";
    }
    s.encerrar();
    return "\n\u2705 Sessão " + idSessao + " encerrada com sucesso!";
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
      return "\n\u274C Sessão não encontrada.";
    }

    StringBuilder lista = new StringBuilder();
    lista.append("\nSessão ID: ").append(s.getId()).append("\n");
    lista.append("Descrição: ").append(s.getSessao()).append("\n");
    lista.append("Data: ").append(s.getData()).append("\n");
    lista.append("Status: ").append(s.getStatus()).append("\n\n");

    lista.append("Conselheiros presentes:\n");
    if (s.getConselheirosPresentes().isEmpty()) {
      lista.append("  \u274C Nenhum conselheiro presente.\n");
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
      lista.append("  \u274C Nenhum ouvinte presente.\n");
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
      lista.append("  \u274C Nenhuma proposta adicionada.\n");
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
      return "\n\u274C Sessão não encontrada.";
    }

    Pessoa p = BDSimulado.getPessoas().get(cpf);
    if (!(p instanceof Votante)) {
      return "\n\u274C Pessoa não tem direito a voto.";
    }

    Votante votante = (Votante) p;

    List<Proposta> propostas = s.getPropostas();
    if (indiceProposta < 0 || indiceProposta >= propostas.size()) {
      return "\n\u274C Proposta inválida.";
    }

    Proposta propostaEscolhida = propostas.get(indiceProposta);

    return s.registrarVoto(votante, propostaEscolhida, tipoVoto);
  }

  public static String listarVotosPorProposta(String idSessao) {
    Sessao s = BDSimulado.getSessoes().get(idSessao);

    if (s == null) {
      return "\n\u274C Sessão não encontrada.";
    }

    StringBuilder lista = new StringBuilder();
    lista.append("\nSessão ID: ").append(s.getId()).append("\n");
    lista.append("Descrição: ").append(s.getSessao()).append("\n");
    lista.append("Data: ").append(s.getData()).append("\n");
    lista.append("Status: ").append(s.getStatus()).append("\n\n");

    List<Proposta> propostas = s.getPropostas();
    List<Voto> votos = s.getVotos();

    if (propostas.isEmpty()) {
      return "\n\u274C Não há propostas nesta sessão.";
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
        lista.append("\u274C Nenhum voto registrado para essa proposta.\n");
      } else {
        lista.append("✔️ SIM: ").append(votosSim).append("\n");
        lista.append("❌ NÃO: ").append(votosNao).append("\n");
        lista.append("🤷 ABSTENÇÃO: ").append(votosAbstencao).append("\n");
      }
    }

    return lista.toString();
  }
}
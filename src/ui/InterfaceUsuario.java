package ui;

import java.util.Scanner;

import model.Sessao;
import repository.BDSimulado;
import service.ServicoProposta;
import service.ServicoPessoa;
import service.ServicoSessao;

public class InterfaceUsuario {
  // Inicialização de atributos da classe InterfaceUsuario
  private ServicoPessoa servicoPessoa;
  private ServicoProposta servicoProposta;
  private ServicoSessao servicoSessao;
  private Scanner teclado;

  // Construtor
  public InterfaceUsuario(ServicoPessoa servicoPessoa, ServicoProposta servicoProposta, ServicoSessao servicoSessao) {
    this.servicoPessoa = servicoPessoa;
    this.servicoProposta = servicoProposta;
    this.servicoSessao = servicoSessao;
    this.teclado = new Scanner(System.in);
  }

  public void exibir() {
    byte opcao;
    do {
      imprimirMenu();
      opcao = Byte.parseByte(teclado.nextLine());

      switch (opcao) {
        case 1:
          cadastrarPessoa("conselheiro");
          break;

        case 2:
          cadastrarPessoa("ouvinte");
          break;

        case 3:
          listarConselheiros();
          break;

        case 4:
          listarOuvintes();
          break;

        case 5:
          listarPessoas();
          break;

        case 6:
          buscarPessoa();
          break;

        case 7:
          removerPessoa();
          break;

        case 8:
          criarNovaProposta();
          break;

        case 9:
          listarPropostas();
          break;

        case 10:
          criarNovaSessao();
          break;

        case 11:
          adicionarConselheiroASessao();
          break;

        case 12:
          adicionarOuvinteASessao();
          break;

        case 13:
          adicionarPropostasASessao();
          break;

        case 14:
          iniciarSessao();
          break;

        case 15:
          encerrarSessao();
          break;

        case 16:
          listarSessoes();
          break;

        case 17:
          consultarStatusSessao();
          break;

        case 18:
          break;

        case 19:
          break;

        case 20:
          break;

        default:
          break;
      }

    } while (opcao != 0);
    teclado.close();
  }

  // Opções 1 e 2
  private void cadastrarPessoa(String tipo) {
    System.out.print("Nome do " + tipo + ": ");
    String nome = teclado.nextLine();
    System.out.print("CPF do " + tipo + ": ");
    String cpf = teclado.nextLine();
    System.out.print("Email do " + tipo + ": ");
    String email = teclado.nextLine();
    System.out.print("Telefone do " + tipo + ": ");
    String telefone = teclado.nextLine();
    System.out.print("PCD? [S/N]: ");
    String pcd = teclado.nextLine();
    System.out.print("Raça: ");
    String raca = teclado.nextLine();
    System.out.print("Renda: ");
    String renda = teclado.nextLine();
    System.out.print("Ocupação Profissional: ");
    String ocupacaoProfissional = teclado.nextLine();
    System.out.print("Atuação Cultural [Patrimônio ou Arte]: ");
    String atuacaoCultural = teclado.nextLine();
    System.out.print("Segmento Cultural [Ex.: Capoeira, Artes Cênicas, Dança etc.]: ");
    String segmentoCultural = teclado.nextLine();
    System.out.print("Grupo Cultural: ");
    String grupoCultural = teclado.nextLine();

    System.out.println(servicoPessoa.cadastrarPessoa(nome, cpf, email, telefone, pcd, raca, renda,
        ocupacaoProfissional, atuacaoCultural, segmentoCultural, grupoCultural, tipo));
  }

  // Opção 3
  private void listarConselheiros() {
    System.out.println(servicoPessoa.listarConselheiros());
  }

  // Opção 4
  private void listarOuvintes() {
    System.out.println(servicoPessoa.listarOuvintes());
  }

  // Opção 5
  private void listarPessoas() {
    System.out.println(servicoPessoa.listarPessoas());
  }

  // Opção 6
  private void buscarPessoa() {
    System.out.print("Digite o CPF da pessoa: ");
    String cpf = teclado.nextLine();
    System.out.println(servicoPessoa.buscarPessoaPorCpf(cpf));
  }

  // Opção 7
  private void removerPessoa() {
    System.out.print("Digite o CPF da pessoa: ");
    String cpf = teclado.nextLine();
    System.out.println(servicoPessoa.removerPessoaPorCpf(cpf));
  }

  // Opção 8
  private void criarNovaProposta() {
    System.out.print("Título da proposta: ");
    String titulo = teclado.nextLine();
    System.out.print("Descrição da proposta: ");
    String descricao = teclado.nextLine();
    System.out.print("Segmento Cultural: ");
    String segmentoCultural = teclado.nextLine();

    System.out.println(servicoProposta.cadastrarProposta(titulo, descricao, segmentoCultural));
  }

  // Opção 9
  public void listarPropostas() {
    System.out.println(servicoProposta.listarPropostas());
  }

  // Opção 10
  private void criarNovaSessao() {
    System.out.print("Título da sessão: ");
    String titulo = teclado.nextLine();
    System.out.print("Data da sessão (DD/MM/AAAA): ");
    String data = teclado.nextLine();

    System.out.println(servicoSessao.cadastrarSessao(titulo, data));
  }

  // Opção 11
  private void adicionarConselheiroASessao() {
    System.out.println("\nSessões disponíveis:");
    for (Sessao s : BDSimulado.getSessoes().values()) {
      System.out.println(s);
    }

    System.out.print("\nDigite o ID da sessão à qual deseja adicionar conselheiros: ");
    String idSessao = teclado.nextLine();
    System.out.println(servicoSessao.adicionarConselheirosASessao(idSessao, teclado));
  }

  // Opção 12
  private void adicionarOuvinteASessao() {
    System.out.println("\nSessões disponíveis:");
    for (Sessao s : BDSimulado.getSessoes().values()) {
      System.out.println(s);
    }

    System.out.print("\nDigite o ID da sessão para adicionar ouvintes: ");
    String idSessao = teclado.nextLine();

    System.out.println(servicoSessao.adicionarOuvintesASessao(idSessao, teclado));
  }

  // Opção 13
  private void adicionarPropostasASessao() {
    System.out.println("\nSessões disponíveis:");
    for (Sessao s : BDSimulado.getSessoes().values()) {
      System.out.println(s);
    }

    System.out.print("\nDigite o ID da sessão para adicionar propostas: ");
    String idSessao = teclado.nextLine();

    System.out.println(servicoSessao.adicionarPropostasASessao(idSessao, teclado));
  }

  // Opção 14
  private void iniciarSessao() {
    System.out.println("\nSessões disponíveis:");
    for (Sessao s : BDSimulado.getSessoes().values()) {
      System.out.println(s);
    }

    System.out.print("Digite o ID da sessão que deseja iniciar: ");
    String idSessao = teclado.nextLine();
    System.out.println(servicoSessao.iniciarSessao(idSessao));
  }

  // Opção 15
  private void encerrarSessao() {
    System.out.println("\nSessões disponíveis:");
    for (Sessao s : BDSimulado.getSessoes().values()) {
      System.out.println(s);
    }

    System.out.print("Digite o ID da sessão que deseja encerrar: ");
    String idSessao = teclado.nextLine();
    System.out.println(servicoSessao.encerrarSessao(idSessao));
  }

  // Opção 16
  public void listarSessoes() {
    System.out.println(servicoSessao.listarSessoes());
  }

  // Opção 17
  public void consultarStatusSessao() {
    System.out.print("Digite o ID da sessão para consultar status: ");
    String idSessao = teclado.nextLine();
    System.out.println(servicoSessao.consultarStatusSessao(idSessao));
  }

  // Opção 18

  // Opção 19

  // Opção 20

  private void imprimirMenu() {
    StringBuilder menu = new StringBuilder();

    menu.append("\n\uD83D\uDC65 Módulo de Pessoas\n");
    menu.append("[1] Cadastrar Conselheiro\n");
    menu.append("[2] Cadastrar Ouvinte\n");
    menu.append("[3] Listar Conselheiros cadastrados\n");
    menu.append("[4] Listar Ouvintes cadastrados\n");
    menu.append("[5] Listar Pessoas cadastradas\n");
    menu.append("[6] Buscar pessoa por CPF\n");
    menu.append("[7] Remover pessoa pelo CPF\n");

    menu.append("\n\uD83D\uDCA1 Módulo de Propostas\n");
    menu.append("[8] Criar nova proposta\n");
    menu.append("[9] Listar todas as propostas\n");

    menu.append("\n\uD83D\uDCC5 Módulo de Sessões\n");
    menu.append("[10] Criar nova sessão de votação\n");
    menu.append("[11] Adicionar conselheiros à sessão\n");
    menu.append("[12] Adicionar ouvintes à sessão\n");
    menu.append("[13] Adicionar propostas à sessão\n");
    menu.append("[14] Iniciar sessão\n");
    menu.append("[15] Encerrar sessão\n");
    menu.append("[16] Listar sessões existentes\n");
    menu.append("[17] Consultar status de uma sessão\n");

    menu.append("\n\uD83D\uDDF3️ Módulo de Votação\n");
    menu.append("[18] Registrar voto\n");
    menu.append("[19] Listar votos por proposta\n");
    menu.append("[20] Exibir resultado da votação\n");

    menu.append("\nEscolha uma opção:");

    System.out.println(menu);
  }
}

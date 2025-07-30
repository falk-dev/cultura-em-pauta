package ui;

import java.util.Scanner;
import service.ServicoProposta;
import service.ServicoPessoa;

public class InterfaceUsuario {
  // Inicialização de atributos da classe InterfaceUsuario
  private ServicoPessoa servicoPessoa;
  private ServicoProposta servicoPropostas;
  private Scanner teclado;

  // Construtor
  public InterfaceUsuario(ServicoPessoa servicoPessoa, ServicoProposta servicoPauta) {
    this.servicoPessoa = servicoPessoa;
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
          novaProposta();
          break;

        case 9:
          break;

        case 10:
          break;

        case 11:
          break;

        case 12:
          break;

        case 13:
          break;

        case 14:
          break;

        case 15:
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
    System.out.print("Coletivo Cultural [Ex.: Patrimônio, Capoeira, Grupo Candeias]: ");
    String coletivoCultural = teclado.nextLine();

    System.out.println(servicoPessoa.cadastrarPessoa(nome, cpf, email, telefone, pcd, raca, renda,
        ocupacaoProfissional, atuacaoCultural, segmentoCultural, coletivoCultural, tipo));
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
  private void novaProposta() {
    System.out.print("Título da proposta: ");
    String titulo = teclado.nextLine();
    System.out.print("Descrição da proposta: ");
    String descricao = teclado.nextLine();
    System.out.print("Segmento Cultural: ");
    String segmentoCultural = teclado.nextLine();

    System.out.println(servicoPropostas.cadastrarProposta(titulo, descricao, segmentoCultural));
  }

  // Opção 9

  // Opção 10

  // Opção 11

  // Opção 12

  // Opção 13

  // Opção 14

  // Opção 15

  // Opção 16

  // Opção 17

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

    menu.append("\n\uD83D\uDDD3️ Módulo de Sessões\n");
    menu.append("[10] Criar nova sessão de votação\n");
    menu.append("[11] Iniciar sessão\n");
    menu.append("[12] Encerrar sessão\n");
    menu.append("[13] Listar sessões existentes\n");
    menu.append("[14] Consultar status de uma sessão\n");

    menu.append("\n\uD83D\uDDF3️ Módulo de Votação\n");
    menu.append("[15] Registrar voto\n");
    menu.append("[16] Listar votos por proposta\n");
    menu.append("[17] Exibir resultado da votação\n");

    menu.append("\nEscolha uma opção:");

    System.out.println(menu);
  }
}

package model.util;

import java.util.Optional;

import model.CarreiraCultural;
import model.Conselheiro;
import model.Ouvinte;
import repository.BDSimulado;

public class DadosMockadosPessoa {
  public static void adicionarDadosMockados() {
    CarreiraCultural carreiraMusica = new CarreiraCultural("Arte", "Música", "Coletivo Som Livre");
    CarreiraCultural carreiraTeatro = new CarreiraCultural("Arte", "Teatro", "Grupo Cena Aberta");
    CarreiraCultural carreiraArtesVisuais = new CarreiraCultural("Arte", "Artes Visuais", "Coletivo Arte Urbana");
    CarreiraCultural carreiraCinema = new CarreiraCultural("Arte", "Cinema", "Cineclube Local");
    CarreiraCultural carreiraDanca = new CarreiraCultural("Arte", "Dança", "Grupo de Dança Raízes");
    CarreiraCultural carreiraCapoeira = new CarreiraCultural("Patrimônio", "Capoeira", "Grupo Candeias");

    // --- OUVINTES ---
    criarEAdicionarOuvinte(
        "Ana Silva",
        "230.975.220-77",
        "ana.silva@email.com",
        "11999990000",
        "N",
        "Parda",
        "2000",
        "Estudante",
        carreiraMusica);

    criarEAdicionarOuvinte(
        "Carlos Souza",
        "420.756.530-20",
        "carlos.souza@email.com",
        "11988887777",
        "S",
        "Branco",
        "3500",
        "Professor",
        carreiraTeatro);

    criarEAdicionarOuvinte(
        "Beatriz Lima",
        "877.668.890-99",
        "beatriz.lima@email.com",
        "11977775555",
        "N",
        "Negra",
        "2800",
        "Designer",
        carreiraArtesVisuais);

    criarEAdicionarOuvinte(
        "Felipe Mendes",
        "229.535.100-60",
        "felipe.mendes@email.com",
        "11966664444",
        "N",
        "Pardo",
        "4200",
        "Engenheiro",
        carreiraMusica);

    criarEAdicionarOuvinte(
        "Juliana Fernandes",
        "065.016.320-64",
        "juliana.fernandes@email.com",
        "11955553333",
        "N",
        "Branca",
        "3500",
        "Jornalista",
        carreiraCinema);

    criarEAdicionarOuvinte(
        "Ricardo Alves",
        "131.781.220-44",
        "ricardo.alves@email.com",
        "11944442222",
        "N",
        "Negro",
        "3000",
        "Professor",
        carreiraDanca);

    criarEAdicionarOuvinte(
        "Lucas Barbosa",
        "734.848.980-03",
        "lucas.barbosa@email.com",
        "11933334444",
        "N",
        "Pardo",
        "2800",
        "Aluno",
        carreiraCapoeira);

    // --- CONSELHEIROS ---
    criarEAdicionarConselheiro(
        "Mariana Costa",
        "979.578.740-37",
        "mariana.costa@email.com",
        "11977776666",
        "N",
        "Negra",
        "4500",
        "Artista Visual",
        carreiraArtesVisuais);

    criarEAdicionarConselheiro(
        "João Pereira",
        "464.197.460-86",
        "joao.pereira@email.com",
        "11966665555",
        "N",
        "Pardo",
        "4000",
        "Músico",
        carreiraMusica);

    criarEAdicionarConselheiro(
        "Fernanda Ribeiro",
        "722.213.330-55",
        "fernanda.ribeiro@email.com",
        "11933331111",
        "S",
        "Parda",
        "5000",
        "Curadora",
        carreiraArtesVisuais);

    criarEAdicionarConselheiro(
        "Ricardo Oliveira",
        "592.763.650-01",
        "ricardo.oliveira@email.com",
        "11922220000",
        "N",
        "Branco",
        "4600",
        "Produtor Cultural",
        carreiraTeatro);

    criarEAdicionarConselheiro(
        "Patrícia Santos",
        "373.070.120-73",
        "patricia.santos@email.com",
        "11911119999",
        "N",
        "Negra",
        "4800",
        "Diretora",
        carreiraCinema);

    criarEAdicionarConselheiro(
        "Leandro Souza",
        "552.371.780-06",
        "leandro.souza@email.com",
        "11900008888",
        "N",
        "Pardo",
        "4300",
        "Músico",
        carreiraMusica);

    criarEAdicionarConselheiro(
        "Mestre Saci",
        "216.369.210-86",
        "mestresaci@email.com",
        "11999991111",
        "N",
        "Negro",
        "5000",
        "Mestre de Capoeira",
        carreiraCapoeira);
  }

  private static void criarEAdicionarOuvinte(String nome, String cpf, String email, String telefone,
      String pcd, String raca, String renda, String ocupacaoProfissional, CarreiraCultural carreira) {
    Optional<Cpf> cpfOpt = Cpf.getInstance(cpf);
    Optional<Email> emailOpt = Email.getInstance(email);
    if (cpfOpt.isEmpty()) {
      System.out.println("CPF inválido para ouvinte: " + nome);
      return;
    }
    if (emailOpt.isEmpty()) {
      System.out.println("Email inválido para ouvinte: " + nome);
      return;
    }
    Ouvinte ouvinte = new Ouvinte(
        nome,
        cpfOpt.get(),
        emailOpt.get(),
        telefone,
        pcd,
        raca,
        renda,
        ocupacaoProfissional,
        carreira);
    BDSimulado.addPessoa(ouvinte);
  }

  private static void criarEAdicionarConselheiro(String nome, String cpf, String email, String telefone,
      String pcd, String raca, String renda,
      String ocupacaoProfissional, CarreiraCultural carreira) {
    Optional<Cpf> cpfOpt = Cpf.getInstance(cpf);
    Optional<Email> emailOpt = Email.getInstance(email);
    if (cpfOpt.isEmpty()) {
      System.out.println("CPF inválido para conselheiro: " + nome);
      return;
    }
    if (emailOpt.isEmpty()) {
      System.out.println("Email inválido para conselheiro: " + nome);
      return;
    }
    Conselheiro conselheiro = new Conselheiro(
        nome,
        cpfOpt.get(),
        emailOpt.get(),
        telefone,
        pcd,
        raca,
        renda,
        ocupacaoProfissional,
        carreira);
    BDSimulado.addPessoa(conselheiro);
  }
}

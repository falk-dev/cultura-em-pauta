package application;

import service.ServicoProposta;
import service.ServicoSessao;
import service.ServicoPessoa;
import ui.InterfaceUsuario;
import model.util.DadosMockadosPessoa;
import model.util.DadosMockadosProposta;
import model.util.DadosMockadosSessao;

public class Main {
  public static void main(String[] args) throws Exception {
    ServicoPessoa servicoPessoa = new ServicoPessoa();
    ServicoProposta servicoProposta = new ServicoProposta();
    ServicoSessao servicoSessao = new ServicoSessao();

    // Populando com informações mockadas de pessoas
    DadosMockadosPessoa.adicionarDadosMockados();
    DadosMockadosProposta.adicionarDadosMockados();
    DadosMockadosSessao.adicionarDadosMockados();

    InterfaceUsuario iu = new InterfaceUsuario(servicoPessoa, servicoProposta, servicoSessao);
    iu.exibir();
  }
}

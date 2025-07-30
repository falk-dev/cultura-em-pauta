package application;

import service.ServicoProposta;
import service.ServicoPessoa;
import ui.InterfaceUsuario;

public class Main {
    public static void main(String[] args) throws Exception {
        ServicoPessoa servicoPessoa = new ServicoPessoa();
        ServicoProposta servicoProposta = new ServicoProposta();

        InterfaceUsuario iu = new InterfaceUsuario(servicoPessoa, servicoProposta);
        iu.exibir();
    }
}

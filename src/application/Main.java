package application;

import service.ServicoProposta;
import service.ServicoPessoa;
import ui.InterfaceUsuario;

public class Main {
    public static void main(String[] args) throws Exception {
        ServicoPessoa servicoPessoa = new ServicoPessoa();
        ServicoProposta servicoPauta = new ServicoProposta();

        InterfaceUsuario iu = new InterfaceUsuario(servicoPessoa, servicoPauta);
        iu.exibir();
    }
}

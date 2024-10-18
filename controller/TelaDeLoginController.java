package controller;
import model.*;
import view.*;

// Classe que atua como controlador na tela de login
public class TelaDeLoginController extends TelaDeLoginView {
    // Método para notificar o usuário com uma mensagem
    public static void notificarUsuario(String textoNotificacao) {
        lblNotificacoes.setText(setHtmlFormat(textoNotificacao)); 
    }

    // Método para iniciar o processo de login
    public static void logarController(String login, String senha) {
        TelaDeLoginModel.logarModel(login, senha); 
    }
}

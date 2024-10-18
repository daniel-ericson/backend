package controller;

import model.TelaDeLoginModel;
import view.TelaDeLoginView;

import java.awt.event.*;

public class TelaDeLoginController {

    private final TelaDeLoginView view;
    private final TelaDeLoginModel model;

    public TelaDeLoginController(TelaDeLoginView view, TelaDeLoginModel model) {
        this.view = view;
        this.model = model;

        // Adiciona o ActionListener ao botão "Entrar"
        view.getBtnEntrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                autenticarUsuario();
            }
        });
    }

    private void autenticarUsuario() {
        String login = view.getLogin();
        String senha = view.getSenha();

        if (model.verificarLogin(login, senha)) {
            view.setNotificacoes("Conectado com sucesso!!!");
        } else {
            view.setNotificacoes("Login e/ou senha não encontrados! Por favor, tente novamente.");
        }
    }
}

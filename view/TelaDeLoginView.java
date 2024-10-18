package view;

import javax.swing.*;
import java.awt.*;

public class TelaDeLoginView extends JFrame {

    private final JLabel lblLogin;
    private final JTextField txtLogin;
    private final JLabel lblSenha;
    private final JPasswordField txtSenha;
    private final JButton btnEntrar;
    private final JLabel lblNotificacoes;

    public TelaDeLoginView() {
        super("Tela de Login");
        setLayout(new FlowLayout());

        lblLogin = new JLabel("Login:");
        add(lblLogin);

        txtLogin = new JTextField(10);
        add(txtLogin);

        lblSenha = new JLabel("Senha:");
        add(lblSenha);

        txtSenha = new JPasswordField(10);
        add(txtSenha);

        btnEntrar = new JButton("Entrar");
        add(btnEntrar);

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);
        add(lblNotificacoes);

        setSize(150, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public String getLogin() {
        return txtLogin.getText();
    }

    public String getSenha() {
        return String.valueOf(txtSenha.getPassword());
    }

    public JButton getBtnEntrar() {
        return btnEntrar;
    }

    public void setNotificacoes(String mensagem) {
        lblNotificacoes.setText("<html><body>" + mensagem + "</body></html>");
    } 
    
    public static TelaDeLoginView appTelaDeLoginView;
    public static void main(String[] args) {
    appTelaDeLoginView = new TelaDeLoginView(); 
    appTelaDeLoginView.setDefaultCloseOperation(EXIT_ON_CLOSE); 
    }
}


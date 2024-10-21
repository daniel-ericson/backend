package view;
import controller.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Classe que representa a tela de login
public class TelaDeLoginView extends JFrame
{
    private final JLabel lblLogin;
    public final JTextField txtLogin;

    private final JLabel lblSenha;
    public final JPasswordField txtSenha;

    private final JButton btnEntrar;

    public static JLabel lblNotificacoes;

     // Construtor da classe
    public TelaDeLoginView()
    {
        super("Tela de Login");
        setLayout(new GridLayout(6,1,5,5));

        // Inicializa e adiciona os componentes
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

        // Adiciona o ActionListener ao botão "Entrar"
        btnEntrar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    // Chama o método de login do controlador
                    TelaDeLoginController.logarController(txtLogin.getText(), String.valueOf(txtSenha.getPassword()));
                }
            }
        );

        btnEntrar.addKeyListener(
            new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent event) {
                    if (event.getKeyCode() == 10 && validarCampos() == true) {
                        TelaDeLoginController.logarController(txtLogin.getText(), String.valueOf(txtSenha.getPassword()));
                    }
                }
            }
        );

        txtSenha.addKeyListener(
            new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent event) {
                    if (event.getKeyCode() == 10 && validarCampos() == true) {
                        TelaDeLoginController.logarController(txtLogin.getText(), String.valueOf(txtSenha.getPassword()));
                    }
                }
            }
        );

        txtLogin.addKeyListener(
            new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent event) {
                    if (event.getKeyCode() == 10 && validarCampos() == true) {
                        TelaDeLoginController.logarController(txtLogin.getText(), String.valueOf(txtSenha.getPassword()));
                    }
                }
            }
        );

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(150, 600);
        setVisible(true);
    }

    public boolean validarCampos() {
        if (txtLogin.getText().trim().length() == 0) {
            TelaDeLoginController.notificarUsuario("Ops! É necessário digitar um login válido para continuar. Por favor, digite um login e tecle: \"Enter\".");
            txtLogin.requestFocus();
            return false;
        }
        if (String.valueOf(txtSenha.getPassword()).trim().length() == 0) {
            TelaDeLoginController.notificarUsuario("Ops! É necessário digitar uma senha válida para continuar. Por favor, digite uma senha e tecle: \"Enter\".");
            txtSenha.requestFocus();
            return false;
        }
        return true;
    }

    // Formata uma string em HTML
    public static String setHtmlFormat(String strTexto) {
        return "<html><body><center>" + strTexto + "</center></body></html>";
    }

    // Instância da tela de login
    public static TelaDeLoginView appTelaDeLoginView;
    // Método principal para executar a aplicação
    public static void main(String[] args) {
        appTelaDeLoginView = new TelaDeLoginView();
    }
}
package view; // Define o pacote da classe

import controller.*; // Importa todas as classes do pacote controller

import java.awt.*; // Importa classes da biblioteca AWT para manipulação de interfaces gráficas
import java.awt.event.*; // Importa classes para manipulação de eventos de interface
import javax.swing.*; // Importa classes da biblioteca Swing para criação de interfaces gráficas

// Definição da classe TelaDePesquisaView, que herda de JFrame (janela gráfica)
public class TelaDePesquisaView extends JFrame {

    // Declaração de componentes visuais estáticos para a tela
    public static JLabel lblPesquisa; // Rótulo para o campo de pesquisa
    public static JTextField txtPesquisa; // Campo de texto para entrada de pesquisa

    public static JLabel lblId; // Rótulo para o campo de ID
    public static JTextField txtId; // Campo de texto para exibir o ID

    public static JLabel lblNome; // Rótulo para o campo de Nome
    public static JTextField txtNome; // Campo de texto para exibir o Nome

    public static JLabel lblEmail; // Rótulo para o campo de Email
    public static JTextField txtEmail; // Campo de texto para exibir o Email

    public static JButton btnPesquisar; // Botão para acionar a pesquisa
    public static JButton btnPrimeiro; // Botão para navegar para o primeiro registro
    public static JButton btnAnterior; // Botão para navegar para o registro anterior
    public static JButton btnProximo; // Botão para navegar para o próximo registro
    public static JButton btnUltimo; // Botão para navegar para o último registro

    public static JLabel lblNotificacoes; // Rótulo para exibir notificações ao usuário

    // Variáveis estáticas adicionais
    public static int tamanhoInputs = 20; // Tamanho padrão dos campos de texto
    public static String txtUsuario = ""; // Armazena temporariamente o texto de pesquisa do usuário

    // Construtor da classe TelaDePesquisaView
    public TelaDePesquisaView() {
        super("Tela de Pesquisa"); // Define o título da janela
        setLayout(new GridLayout(7, 1, 5, 5)); // Configura o layout da janela (7 linhas, 1 coluna, espaçamento de 5px)

        // Linha para o rótulo de pesquisa e o botão de pesquisa
        JPanel linha_lblPesquisa = new JPanel(new GridLayout(1, 2));

        lblPesquisa = new JLabel("Pesquisa:", SwingConstants.CENTER); // Cria o rótulo de pesquisa centralizado
        linha_lblPesquisa.add(lblPesquisa); // Adiciona o rótulo à linha

        btnPesquisar = new JButton("🔍"); // Cria o botão de pesquisa com ícone
        btnPesquisar.setToolTipText("Pesquisar"); // Define a dica quando o mouse passa sobre o botão
        btnPesquisar.setEnabled(false); // Inicialmente, o botão está desabilitado
        linha_lblPesquisa.add(btnPesquisar); // Adiciona o botão à linha

        add(linha_lblPesquisa); // Adiciona a linha ao layout principal da janela

        // Linha para o campo de texto de pesquisa
        JPanel linha_inputPesquisa = new JPanel(new GridLayout(1, 1));
        txtPesquisa = new JTextField(tamanhoInputs); // Cria o campo de texto com o tamanho padrão
        linha_inputPesquisa.add(txtPesquisa); // Adiciona o campo à linha
        add(linha_inputPesquisa); // Adiciona a linha ao layout principal

        // Linha para o rótulo e campo de ID
        JPanel linha_id = new JPanel(new GridLayout(1, 2));
        lblId = new JLabel("Id:", SwingConstants.RIGHT); // Rótulo de ID alinhado à direita
        linha_id.add(lblId); // Adiciona o rótulo à linha
        txtId = new JTextField(tamanhoInputs); // Campo de texto de ID
        txtId.setEnabled(false); // Campo de ID desabilitado (somente leitura)
        linha_id.add(txtId); // Adiciona o campo à linha
        add(linha_id); // Adiciona a linha ao layout principal

        // Linha para o rótulo e campo de Nome
        JPanel linha_nome = new JPanel(new GridLayout(1, 2));
        lblNome = new JLabel("Nome:", SwingConstants.RIGHT); // Rótulo de Nome alinhado à direita
        linha_nome.add(lblNome); // Adiciona o rótulo à linha
        txtNome = new JTextField(tamanhoInputs); // Campo de texto de Nome
        txtNome.setEditable(false); // Campo de Nome não editável (somente leitura)
        linha_nome.add(txtNome); // Adiciona o campo à linha
        add(linha_nome); // Adiciona a linha ao layout principal

        // Linha para o rótulo e campo de Email
        JPanel linha_email = new JPanel(new GridLayout(1, 2));
        lblEmail = new JLabel("Email:", SwingConstants.RIGHT); // Rótulo de Email alinhado à direita
        linha_email.add(lblEmail); // Adiciona o rótulo à linha
        txtEmail = new JTextField(10); // Campo de texto de Email com tamanho 10
        txtEmail.setEditable(false); // Campo de Email não editável (somente leitura)
        linha_email.add(txtEmail); // Adiciona o campo à linha
        add(linha_email); // Adiciona a linha ao layout principal

        // Linha para os botões de navegação de registros
        JPanel linha_botoes = new JPanel(new GridLayout(1, 4));
        btnPrimeiro = new JButton("<<"); // Botão de primeiro registro
        btnPrimeiro.setEnabled(false); // Inicialmente desabilitado
        linha_botoes.add(btnPrimeiro); // Adiciona o botão à linha
        btnAnterior = new JButton("<"); // Botão de registro anterior
        btnAnterior.setEnabled(false); // Inicialmente desabilitado
        linha_botoes.add(btnAnterior); // Adiciona o botão à linha
        btnProximo = new JButton(">"); // Botão de próximo registro
        btnProximo.setEnabled(false); // Inicialmente desabilitado
        linha_botoes.add(btnProximo); // Adiciona o botão à linha
        btnUltimo = new JButton(">>"); // Botão de último registro
        btnUltimo.setEnabled(false); // Inicialmente desabilitado
        linha_botoes.add(btnUltimo); // Adiciona o botão à linha
        add(linha_botoes); // Adiciona a linha ao layout principal

        // Linha para exibir notificações
        JPanel linha_notificacoes = new JPanel(new GridLayout(1, 1));
        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER); // Rótulo de notificações centralizado
        linha_notificacoes.add(lblNotificacoes); // Adiciona o rótulo à linha
        add(linha_notificacoes); // Adiciona a linha ao layout principal

        // Adiciona eventos de clique para os botões de navegação
        btnPesquisar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (txtPesquisa.getText().trim().length() <= 0) { // Verifica se o campo está vazio
                        lblNotificacoes.setText(setHtmlFormat("Por favor, digite algo e tente novamente."));
                        txtPesquisa.requestFocus();
                        return;
                    } else {
                        TelaDePesquisaController.pesquisar(); // Aciona o método pesquisar do controller
                    }
                }
            }
        );

        // Evento para o botão de primeiro registro
        btnPrimeiro.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (!ntfCampoVazio()) {
                        TelaDePesquisaController.primeiroRegistro();
                    }
                }
            }
        );

        // Evento para o botão de registro anterior
        btnAnterior.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (!ntfCampoVazio()) {
                        TelaDePesquisaController.registroAnterior();
                    }
                }
            }
        );

        // Evento para o botão de próximo registro
        btnProximo.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (!ntfCampoVazio()) {
                        TelaDePesquisaController.proximoRegistro();
                    }
                }
            }
        );

        // Evento para o botão de último registro
        btnUltimo.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (!ntfCampoVazio()) {
                        TelaDePesquisaController.ultimoRegistro();
                    }
                }
            }
        );

        // Evento de tecla para o campo de pesquisa
        txtPesquisa.addKeyListener(
            new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    if (!txtPesquisa.getText().trim().equals(txtUsuario) && txtPesquisa.getText().trim().length() > 0) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            TelaDePesquisaController.pesquisar(); // Aciona a pesquisa ao pressionar Enter
                        }
                    } else {
                        limparCampos("Digite algo para continuar.");
                    }
                    btnPesquisar.setEnabled(true);
                }
            }
        );

        // Configurações finais da janela
        setSize(250, 300); // Define o tamanho da janela
        ImageIcon img = new ImageIcon("./senac-logo.png"); // Define o ícone da janela
        setIconImage(img.getImage());
        setVisible(true); // Torna a janela visível
        txtPesquisa.requestFocus(); // Define o foco inicial no campo de pesquisa
    }

    // Método para verificar se o campo de pesquisa está vazio
    public static boolean ntfCampoVazio() {
        if (txtPesquisa.getText().trim().length() <= 0) {
            lblNotificacoes.setText(setHtmlFormat("Ops! Campo vazio. Por favor, digite algo e tente novamente."));
            txtPesquisa.requestFocus();
            return true;
        }
        return false;
    }

    // Método para limpar os campos de texto
    public static void limparCampos(String notificacao) {
        btnPesquisar.setEnabled(false);
        txtId.setText("");
        txtNome.setText("");
        txtEmail.setText("");
        btnPrimeiro.setEnabled(false);
        btnAnterior.setEnabled(false);
        btnProximo.setEnabled(false);
        btnUltimo.setEnabled(false);
        if (notificacao.trim().length() > 0) {
            lblNotificacoes.setText(setHtmlFormat(notificacao));
        }
    }

    // Formatação de texto HTML para notificações
    public static String setHtmlFormat(String strTexto) {
        return "<html><body>" + strTexto + "</body></html>";
    }

    // Método principal para inicializar a janela
    public static TelaDePesquisaView appTelaDePesquisaView;
    public static void main(String[] args) {
        appTelaDePesquisaView = new TelaDePesquisaView();
        appTelaDePesquisaView.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

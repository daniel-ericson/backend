package controller; // Define o pacote 'controller' onde a classe será organizada.
import model.*; // Importa todas as classes do pacote 'model'.
import view.*; // Importa todas as classes do pacote 'view'.

// A classe 'TelaDePesquisaController' controla a tela de pesquisa e suas interações. Ela herda da 'TelaDePesquisaView'.
public class TelaDePesquisaController extends TelaDePesquisaView {
    
    // Método para notificar o usuário com uma mensagem. Define o texto no label 'lblNotificacoes'.
    public static void notificarUsuario(String textoNotificacao) {
        lblNotificacoes.setText(setHtmlFormat(textoNotificacao)); // Formata o texto e o define no label.
    }

    // Método para preencher os campos de texto da interface (ID, Nome, Email) com os dados fornecidos.
    public static void preencherCampos(String id, String nome, String email) {
        txtId.setText(id); // Preenche o campo 'txtId' com o valor de 'id'.
        txtNome.setText(nome); // Preenche o campo 'txtNome' com o valor de 'nome'.
        txtEmail.setText(email); // Preenche o campo 'txtEmail' com o valor de 'email'.
    }

    // Método para registrar o texto do campo de pesquisa em uma variável para futuras comparações.
    public static void registrarPesquisa() {
        txtUsuario = txtPesquisa.getText(); // Armazena o texto do campo 'txtPesquisa' na variável 'txtUsuario'.
    }

    // Método para realizar a pesquisa. Limpa os campos se o texto pesquisado for diferente do registrado.
    public static void pesquisar() {
        if (txtPesquisa.getText().trim().equals(txtUsuario) == false) { // Verifica se a pesquisa atual é diferente da registrada.
            limparCampos(""); // Se for diferente, chama o método 'limparCampos' para limpar os campos.
        }
    }

    // Método para ir ao primeiro registro. Exibe uma notificação e aciona o método correspondente no modelo.
    public static void primeiroRegistro() {
        limparCampos("Você está no primeiro registro."); // Limpa os campos e exibe uma mensagem.
        TelaDePesquisaModel.primeiroRegistroModel(txtPesquisa.getText()); // Chama o método no modelo para buscar o primeiro registro.
    }

    // Método para ir ao registro anterior. Exibe uma notificação e aciona o método correspondente no modelo.
    public static void registroAnterior() {
        limparCampos("Registro anterior posicionado com sucesso."); // Limpa os campos e exibe uma mensagem.
        TelaDePesquisaModel.registroAnteriorModel(txtPesquisa.getText(), txtId.getText(), txtNome.getText(), txtEmail.getText()); 
        // Chama o método no modelo, passando os valores atuais de pesquisa, ID, nome e e-mail.
    }

    // Método para ir ao próximo registro. Exibe uma notificação e aciona o método correspondente no modelo.
    public static void proximoRegistro() {
        limparCampos("Próximo registro posicionado com sucesso."); // Limpa os campos e exibe uma mensagem.
        TelaDePesquisaModel.proximoRegistroModel(txtPesquisa.getText(), txtId.getText(), txtNome.getText(), txtEmail.getText()); 
        // Chama o método no modelo, passando os valores atuais de pesquisa, ID, nome e e-mail.
    }

    // Método para ir ao último registro. Limpa os campos e aciona o método correspondente no modelo.
    public static void ultimoRegistro() {
        limparCampos(""); // Limpa os campos sem exibir mensagem.
        TelaDePesquisaModel.ultimoRegistroModel(txtPesquisa.getText(), txtId.getText(), txtNome.getText(), txtEmail.getText()); 
        // Chama o método no modelo, passando os valores atuais de pesquisa, ID, nome e e-mail.
    }

    // Método para desabilitar todos os botões de navegação (Primeiro, Anterior, Próximo, Último).
    public static void desabilitarTodos() {
        btnPrimeiro.setEnabled(false); // Desabilita o botão 'Primeiro'.
        btnAnterior.setEnabled(false); // Desabilita o botão 'Anterior'.
        btnProximo.setEnabled(false); // Desabilita o botão 'Próximo'.
        btnUltimo.setEnabled(false); // Desabilita o botão 'Último'.
    }

    // Método para habilitar os botões de navegação para voltar (Primeiro e Anterior).
    public static void habilitarVoltar() {
        desabilitarTodos(); // Primeiro, desabilita todos os botões.
        btnPrimeiro.setEnabled(true); // Habilita o botão 'Primeiro'.
        btnAnterior.setEnabled(true); // Habilita o botão 'Anterior'.
    }

    // Método para habilitar todos os botões de navegação (Primeiro, Anterior, Próximo, Último).
    public static void habilitarTodos() {
        btnPrimeiro.setEnabled(true); // Habilita o botão 'Primeiro'.
        btnAnterior.setEnabled(true); // Habilita o botão 'Anterior'.
        btnProximo.setEnabled(true); // Habilita o botão 'Próximo'.
        btnUltimo.setEnabled(true); // Habilita o botão 'Último'.
    }

    // Método para habilitar os botões de navegação para avançar (Próximo e Último).
    public static void habilitarAvancar() {
        desabilitarTodos(); // Primeiro, desabilita todos os botões.
        btnProximo.setEnabled(true); // Habilita o botão 'Próximo'.
        btnUltimo.setEnabled(true); // Habilita o botão 'Último'.
    }

    // Método para desabilitar o botão de pesquisa.
    public static void desabilitarPesquisar() {
        btnPesquisar.setEnabled(false); // Desabilita o botão 'Pesquisar'.
    }
}

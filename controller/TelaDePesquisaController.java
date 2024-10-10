package controller; // Define o pacote 'controller' onde a classe está localizada.
import model.*; // Importa todas as classes do pacote 'model'.
import view.*; // Importa todas as classes do pacote 'view'.

// Classe que controla a lógica da tela de pesquisa, estendendo a visualização correspondente.
public class TelaDePesquisaController extends TelaDePesquisaView {
    
    // Método para notificar o usuário com uma mensagem formatada.
    public static void notificarUsuario(String textoNotificacao) {
        lblNotificacoes.setText(setHtmlFormat(textoNotificacao)); // Atualiza o rótulo de notificações.
    }

    // Método para preencher os campos de entrada com os dados de um registro específico.
    public static void preencherCampos(String id, String nome, String email) {
        txtId.setText(id); // Preenche o campo de ID.
        txtNome.setText(nome); // Preenche o campo de nome.
        txtEmail.setText(email); // Preenche o campo de email.
    }

    // Método para registrar o texto da pesquisa atual.
    public static void registrarPesquisa() {
        txtUsuario = txtPesquisa.getText(); // Armazena o texto da pesquisa atual.
    }

    // Método para realizar a pesquisa e atualizar a interface se o texto mudou.
    public static void pesquisar() {
        String textoPesquisa = txtPesquisa.getText().trim(); // Obtém o texto da pesquisa, removendo espaços em branco.
        if (!textoPesquisa.equals(txtUsuario)) { // Verifica se o texto de pesquisa é diferente do anterior.
            limparCampos(""); // Limpa os campos de entrada.
            TelaDePesquisaModel.pesquisarModel(textoPesquisa); // Chama o modelo para realizar a pesquisa.
        }
    }

    // Método para buscar o primeiro registro.
    public static void primeiroRegistro() {
        TelaDePesquisaModel.primeiroRegistroModel(txtPesquisa.getText()); // Invoca o modelo para buscar o primeiro registro.
    }

    // Método para buscar o registro anterior ao atual.
    public static void registroAnterior() {
        TelaDePesquisaModel.registroAnteriorModel(txtPesquisa.getText(), txtId.getText(), txtNome.getText(), txtEmail.getText()); // Chama o modelo para buscar o registro anterior.
    }

    // Método para buscar o próximo registro após o atual.
    public static void proximoRegistro() {
        TelaDePesquisaModel.proximoRegistroModel(txtPesquisa.getText(), txtId.getText(), txtNome.getText(), txtEmail.getText()); // Chama o modelo para buscar o próximo registro.
    }

    // Método para buscar o último registro.
    public static void ultimoRegistro() {
        TelaDePesquisaModel.ultimoRegistroModel(txtPesquisa.getText(), txtId.getText(), txtNome.getText(), txtEmail.getText()); // Chama o modelo para buscar o último registro.
    }

    // Método para limpar os campos da tela de pesquisa.
    public static void limparCamposController(String txt) {
        limparCampos(txt); // Chama o método para limpar os campos na visualização.
    }

    // Método para desabilitar todos os botões de navegação.
    public static void desabilitarTodos() {
        btnPrimeiro.setEnabled(false); // Desabilita o botão para o primeiro registro.
        btnAnterior.setEnabled(false); // Desabilita o botão para o registro anterior.
        btnProximo.setEnabled(false); // Desabilita o botão para o próximo registro.
        btnUltimo.setEnabled(false); // Desabilita o botão para o último registro.
    }

    // Método para habilitar os botões de navegação que permitem voltar.
    public static void habilitarVoltar() {
        desabilitarTodos(); // Desabilita todos os botões.
        btnPrimeiro.setEnabled(true); // Habilita o botão para o primeiro registro.
        btnAnterior.setEnabled(true); // Habilita o botão para o registro anterior.
    }

    // Método para habilitar todos os botões de navegação.
    public static void habilitarTodos() {
        btnPrimeiro.setEnabled(true); // Habilita o botão para o primeiro registro.
        btnAnterior.setEnabled(true); // Habilita o botão para o registro anterior.
        btnProximo.setEnabled(true); // Habilita o botão para o próximo registro.
        btnUltimo.setEnabled(true); // Habilita o botão para o último registro.
    }

    // Método para habilitar os botões de navegação que permitem avançar.
    public static void habilitarAvancar() {
        desabilitarTodos(); // Desabilita todos os botões.
        btnProximo.setEnabled(true); // Habilita o botão para o próximo registro.
        btnUltimo.setEnabled(true); // Habilita o botão para o último registro.
    }

    // Método para desabilitar o botão de pesquisa.
    public static void desabilitarPesquisar() {
        btnPesquisar.setEnabled(false); // Desabilita o botão de pesquisa.
    }
}

package model; // Define o pacote 'model' onde a classe está localizada.
import java.sql.*; // Importa todas as classes do pacote 'java.sql'.
import controller.*; // Importa todas as classes do pacote 'controller'.

// Classe que contém a lógica de pesquisa para a tela de pesquisa.
public class TelaDePesquisaModel {

    // Método que realiza a pesquisa no banco de dados com base no texto fornecido.
    public static void pesquisarModel(String textoPesquisa) {
        try {
            Connection conexao = MySQLConnector.conectar(); // Conecta ao banco de dados.
            String strSqlPesquisa = "SELECT * FROM `db_senac`.`tbl_senac` WHERE `nome` LIKE '%" + textoPesquisa + "%' OR `email` LIKE '%" + textoPesquisa + "%' ORDER BY `id` ASC;";
            Statement stmSqlPesquisa = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlPesquisa = stmSqlPesquisa.executeQuery(strSqlPesquisa);
            
            if (rstSqlPesquisa.next()) {
                rstSqlPesquisa.last(); // Move para o último registro.
                int rowNumbers = rstSqlPesquisa.getRow(); // Conta o número de registros.
                rstSqlPesquisa.first(); // Retorna ao primeiro registro.

                TelaDePesquisaController.notificarUsuario("Legal! Foi(Foram) encontrado(s) " + rowNumbers + " resultado(s).");
                TelaDePesquisaController.preencherCampos(rstSqlPesquisa.getString("id"), rstSqlPesquisa.getString("nome"), rstSqlPesquisa.getString("email"));
                TelaDePesquisaController.registrarPesquisa();
                TelaDePesquisaController.desabilitarPesquisar();

                if (rowNumbers > 1) {
                    TelaDePesquisaController.habilitarAvancar(); // Habilita navegação se houver mais de um registro.
                }
                stmSqlPesquisa.close();
            } else {
                TelaDePesquisaController.registrarPesquisa();
                TelaDePesquisaController.desabilitarPesquisar();
                TelaDePesquisaController.notificarUsuario("Poxa vida! Não foram encontrados resultados para: \"" + textoPesquisa + "\".");
                stmSqlPesquisa.close();
            }
        } catch (Exception e) {
            System.err.println("Erro: " + e); // Log de erro no console.
            TelaDePesquisaController.notificarUsuario("Não foi possível prosseguir com a pesquisa! Por favor, verifique e tente novamente.");
        }
    }

    // Método para buscar o primeiro registro correspondente à pesquisa.
    public static void primeiroRegistroModel(String textoPesquisa) {
        try {
            TelaDePesquisaController.limparCamposController("Você está no primeiro registro.");
            Connection conexao = MySQLConnector.conectar();
            String strSqlPesquisa = "SELECT * FROM `db_senac`.`tbl_senac` WHERE `nome` LIKE '%" + textoPesquisa + "%' OR `email` LIKE '%" + textoPesquisa + "%' ORDER BY `id` ASC;";
            Statement stmSqlPesquisa = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlPesquisa = stmSqlPesquisa.executeQuery(strSqlPesquisa);

            if (rstSqlPesquisa.next()) {
                TelaDePesquisaController.preencherCampos(rstSqlPesquisa.getString("id"), rstSqlPesquisa.getString("nome"), rstSqlPesquisa.getString("email"));
                TelaDePesquisaController.habilitarAvancar();
            } else {
                TelaDePesquisaController.notificarUsuario("Poxa vida! Não foram encontrados resultados para: \"" + textoPesquisa + "\".");
            }
            TelaDePesquisaController.registrarPesquisa();
            TelaDePesquisaController.desabilitarPesquisar();
            stmSqlPesquisa.close();
        } catch (Exception e) {
            TelaDePesquisaController.notificarUsuario("Não foi possível prosseguir com a pesquisa! Por favor, verifique e tente novamente.");
            System.err.println("Erro: " + e);
        }
    }

    // Método para buscar o registro anterior ao atual.
    public static void registroAnteriorModel(String textoPesquisa, String idAtual, String nomeAtual, String emailAtual) {
        try {
            TelaDePesquisaController.limparCamposController("Registro anterior posicionado com sucesso.");
            Connection conexao = MySQLConnector.conectar();
            String strSqlProximoRegistro = "SELECT * FROM `db_senac`.`tbl_senac` WHERE (`nome` LIKE '%" + textoPesquisa + "%' OR `email` LIKE '%" + textoPesquisa + "%') AND `id` < " + idAtual + " ORDER BY `id` DESC;";
            Statement stmSqlProximoRegistro = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlProximoRegistro = stmSqlProximoRegistro.executeQuery(strSqlProximoRegistro);

            if (rstSqlProximoRegistro.next()) {
                TelaDePesquisaController.preencherCampos(rstSqlProximoRegistro.getString("id"), rstSqlProximoRegistro.getString("nome"), rstSqlProximoRegistro.getString("email"));
                TelaDePesquisaController.habilitarTodos();
            } else {
                TelaDePesquisaController.preencherCampos(idAtual, nomeAtual, emailAtual);
                TelaDePesquisaController.habilitarAvancar();
                TelaDePesquisaController.notificarUsuario("Você chegou ao primeiro registro.");
            }
            stmSqlProximoRegistro.close();
        } catch (Exception e) {
            TelaDePesquisaController.notificarUsuario("Não foi possível encontrar o próximo registro! Por favor, verifique e tente novamente.");
            System.err.println("Erro: " + e);
        }
    }

    // Método para buscar o próximo registro após o atual.
    public static void proximoRegistroModel(String textoPesquisa, String idAtual, String nomeAtual, String emailAtual) {
        try {
            TelaDePesquisaController.limparCamposController("Próximo registro posicionado com sucesso.");
            Connection conexao = MySQLConnector.conectar();
            String strSqlProximoRegistro = "SELECT * FROM `db_senac`.`tbl_senac` WHERE (`nome` LIKE '%" + textoPesquisa + "%' OR `email` LIKE '%" + textoPesquisa + "%') AND `id` > " + idAtual + " ORDER BY `id` ASC;";
            Statement stmSqlProximoRegistro = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlProximoRegistro = stmSqlProximoRegistro.executeQuery(strSqlProximoRegistro);

            if (rstSqlProximoRegistro.next()) {
                TelaDePesquisaController.preencherCampos(rstSqlProximoRegistro.getString("id"), rstSqlProximoRegistro.getString("nome"), rstSqlProximoRegistro.getString("email"));
                TelaDePesquisaController.habilitarTodos();
            } else {
                TelaDePesquisaController.preencherCampos(idAtual, nomeAtual, emailAtual);
                TelaDePesquisaController.habilitarVoltar();
                TelaDePesquisaController.notificarUsuario("Você chegou ao último registro.");
            }
            stmSqlProximoRegistro.close();
        } catch (Exception e) {
            TelaDePesquisaController.notificarUsuario("Não foi possível encontrar o próximo registro! Por favor, verifique e tente novamente.");
            System.err.println("Erro: " + e);
        }
    }

    // Método para buscar o último registro correspondente à pesquisa.
    public static void ultimoRegistroModel(String textoPesquisa, String idAtual, String nomeAtual, String emailAtual) {
        try {
            TelaDePesquisaController.limparCamposController("");
            Connection conexao = MySQLConnector.conectar();
            String strSqlProximoRegistro = "SELECT * FROM `db_senac`.`tbl_senac` WHERE `nome` LIKE '%" + textoPesquisa + "%' OR `email` LIKE '%" + textoPesquisa + "%' ORDER BY `id` DESC;";
            Statement stmSqlProximoRegistro = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlProximoRegistro = stmSqlProximoRegistro.executeQuery(strSqlProximoRegistro);

            if (rstSqlProximoRegistro.next()) {
                TelaDePesquisaController.preencherCampos(rstSqlProximoRegistro.getString("id"), rstSqlProximoRegistro.getString("nome"), rstSqlProximoRegistro.getString("email"));
                TelaDePesquisaController.habilitarVoltar();
                TelaDePesquisaController.notificarUsuario("Você chegou ao último registro.");
            } else {
                TelaDePesquisaController.preencherCampos(idAtual, nomeAtual, emailAtual);
                TelaDePesquisaController.habilitarVoltar();
                TelaDePesquisaController.notificarUsuario("Você chegou ao último registro.");
            }
            stmSqlProximoRegistro.close();
        } catch (Exception e) {
            TelaDePesquisaController.notificarUsuario("Não foi possível encontrar o último registro! Por favor, verifique e tente novamente.");
            System.err.println("Erro: " + e);
        }
    }
}

package model;
import java.sql.*;
import controller.*;

// Classe responsável pela lógica de autenticação
public class TelaDeLoginModel {
    // Método para verificar login e senha
    public static void logarModel(String login, String senha) {
        try {
            // Estabelece conexão com o banco de dados
            Connection conexao = MySQLConnector.conectar(); 
            String strSqlLogin = "select * from `db_senac`.`tbl_senac` where `email` = '" + login + "' and `senha` = '" + senha + "';";
            Statement stmSqlLogin = conexao.createStatement(); 
            ResultSet rstSqlLogin = stmSqlLogin.executeQuery(strSqlLogin); 
            
            // Verifica se o login foi bem-sucedido
            if (rstSqlLogin.next()) {
                TelaDeLoginController.notificarUsuario("Conectado com sucesso!!!");
            } else {
                TelaDeLoginController.notificarUsuario("Login e/ou senha não encontrado! Por favor, verifique e tente novamente."); 
            }
            stmSqlLogin.close();
        } catch (Exception e) {
            // Notifica sobre erro de conexão ou consulta
            TelaDeLoginController.notificarUsuario("Houve um problema e não será possível realizar o login agora. Por favor, tente novamente mais tarde.");
            System.err.println("Veja o erro: " + e); 
        }
    }
}

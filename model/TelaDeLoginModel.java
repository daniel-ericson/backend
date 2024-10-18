package model;

import java.sql.*;

public class TelaDeLoginModel {

    public boolean verificarLogin(String login, String senha) {
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlLogin = "select * from `db_senac`.`tbl_senac` where `email` = '" + login + "' and `senha` = '" + senha + "'";
            Statement stmSqlLogin = conexao.createStatement();
            ResultSet rstSqlLogin = stmSqlLogin.executeQuery(strSqlLogin);
            boolean resultado = rstSqlLogin.next();
            stmSqlLogin.close();
            return resultado;
        } catch (Exception e) {
            System.err.println("Erro: " + e);
            return false;
        }
    }
}

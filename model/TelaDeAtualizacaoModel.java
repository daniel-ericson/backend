package model;
import java.sql.*;
import java.util.*;
import controller.*;

public class TelaDeAtualizacaoModel {
    public static void popularIdsModel() {
        try {
            ArrayList<String> idsTemp = new ArrayList<>();
            idsTemp.add("Selecione aqui o id");
            Connection conexao = MySQLConnector.conectar();
            String strSqlPopularIds = "select * from `db_senac`.`tbl_senac` order by `id` asc;";
            Statement stmSqlPopularIds = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlPopularIds = stmSqlPopularIds.executeQuery(strSqlPopularIds);
            while (rstSqlPopularIds.next()) {
                idsTemp.add(rstSqlPopularIds.getString("id"));
            }

            TelaDeAtualizacaoController.enviarIds(idsTemp.toArray(new String[0]));
            stmSqlPopularIds.close();

        } catch (Exception e) {
            TelaDeAtualizacaoController.notificarUsuario("Não foi possível encontrar os ids! Por favor, verifique e tente novamente.");
           
            System.err.println("Erro: " + e);
        }   
    }

    public static void atualizarCAdastroModel(String atualizarId, String atualizarNome, String atualizarEmail, String atualizarSenha) {
        Connection conexao = MySQLConnector.conectar();
        String  strSqlAtualizar =  " update `db_senac`.`tbl_senac` set" + atualizarNome + atualizarEmail + atualizarSenha + " where `id` = " + atualizarId + ";";
        // System.out.println(strSqlAtualizarId);
        Statement stmSqlAtualizarId = conexao.createStatement();
        stmSqlAtualizarId.addBatch(strSqlAtualizarId);
        stmSqlAtualizarId.executeBatch();
        TelaDeAtualizacaoController.registrarAtualizacao();
        stmSqlAtualizarId.close();
        TelaDeAtualizacaoController.notificarUsuario("O id " + atualizarId + " foi atualizado com sucesso!");
    } catch (Exception e) {
        TelaDeAtualizacaoController.notificarUsuario("Não foi possivel realizar a atualização! Por favor, tente novamente mais tarde.");
        System.err.println("erro" + e);  
    }
}

// RM: [Seu RM] - Nome: [Seu Nome]
package br.com.fiap.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection abrirConexao() {
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
            final String USER = "rm557943";
            final String PASS = "130905";
            con = DriverManager.getConnection(url, USER, PASS);
            System.out.println("Conectado com sucesso!");
        } catch (ClassNotFoundException e) {
            System.out.println("Erro: Driver do Oracle não encontrado.");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco de dados.");
        }
        return con;
    }

    public static void fecharConexao(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar a conexão.");
        }
    }
}

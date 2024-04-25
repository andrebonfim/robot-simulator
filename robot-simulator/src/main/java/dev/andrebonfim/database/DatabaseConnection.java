/**
 * Classe responsável por gerenciar a conexão com o banco de dados MySQL.
 * Fornece métodos para obter e fechar a conexão com o banco de dados.
 */
package dev.andrebonfim.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
  private Connection con = null;
  private final String jdbcDriver = "com.mysql.cj.jdbc.Driver";
  private final String prefixoBD = "jdbc:mysql://";
  private final String nomeHost = "localhost";
  private final String portaBD = "3306";
  private final String nomeBD = "bd_simulador_robo";
  private final String usuario = "root";
  private final String senha = "";
  private String url = null;

  /**
   * Construtor que inicializa a URL de conexão com o banco de dados.
   */
  public DatabaseConnection() {
    url = prefixoBD + nomeHost + ":" + portaBD + "/" + nomeBD;
  }

  /**
   * Obtém uma conexão com o banco de dados. Se a conexão atual estiver fechada ou
   * nula,
   * uma nova conexão será criada.
   * 
   * @return Uma conexão ativa com o banco de dados.
   * @throws ClassNotFoundException Se o driver JDBC não for encontrado.
   * @throws SQLException           Se ocorrer um erro ao estabelecer a conexão
   *                                com o banco de dados.
   */
  public Connection getConexao() {
    try {
      if (con == null) {
        Class.forName(jdbcDriver);
        con = DriverManager.getConnection(url, usuario, senha);
      } else if (con.isClosed()) {
        con = null;
        return getConexao();
      }
    } catch (ClassNotFoundException ex) {
      System.out.println(ex);
    } catch (SQLException ex) {
      System.out.println(ex);
    }
    return con;
  }

  /**
   * Fecha a conexão atual com o banco de dados, se estiver aberta.
   */
  public void fecharConexao() {
    if (con != null) {
      try {
        con.close();
      } catch (SQLException ex) {
        System.out.println(ex);
      }
    }
  }
}
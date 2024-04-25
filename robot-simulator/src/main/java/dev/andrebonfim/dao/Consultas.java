/**
 * Classe responsável por realizar consultas ao banco de dados relacionadas à tabela `rota`.
 */
package dev.andrebonfim.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Consultas {

  /**
   * Insere uma nova posição na tabela `rota`.
   * 
   * @param conn A conexão com o banco de dados.
   * @param posX A coordenada X da posição a ser inserida.
   * @param posY A coordenada Y da posição a ser inserida.
   */
  public void inserirPos(Connection conn, float posX, float posY) {
    String sql = "INSERT INTO `rota` (posX, posY) VALUES (?, ?)";
    try (PreparedStatement pst = conn.prepareStatement(sql)) {
      pst.setFloat(1, posX);
      pst.setFloat(2, posY);
      pst.executeUpdate();
    } catch (SQLException ex) {
      System.out.println(ex);
    }
  }
}
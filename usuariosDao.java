/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarioDAO;

import com.sun.javafx.fxml.BeanAdapter;
import conectaBancoDados.ConectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rick
 */
public class usuariosDao {

    PreparedStatement stmt = null;
    ResultSet rs = null;
    Connection conexao = null;
    ConectionFactory con = new ConectionFactory();

    public boolean checaUser(String login, String pass) throws SQLException {
        boolean sucesso = false;
        String sql = "select * from usuarios where login =? and pass=?";

        try {
            conexao = ConectionFactory.getConection();
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, pass);
            rs = stmt.executeQuery();
            if (rs.next()) {
                sucesso = true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL usuários: " + e);
        } finally {
            conexao.close();

        }

        return sucesso;
    }

    public boolean editaUser(String user, String pass) throws SQLException {
        String sql = "update usuarios set pass=? where login =?;";
        boolean sucesso = false;
        try {
            conexao = ConectionFactory.getConection();
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, pass);
            stmt.setString(2, user);
            stmt.executeUpdate();
            sucesso = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar nova senha: " + e);

        } finally {
            conexao.close();

        }
        return sucesso;
    }
}

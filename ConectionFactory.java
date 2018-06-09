/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectaBancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rick
 */
public class ConectionFactory {
    private static String driver= "com.mysql.jdbc.Driver";
    private static String url="jdbc:mysql://localhost:3306/novosistema";
    private static String user="root";
    private static String password="root";
    
    public static Connection getConection() {
        Connection conecta = null;
        try {
          Class.forName(driver);
          conecta = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro de conexão: " +e);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Erro de conexão: " +ex);
        }
                
        return conecta;
    }    
}

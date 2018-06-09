/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import conectaBancoDados.ConectionFactory;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import usuarioBean.usuariosBean;
import usuarioDAO.usuariosDao;

/**
 *
 * @author Rick
 */
public class TelaTrocaSenha extends javax.swing.JDialog {

    /**
     * Creates new form TelaTrocaSenha
     */
    private boolean trocaSenha() throws SQLException {
        boolean sucesso =false;
        usuariosDao userDao = new usuariosDao();
        String pass = new String(txtAntigaSenha.getPassword());
        String newPass = new String(txtNovaSenha.getPassword());
        String user = txtUser.getText();

        if ((pass.equals(usuariosBean.getPass())) && (user.equals(usuariosBean.getUser())) && (!newPass.isEmpty())) {

            if (userDao.editaUser(user, newPass)) {
                JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!");
                sucesso = true;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Dados de verificação ou nova senha inválidos.");
        }
        return sucesso;
    }

    private boolean conectado() {
        boolean sucesso = false;
        Connection con = ConectionFactory.getConection();
        String conectado = con.toString();
        if (!conectado.isEmpty()) {
            sucesso = true;
        }

        return sucesso;
    }

    public TelaTrocaSenha(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        if (conectado()) {
            lblBanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/dbConectou.png")));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtAntigaSenha = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        lblBanco = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNovaSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mude a sua senha:");
        setResizable(false);

        jLabel1.setText("Confime seu Login:");

        jLabel2.setText("Confirme a Senha ATUAL:");

        txtAntigaSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAntigaSenhaKeyReleased(evt);
            }
        });

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButton1KeyReleased(evt);
            }
        });

        lblBanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/bderro.png"))); // NOI18N

        jLabel3.setText("Digite sua nova Senha:");

        txtNovaSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNovaSenhaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2)
                                        .addComponent(txtAntigaSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)))
                                .addGap(37, 37, 37)
                                .addComponent(lblBanco))
                            .addComponent(jLabel3)
                            .addComponent(txtNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(5, 5, 5)
                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAntigaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(435, 300));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtAntigaSenhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAntigaSenhaKeyReleased
        int tecla = evt.getKeyCode();
        if (tecla == KeyEvent.VK_ENTER) {
            try {
               if(trocaSenha())this.dispose();
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao alterar senha: " + ex);
            }
        }

    }//GEN-LAST:event_txtAntigaSenhaKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if(trocaSenha())this.dispose();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar senha: " + ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyReleased
        int tecla = evt.getKeyCode();
        if (tecla == KeyEvent.VK_ENTER) {
            try {
                if(trocaSenha())this.dispose();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao alterar senha: " + ex);
            }
        }
    }//GEN-LAST:event_jButton1KeyReleased

    private void txtNovaSenhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNovaSenhaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNovaSenhaKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaTrocaSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaTrocaSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaTrocaSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaTrocaSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaTrocaSenha dialog = new TelaTrocaSenha(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel lblBanco;
    private javax.swing.JPasswordField txtAntigaSenha;
    private javax.swing.JPasswordField txtNovaSenha;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}

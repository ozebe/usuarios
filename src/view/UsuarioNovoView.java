/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.ConnectionFactory;
import control.NivelAcesso;
import control.Usuario;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static view.UsuariosView.atualizaDadosTable;
import static view.UsuariosView.db;
import static view.UsuariosView.password;
import static view.UsuariosView.user;
import static view.UsuariosView.atualizaUserTable;
import static view.UsuariosView.getUsuario;

/**
 *
 * @author wesley.santos
 */
public class UsuarioNovoView extends javax.swing.JFrame {

    private static Connection connection;
    private static ConnectionFactory fabrica = new ConnectionFactory();
    private ArrayList<NivelAcesso> niveis;
    private static String senha;

    /**
     * Creates new form UsuarioNovoView
     */
    public UsuarioNovoView(ArrayList niveis) {
        this.niveis = null;
        this.niveis = niveis;
        initComponents();
        nivelAcesso.removeAllItems();
        for (int i = 0; i < niveis.size(); i++) {
            nivelAcesso.addItem(this.niveis.get(i).getDescricao());
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

        jLabel8 = new javax.swing.JLabel();
        ativoComboBox = new javax.swing.JComboBox();
        bloqueadoComboBox = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nivelAcesso = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        definirSenhaBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        usuarioField = new javax.swing.JTextField();
        salvarBtn = new javax.swing.JButton();
        nomeUsuarioField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Criar usuário");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Ativo:");

        ativoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        ativoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ativoComboBoxActionPerformed(evt);
            }
        });

        bloqueadoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        bloqueadoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bloqueadoComboBoxActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Bloqueado:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Nível acesso:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Senha:");

        definirSenhaBtn.setText("Definir Senha");
        definirSenhaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                definirSenhaBtnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Usuário:");

        salvarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/save.png"))); // NOI18N
        salvarBtn.setText("Salvar");
        salvarBtn.setEnabled(false);
        salvarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarBtnActionPerformed(evt);
            }
        });

        nomeUsuarioField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeUsuarioFieldActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nome do Usuário:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usuarioField)
                            .addComponent(definirSenhaBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(nivelAcesso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bloqueadoComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ativoComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(salvarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(nomeUsuarioField)))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nomeUsuarioField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(usuarioField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(definirSenhaBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(nivelAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(bloqueadoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ativoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(salvarBtn)
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ativoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ativoComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ativoComboBoxActionPerformed

    private void bloqueadoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bloqueadoComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bloqueadoComboBoxActionPerformed

    private void definirSenhaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_definirSenhaBtnActionPerformed
        final DefinirSenhaView definirSenha = new DefinirSenhaView();
        definirSenha.setVisible(true);
    }//GEN-LAST:event_definirSenhaBtnActionPerformed

    private void salvarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarBtnActionPerformed
        try {
            connection = fabrica.getConnection(db.getDir(), user.getDir(), password.getDir());
            String sql = "INSERT INTO usuarios(nome, usuario, senha, nivel, criado, bloqueado, ativo)\n"
                    + "VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, nomeUsuarioField.getText());
            pstmt.setString(2, usuarioField.getText());
            pstmt.setString(3, senha);
            //java.sql.Date sDate = convertUtilToSql(dataNascimentoField.getDate());
            //pstmt.setDate(4, sDate);
            pstmt.setInt(4, nivelAcesso.getSelectedIndex() + 1);
            java.sql.Timestamp timestamp = new java.sql.Timestamp(new java.util.Date().getTime());
            //formatador.format(timestamp)
            pstmt.setTimestamp(5, timestamp); //String.valueOf(formatador.format(timestamp))
            pstmt.setBoolean(6, intToBool(bloqueadoComboBox.getSelectedIndex()));
            pstmt.setBoolean(7, intToBool(ativoComboBox.getSelectedIndex()));
            pstmt.executeUpdate();
            pstmt.close();
            connection.close();

            //criaTable();
            //atualizaDadosTable();
            getUsuario(usuarioField.getText());
            atualizaDadosTable();
            
            JOptionPane.showMessageDialog(null, "Usuário " + usuarioField.getText() + " criado!");
            UsuariosView.novoBtn.setEnabled(true);
            this.dispose();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar registro\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar registro\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(UsuariosEditaView.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("err");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar registro\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(UsuariosEditaView.class.getName()).log(Level.SEVERE, null, ex);
        } catch(NullPointerException ex){
            JOptionPane.showMessageDialog(null, "Favor preencher todos os campos!\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_salvarBtnActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int output = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Sair", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (output == 0) {
            UsuariosView.novoBtn.setEnabled(true);
            this.dispose();
        } else if (output == 1) {

        }
    }//GEN-LAST:event_formWindowClosing

    private void nomeUsuarioFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeUsuarioFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeUsuarioFieldActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(UsuarioNovoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(UsuarioNovoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(UsuarioNovoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(UsuarioNovoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new UsuarioNovoView().setVisible(true);
//            }
//        });
//    }
    public static void setSenha(String senha) {
        UsuarioNovoView.senha = senha;
    }

    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    private boolean intToBool(int i) {
        return i == 1;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ativoComboBox;
    private javax.swing.JComboBox bloqueadoComboBox;
    public static javax.swing.JButton definirSenhaBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JComboBox nivelAcesso;
    private javax.swing.JTextField nomeUsuarioField;
    public static javax.swing.JButton salvarBtn;
    private javax.swing.JTextField usuarioField;
    // End of variables declaration//GEN-END:variables
}

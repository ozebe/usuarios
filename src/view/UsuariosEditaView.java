/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import control.ConnectionFactory;
import control.NivelAcesso;
import control.Usuario;
import static view.UsuariosView.atualizaUserTable;
import static view.UsuariosView.db;
import static view.UsuariosView.editarBtn;
import static view.UsuariosView.password;
import static view.UsuariosView.user;

/**
 *
 * @author wesley.santos
 */
public class UsuariosEditaView extends javax.swing.JFrame {

    private static Connection connection;
    private static ConnectionFactory fabrica = new ConnectionFactory();
    private Usuario usuario;
    private String senha;
    private ArrayList<NivelAcesso> niveis;

    /**
     * Creates new form UsuariosEditaView
     *
     * @param usuario
     * @param niveis
     */
    public UsuariosEditaView(Usuario usuario, ArrayList niveis) {
        this.usuario = null;
        this.niveis = null;
        this.usuario = usuario;
        this.niveis = niveis;
        initComponents();

        idLabel.setText(Integer.toString(usuario.getId()));
        nomeUsuarioField.setText(usuario.getNome());
        usuarioField.setText(usuario.getUsuario());
        //verificar pois se não tiver data de nascimento não carrega
        dataNascimentoField.setDate(Date.valueOf(usuario.getData_nasc()));

        nivelAcesso.removeAllItems();
        for (int i = 0; i < niveis.size(); i++) {
            nivelAcesso.addItem(this.niveis.get(i).getDescricao());
        }
        nivelAcesso.setSelectedIndex(usuario.getNivel() - 1);
        if (usuario.isBloqueado()) {
            bloqueadoComboBox.setSelectedIndex(1); //não
        } else {
            bloqueadoComboBox.setSelectedIndex(0); //sim
            
        }
        if (usuario.isAtivo()) {
            ativoComboBox.setSelectedIndex(1);
        } else {
            ativoComboBox.setSelectedIndex(0);
        }
        dataCriacaoLabel.setText(usuario.getCriado());
        try {
            editadoLabel.setText(usuario.getEditado());
        } catch (java.lang.NullPointerException e) {
            editadoLabel.setText("Não editado");
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
        idLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nomeUsuarioField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        usuarioField = new javax.swing.JTextField();
        redefinirSenhaBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nivelAcesso = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        dataCriacaoLabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        editadoLabel = new javax.swing.JLabel();
        bloqueadoComboBox = new javax.swing.JComboBox();
        ativoComboBox = new javax.swing.JComboBox();
        salvarBtn = new javax.swing.JButton();
        dataNascimentoField = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Editar Usuário");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("ID do usuário:");

        idLabel.setText("jLabel2");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nome do Usuário:");

        nomeUsuarioField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeUsuarioFieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Usuário:");

        redefinirSenhaBtn.setText("Redefinir senha");
        redefinirSenhaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redefinirSenhaBtnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Senha:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Data nascimento:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Nível acesso:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Bloqueado:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Ativo:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Data de criação:");

        dataCriacaoLabel.setText("jLabel10");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Última edição:");

        editadoLabel.setText("jLabel12");

        bloqueadoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        bloqueadoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bloqueadoComboBoxActionPerformed(evt);
            }
        });

        ativoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        ativoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ativoComboBoxActionPerformed(evt);
            }
        });

        salvarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/save.png"))); // NOI18N
        salvarBtn.setText("Salvar");
        salvarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(salvarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(idLabel)
                    .addComponent(nomeUsuarioField)
                    .addComponent(usuarioField)
                    .addComponent(redefinirSenhaBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(nivelAcesso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dataCriacaoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editadoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bloqueadoComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ativoComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dataNascimentoField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                    .addComponent(redefinirSenhaBtn))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(dataNascimentoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(dataCriacaoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(editadoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salvarBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeUsuarioFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeUsuarioFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeUsuarioFieldActionPerformed

    private void bloqueadoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bloqueadoComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bloqueadoComboBoxActionPerformed

    private void salvarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarBtnActionPerformed

        try {
            connection = fabrica.getConnection(db.getDir(), user.getDir(), password.getDir());
            String sql = "UPDATE usuarios\n"
                    + "SET nome = ?, usuario = ?, data_nasc = ?, nivel = ?, bloqueado = ?, ativo = ?, editado = ?\n"
                    + "WHERE  usuarios.id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, nomeUsuarioField.getText());
            
            pstmt.setString(2, usuarioField.getText());

            java.sql.Date sDate = convertUtilToSql(dataNascimentoField.getDate());
            
            pstmt.setDate(3, sDate);
            pstmt.setInt(4, nivelAcesso.getSelectedIndex() + 1);

            pstmt.setBoolean(5, intToBool(bloqueadoComboBox.getSelectedIndex()));
            pstmt.setBoolean(6, intToBool(ativoComboBox.getSelectedIndex()));

            //SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            java.sql.Timestamp timestamp = new java.sql.Timestamp(new java.util.Date().getTime());
            //formatador.format(timestamp)
            pstmt.setTimestamp(7, timestamp); //String.valueOf(formatador.format(timestamp))
            pstmt.setInt(8, usuario.getId());
            pstmt.executeUpdate();
            pstmt.close();
            connection.close();
            atualizaUserTable(usuario);
            //criaTable();
            //atualizaDadosTable();

            JOptionPane.showMessageDialog(null, "Usuário " + usuario.getUsuario() + " Atualizado!");
            editarBtn.setEnabled(true);
            this.dispose();
            //this.setVisible(false);
            //int id = (int) tableUsuarios.getValueAt(lSelec, 0);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar registro\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuariosEditaView.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("err");
        } catch (IOException ex) {
            Logger.getLogger(UsuariosEditaView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_salvarBtnActionPerformed

    private void ativoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ativoComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ativoComboBoxActionPerformed

    private void redefinirSenhaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redefinirSenhaBtnActionPerformed

        usuario.setNome(nomeUsuarioField.getText());
        usuario.setUsuario(usuarioField.getText());
        usuario.setNivel(nivelAcesso.getSelectedIndex() + 1);
        usuario.setBloqueado(verificaBoolean(bloqueadoComboBox.getSelectedIndex()));
        usuario.setAtivo(verificaBoolean(ativoComboBox.getSelectedIndex()));
        java.sql.Date sDate = convertUtilToSql(dataNascimentoField.getDate());
        usuario.setData_nasc(sDate.toString());

        RedefinirSenhaView redefinirSenha = new RedefinirSenhaView(usuario,true);
        redefinirSenha.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_redefinirSenhaBtnActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int output = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Sair", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (output == 0) {
            UsuariosView.editarBtn.setEnabled(true);
            this.dispose();
        } else if (output == 1) {

        }
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private boolean intToBool(int i){
        return i == 1;
    }
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
//            java.util.logging.Logger.getLogger(UsuariosEditaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(UsuariosEditaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(UsuariosEditaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(UsuariosEditaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new UsuariosEditaView().setVisible(true);
//            }
//        });
//    }
    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    private static boolean verificaBoolean(int i) {
        return i == 1;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ativoComboBox;
    private javax.swing.JComboBox bloqueadoComboBox;
    private javax.swing.JLabel dataCriacaoLabel;
    private com.toedter.calendar.JDateChooser dataNascimentoField;
    private javax.swing.JLabel editadoLabel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JComboBox nivelAcesso;
    private javax.swing.JTextField nomeUsuarioField;
    private javax.swing.JButton redefinirSenhaBtn;
    public static javax.swing.JButton salvarBtn;
    private javax.swing.JTextField usuarioField;
    // End of variables declaration//GEN-END:variables
}

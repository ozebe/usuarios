/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import control.ConnectionFactory;
import control.INI;
import control.NivelAcesso;
import control.Usuario;
import java.awt.event.KeyEvent;
import java.util.regex.PatternSyntaxException;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;
import model.UsuariosTableModel;

/**
 *
 * @author wesley
 */
public class UsuariosView extends javax.swing.JFrame {

    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<NivelAcesso> niveis = new ArrayList<>();
    private static UsuariosTableModel modelo = new UsuariosTableModel();
    TableRowSorter<UsuariosTableModel> sorter = new TableRowSorter<UsuariosTableModel>(modelo);
    private static Connection connection;
    private static ConnectionFactory fabrica = new ConnectionFactory();
    //pega o caminho da base no arquivo .ini
    public static INI db;
    public static INI user;
    public static INI password;
    //public static Usuario userLogado;
    /**
     * Creates new form Usuarios
     */
    public UsuariosView(String chave, String valor, String usuario, String senha) throws ClassNotFoundException, SQLException, IOException {
        //verifica se o usuário tem e permissão de acessar a tela, se tiver continua, se não dá um dispose()
        db = new INI(chave, valor);
        user = new INI(chave, usuario);
        password = new INI(chave, senha);
        initComponents();
        criaTable();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableUsuarios = new javax.swing.JTable();
        novoBtn = new javax.swing.JButton();
        editarBtn = new javax.swing.JButton();
        desbloquearBtn = new javax.swing.JButton();
        buscaField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Usuários Cadastrados");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tableUsuarios.setModel(modelo);
        tableUsuarios.setRowSorter(sorter);
        tableUsuarios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tableUsuarios);

        novoBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        novoBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/add.png"))); // NOI18N
        novoBtn.setText("Novo");
        novoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoBtnActionPerformed(evt);
            }
        });

        editarBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        editarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/edit.png"))); // NOI18N
        editarBtn.setText("Editar");
        editarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarBtnActionPerformed(evt);
            }
        });

        desbloquearBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        desbloquearBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/unlock.png"))); // NOI18N
        desbloquearBtn.setText("Desbloquear");
        desbloquearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desbloquearBtnActionPerformed(evt);
            }
        });

        buscaField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscaFieldKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(novoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(editarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(desbloquearBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(buscaField, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(novoBtn)
                    .addComponent(desbloquearBtn)
                    .addComponent(editarBtn))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(buscaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(476, Short.MAX_VALUE)))
        );

        buscaField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                pesquisar();
            }
            public void removeUpdate(DocumentEvent e) {
                pesquisar();
            }
            public void insertUpdate(DocumentEvent e) {
                pesquisar();
            }

            public void pesquisar() {
                String text = buscaField.getText();
                if (text.length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    try {
                        sorter.setRowFilter(
                            RowFilter.regexFilter(text));
                    } catch (PatternSyntaxException pse) {
                        System.err.println("Erro");
                    }
                }
            }
        });

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void novoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoBtnActionPerformed
        try {
            carregaNiveisAcesso();
            final UsuarioNovoView novoUsuario = new UsuarioNovoView(niveis);
            novoUsuario.setVisible(true);
            this.novoBtn.setEnabled(false);
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível carregar!\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(UsuariosView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_novoBtnActionPerformed

    private void editarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarBtnActionPerformed

        try {
            carregaNiveisAcesso();
            int linha = -1;
            linha = tableUsuarios.getSelectedRow();
            if (linha == -1) {
                JOptionPane.showMessageDialog(null, "Favor selecionar um usuário", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                linha = tableUsuarios.getRowSorter().convertRowIndexToModel(linha);
                editarBtn.setEnabled(false);
                final UsuariosEditaView editaUsuario = new UsuariosEditaView(usuarios.get(linha), niveis);
                editaUsuario.setVisible(true);
            }
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível carregar!\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível carregar o perfil do usuário!\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            editarBtn.setEnabled(true);
        }


    }//GEN-LAST:event_editarBtnActionPerformed

    private void desbloquearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desbloquearBtnActionPerformed
        try {
            connection = fabrica.getConnection(db.getDir(), user.getDir(), password.getDir());

            int linha = -1;
            linha = tableUsuarios.getSelectedRow();
            if (linha == -1) {
                JOptionPane.showMessageDialog(null, "Favor selecionar um usuário", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                linha = tableUsuarios.getRowSorter().convertRowIndexToModel(linha);
                if (usuarios.get(linha).isBloqueado()) {
                    usuarios.get(linha).setBloqueado(false);

                    String sql = "UPDATE usuarios\n"
                            + "SET  bloqueado = FALSE, editado = ?\n"
                            + "WHERE usuarios.id = ?";

                    try {
                        PreparedStatement pstmt = connection.prepareStatement(sql);

                        SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                        java.sql.Timestamp timestamp = new java.sql.Timestamp(new java.util.Date().getTime());

                        usuarios.get(linha).setEditado(String.valueOf(formatador.format(timestamp)));
                        pstmt.setTimestamp(1, timestamp);
                        pstmt.setInt(2, usuarios.get(linha).getId());
                        pstmt.executeUpdate();
                        pstmt.close();
                        connection.close();
                        atualizaDadosTable();

                        JOptionPane.showMessageDialog(null, "Usuário " + usuarios.get(linha).getUsuario() + " Desbloqueado!");
                        //int id = (int) tableUsuarios.getValueAt(lSelec, 0);
                    } catch (SQLException ex) {
                        Logger.getLogger(UsuariosView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário " + usuarios.get(linha).getUsuario() + " Já está desbloqueado!", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível carregar!\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(UsuariosView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_desbloquearBtnActionPerformed

    private void buscaFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscaFieldKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.buscaField.setText("");
        }
    }//GEN-LAST:event_buscaFieldKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int output = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Sair", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (output == 0) {
            UsuariosView.editarBtn.setEnabled(true);
            while (modelo.getRowCount() > 0) {
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    modelo.removeUsuario(i);
                }
            }
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuariosView.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
        } else if (output == 1) {
        }
    }//GEN-LAST:event_formWindowClosing

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
//            java.util.logging.Logger.getLogger(UsuariosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(UsuariosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(UsuariosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(UsuariosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new UsuariosView().setVisible(true);
//                try {
//                    criaTable();
//                } catch (ClassNotFoundException ex) {
//                    JOptionPane.showMessageDialog(null, "Erro ao iniciar!\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
//                    Logger.getLogger(UsuariosView.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (SQLException ex) {
//                    JOptionPane.showMessageDialog(null, "Erro ao iniciar!\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
//                    Logger.getLogger(UsuariosView.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (IOException ex) {
//                    JOptionPane.showMessageDialog(null, "Erro ao iniciar!\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
//                    Logger.getLogger(UsuariosView.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//    }
    public static void criaTable() throws ClassNotFoundException, SQLException, IOException {
        connection = fabrica.getConnection(db.getDir(), user.getDir(), password.getDir());

        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM usuarios ORDER BY usuarios.nome");
        ResultSet resultSet = stmt.executeQuery();

//        while (modelo.getRowCount() > 0) {
//            for (int i = 0; i < modelo.getRowCount(); i++) {
//                modelo.removeUsuario(i);
//            }
//        }
        usuarios.removeAll(usuarios);

        while (resultSet.next()) {
            Usuario u = new Usuario();
            u.setAtivo(resultSet.getBoolean("ativo"));
            u.setBloqueado(resultSet.getBoolean("bloqueado"));
            u.setCriado(formataTimestamp(resultSet.getTimestamp("criado")));
            u.setEditado(formataTimestamp(resultSet.getTimestamp("editado")));
            u.setId(resultSet.getInt("id"));
            u.setNivel(resultSet.getInt("nivel"));
            u.setNome(resultSet.getString("nome"));
            u.setSenha(resultSet.getString("senha"));
            u.setTentativas(resultSet.getInt("tentativas"));
            u.setUsuario(resultSet.getString("usuario"));
            modelo.addUsuario(u);
            usuarios.add(u);
        }
        resultSet.close();
        stmt.close();
        connection.close();
    }

    public static Usuario getUsuario(String usuario) throws ClassNotFoundException, SQLException, IOException {
        connection = fabrica.getConnection(db.getDir(), user.getDir(), password.getDir());

        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM usuarios WHERE usuarios.usuario = ?");
        stmt.setString(1, usuario);
        ResultSet resultSet = stmt.executeQuery();
        Usuario u = new Usuario();
        
        while (resultSet.next()) {
            u.setAtivo(resultSet.getBoolean("ativo"));
            u.setBloqueado(resultSet.getBoolean("bloqueado"));
            u.setCriado(formataTimestamp(resultSet.getTimestamp("criado")));
            
            u.setEditado(formataTimestamp(resultSet.getTimestamp("editado")));
            //u.setEditado(resultSet.getString("editado"));
            u.setId(resultSet.getInt("id"));
            u.setNivel(resultSet.getInt("nivel"));
            u.setNome(resultSet.getString("nome"));
            u.setSenha(resultSet.getString("senha"));
            u.setTentativas(resultSet.getInt("tentativas"));
            u.setUsuario(resultSet.getString("usuario"));
        }
        resultSet.close();
        stmt.close();
        connection.close();
        usuarios.add(u);
        System.out.println("index -:>"  +       usuarios.indexOf(u));

                
        return u;
    }

    public static void atualizaUserTable(Usuario usuario) throws ClassNotFoundException, SQLException, IOException {
        connection = fabrica.getConnection(db.getDir(), user.getDir(), password.getDir());
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM usuarios WHERE usuarios.id = ? ORDER BY usuarios.nome");
        stmt.setInt(1, usuario.getId());
        ResultSet resultSet = stmt.executeQuery();

        int idTable;
        idTable = usuarios.indexOf(usuario);
        usuarios.remove(usuario);
        while (resultSet.next()) {
            Usuario u = new Usuario();
            u.setAtivo(resultSet.getBoolean("ativo"));
            u.setBloqueado(resultSet.getBoolean("bloqueado"));
            u.setCriado(formataTimestamp(resultSet.getTimestamp("criado")));
            u.setEditado(formataTimestamp(resultSet.getTimestamp("editado")));
            u.setId(resultSet.getInt("id"));
            u.setNivel(resultSet.getInt("nivel"));
            u.setNome(resultSet.getString("nome"));
            u.setSenha(resultSet.getString("senha"));
            u.setTentativas(resultSet.getInt("tentativas"));
            u.setUsuario(resultSet.getString("usuario"));

            modelo.setValueAt(u, idTable);
            usuarios.add(idTable, u);
        }
        resultSet.close();
        stmt.close();
        connection.close();
    }

    public static void atualizaDadosTable() {
        while (modelo.getRowCount() > 0) {
            for (int i = 0; i < modelo.getRowCount(); i++) {
                modelo.removeUsuario(i);
            }
        }
        for (Usuario u : usuarios) {
            modelo.addUsuario(u);
        }
    }

    public static void carregaNiveisAcesso() throws ClassNotFoundException, SQLException, IOException {
        connection = fabrica.getConnection(db.getDir(), user.getDir(), password.getDir());
        PreparedStatement stmt = connection.prepareStatement("select * from nivelAcesso order by nivelAcesso.id");
        ResultSet resultSet = stmt.executeQuery();
        niveis.removeAll(niveis);
        while (resultSet.next()) {
            NivelAcesso nv = new NivelAcesso();
            nv.setId(resultSet.getInt("id"));
            nv.setDescricao(resultSet.getString("descricao"));
            nv.setSigla(resultSet.getString("sigla"));
            niveis.add(nv);
        }
        resultSet.close();
        stmt.close();
        connection.close();
    }

    private static String formataTimestamp(Timestamp t) {
        if (t != null) {
            SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            return formatador.format(t);
        } else {
            return "";
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField buscaField;
    private javax.swing.JButton desbloquearBtn;
    public static javax.swing.JButton editarBtn;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JButton novoBtn;
    private javax.swing.JTable tableUsuarios;
    // End of variables declaration//GEN-END:variables
}

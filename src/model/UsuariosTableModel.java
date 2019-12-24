package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import control.Usuario;

public class UsuariosTableModel extends AbstractTableModel {

    private List<Usuario> usuarios;
    private String[] colunas = new String[]{"Nome", "Usuario", "Bloqueado", "Ativo", "Ultima Edição"};

    /**
     * Creates a new instance of DevmediaTableModel
     */
    public UsuariosTableModel(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public UsuariosTableModel() {
        this.usuarios = new ArrayList<Usuario>();
    }

    public int getRowCount() {
        return usuarios.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public void setValueAt(Usuario aValue, int rowIndex) {
        Usuario usuario = usuarios.get(rowIndex);

        usuario.setNome(aValue.getNome());
        usuario.setUsuario(aValue.getUsuario());
        usuario.setBloqueado(aValue.isBloqueado());
        usuario.setAtivo(aValue.isAtivo());
        usuario.setEditado(aValue.getEditado());

        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);
        fireTableCellUpdated(rowIndex, 3);
        fireTableCellUpdated(rowIndex, 4);

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Usuario usuario = usuarios.get(rowIndex);

        switch (columnIndex) {
            case 0:
                usuario.setNome(aValue.toString());
            case 1:
                usuario.setUsuario(aValue.toString());
            case 2:
                usuario.setBloqueado(Boolean.parseBoolean(aValue.toString()));
            case 3:
                usuario.setAtivo(Boolean.parseBoolean(aValue.toString()));
            case 4: {
                usuario.setEditado(aValue.toString());

            }

            default:
                System.err.println("Índice da coluna inválido");
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario usuarioSelecionado = usuarios.get(rowIndex);
        String valueObject = null;
        switch (columnIndex) {
            case 0:
                valueObject = usuarioSelecionado.getNome();
                break;
            case 1:
                valueObject = usuarioSelecionado.getUsuario();
                break;
            case 2:
                valueObject = Boolean.toString(usuarioSelecionado.isBloqueado());
                break;
            case 3:
                valueObject = Boolean.toString(usuarioSelecionado.isAtivo());
                break;
            case 4:
                valueObject = usuarioSelecionado.getEditado();
                break;
            default:
                System.err.println("Índice inválido para propriedade do bean Usuario.class");
        }

        return valueObject;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Usuario getUsuario(int indiceLinha) {
        return usuarios.get(indiceLinha);
    }

    public void addUsuario(Usuario u) {
        usuarios.add(u);

        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void removeUsuario(int indiceLinha) {
        usuarios.remove(indiceLinha);

        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    public void addListaDeUsuarios(List<Usuario> novosUsuarios) {

        int tamanhoAntigo = getRowCount();
        usuarios.addAll(novosUsuarios);
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }

    public void limpar() {
        usuarios.clear();
        fireTableDataChanged();
    }

    public boolean isEmpty() {
        return usuarios.isEmpty();
    }

}

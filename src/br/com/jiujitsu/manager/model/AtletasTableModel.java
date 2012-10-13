package br.com.jiujitsu.manager.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pc
 */
public class AtletasTableModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;

    private List<AtletaModel> linhas;
    
    private String[] colunas = new String[]{
        "ID", "Nome", "Sexo", "Faixa", "Cat. Idade", "Cat. Peso"
    };

    public AtletasTableModel() {
        linhas = new ArrayList<>();
    }

    public AtletasTableModel(List<AtletaModel> listaDeAtletas) {
        linhas = new ArrayList<>(listaDeAtletas);
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        AtletaModel atleta = linhas.get(rowIndex);
       
        switch (columnIndex) {
            case 0:
                return atleta.getId();
            case 1:
                return atleta.getNome();
            case 2:
                return atleta.getSexo();
            case 3:
                return atleta.getFaixa();
            case 4:
                return atleta.getCategoria_idade();
            case 5:
                return atleta.getCategoria_peso();
            default:
                throw new IndexOutOfBoundsException("Coluna inexistente.");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        AtletaModel item = linhas.get(rowIndex);

        switch (columnIndex) {
            case 0:
                item.setId(Integer.valueOf(aValue.toString()));
            case 1:
                item.setNome(aValue.toString());
            case 2:
                item.setSexo(aValue.toString().charAt(0));
            case 3:
                item.setFaixa(aValue.toString());
            case 4:
                item.setCategoria_idade(aValue.toString());
            case 5:
                item.setCategoria_peso(aValue.toString());            
            default:
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public void setValueAt(AtletaModel aValue, int rowIndex) {
        AtletaModel atleta = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado

//      "ID", "Nome", "Sexo", "Faixa", "Cat. Idade", "Cat. Peso"
        
        atleta.setId(aValue.getId());
        atleta.setNome(aValue.getNome());
        atleta.setSexo(aValue.getSexo());
        atleta.setFaixa(aValue.getFaixa());
        atleta.setCategoria_idade(aValue.getCategoria_idade());
        atleta.setCategoria_peso(aValue.getCategoria_peso());
        
        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);
        fireTableCellUpdated(rowIndex, 3);
        fireTableCellUpdated(rowIndex, 4);
        fireTableCellUpdated(rowIndex, 5);        
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public AtletaModel getAtleta(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    public void addAtleta(AtletaModel atleta) {
        linhas.add(atleta);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void removerAtleta(int indiceLinha) {
        linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    public void addAll(List<AtletaModel> atletas){        
        int tamanhoAntigo = getRowCount();
        this.limpar();
        linhas.addAll(atletas);
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }

    public void limpar() {
        linhas.clear();
        fireTableDataChanged();
    }

    public boolean isEmpty() {
        return linhas.isEmpty();
    }
    
    public List<AtletaModel> getAll() {
        return linhas;
    }
    
    public long getLast() {
        int i = 0;
        long last = 0;
        
        while (i < getAll().size()) {
            if (last < getAll().get(i).getId()) {
                last = getAll().get(i).getId();
            }
            i++;
        }
        return last;
    }
}

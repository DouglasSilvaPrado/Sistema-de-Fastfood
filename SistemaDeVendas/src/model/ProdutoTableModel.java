/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.sun.glass.ui.Size;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author douglas
 */
public class ProdutoTableModel extends AbstractTableModel{
    
    private List<Produto> dados = new ArrayList<>();
    private String[] colunas = {"Nome", "Preço"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0:
                return dados.get(linha).getNome();
            case 1:
                return dados.get(linha).getValor();
        }
        
        return null;
    }
    
    
    public float getSoma(){
        float soma = 0;
        for(int i=0; i < getRowCount(); i++){
            
            soma = soma + dados.get(i).getValor();
        }
        return Math.round(soma);
    }
    
    public void addRow(Produto p){
        this.dados.add(p);
        this.fireTableDataChanged();
    }
    
   public void clear(){
        dados.clear();
        this.fireTableDataChanged();
   }
    
    public void removeRow(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
    public void viewTable(){
        for(int l=0; l < getRowCount(); l++){
            for(int c=0; c < getColumnCount(); c++){
                System.out.println(getValueAt(l, c));
            } 
        }
    }
    
}

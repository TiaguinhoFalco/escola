/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import tela.manutencao.ManutencaoEscola;

import dao.DaoEscola;
import javax.swing.JOptionPane;
import modelo.Escola;
import tela.manutencao.ManutencaoEscola;


import java.util.List;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorEscola {

    public static void inserir(ManutencaoEscola man){
        Escola objeto = new Escola();
        
        objeto.setNome(man.jtfNome.getText());
        objeto.setEndereco(man.jtfEndereco.getText());
        objeto.setSigla(man.jtfSigla.getText());
        objeto.setNalunos(Integer.parseInt(man.jtfNalunos.getText()));
        objeto.setArea(Double.parseDouble(man.jtfArea.getText()));
        
        boolean resultado = DaoEscola.inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
}

   public static void alterar(ManutencaoEscola man){
        Escola objeto = new Escola();
        objeto.setNome(man.jtfNome.getText());
        objeto.setEndereco(man.jtfEndereco.getText());
        objeto.setSigla(man.jtfSigla.getText());
        objeto.setNalunos(Integer.parseInt(man.jtfNalunos.getText()));
        objeto.setArea(Double.parseDouble(man.jtfArea.getText()));
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText()));
        
        boolean resultado = DaoEscola.alterar(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }

     public static void excluir(ManutencaoEscola man){
        Escola objeto = new Escola();
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText()));
        
        boolean resultado = DaoEscola.excluir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
     
     
     public static void atualizarTabela(JTable tabela) {
        DefaultTableModel modelo = new DefaultTableModel();
        //definindo o cabeçalho da tabela
        modelo.addColumn("Codigo");
        modelo.addColumn("Nome");
        modelo.addColumn("Endereço");
        modelo.addColumn("Sigla");
        modelo.addColumn("Número de alunos");
        modelo.addColumn("Área");
        List<Escola> resultados = DaoEscola.consultar();
        for (Escola objeto : resultados) {
            Vector linha = new Vector();
            
            //definindo o conteúdo da tabela
            linha.add(objeto.getCodigo());
            linha.add(objeto.getNome());
            linha.add(objeto.getEndereco());
            linha.add(objeto.getSigla());
            linha.add(objeto.getNalunos());
            linha.add(objeto.getArea());
            modelo.addRow(linha); //adicionando a linha na tabela
        }
        tabela.setModel(modelo);
    }
}

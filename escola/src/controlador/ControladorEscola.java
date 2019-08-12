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
}

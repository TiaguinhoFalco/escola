/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Escola;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoEscola {
    
     public static boolean inserir(Escola objeto) {
        String sql = "INSERT INTO escola (nome, endereco, sigla, nalunos, area) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getNome());
            ps.setString(2, objeto.getEndereco());
            ps.setString(3, objeto.getSigla());
            ps.setInt(4, objeto.getNalunos());
            ps.setDouble(5, objeto.getArea());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
     
      public static void main(String[] args) {
        Escola objeto = new Escola();
        
        objeto.setNome("Julio Carlos da Silva");
        objeto.setEndereco("Rua Jaqueline Jarques 933");
        objeto.setSigla("QTR");
        objeto.setNalunos(1);
        objeto.setArea(2.7);
        
        boolean resultado = inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
      
       public static boolean alterar(Escola objeto) {
        String sql = "UPDATE escola SET nome = ?, endereco = ?, sigla = ?, nalunos = ?, area = ? WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getNome()); 
            ps.setString(2, objeto.getEndereco());
            ps.setString(3, objeto.getSigla());
            ps.setInt(4, objeto.getNalunos());
            ps.setDouble(5, objeto.getArea());
            ps.setInt(6, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
       
         public static boolean excluir(Escola objeto) {
        String sql = "DELETE FROM escola WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

public static List<Escola> consultar() {
        List<Escola> resultados = new ArrayList<>();
        //editar o SQL conforme a entidade
        String sql = "SELECT codigo, nome, endereco, sigla, nalunos, area FROM escola";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Escola objeto = new Escola();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setCodigo(rs.getInt("codigo"));
                objeto.setNome(rs.getString("nome"));
                objeto.setEndereco(rs.getString("endereco"));
                objeto.setSigla(rs.getString("sigla"));
                objeto.setNalunos(rs.getInt("nalunos"));
                objeto.setArea(rs.getDouble("area"));
                
                resultados.add(objeto);//não mexa nesse, ele adiciona o objeto na lista
            }
            return resultados;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
}


    
}

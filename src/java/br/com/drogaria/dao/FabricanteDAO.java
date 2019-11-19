package br.com.drogaria.dao;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.factory.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Aurora
 */
public class FabricanteDAO {
    
    public void salvar(Fabricante f) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO fabricante ");
        sql.append("(descricao) ");
        sql.append("VALUES (?) ");
        
        Connection conexao = ConexaoFactory.conectar();
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        comando.setString(1, f.getDescricao());
        
        comando.executeUpdate();
    }
    
     public void excluir(Fabricante f) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM fabricante ");
        sql.append("WHERE codigo = ? ");
              
        Connection conexao = ConexaoFactory.conectar();
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        comando.setLong(1, f.getCodigo());
        
        comando.executeUpdate();
    }
     
     public void editar(Fabricante f) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE fabricante ");
        sql.append("SET descricao = ? ");
        sql.append("WHERE codigo = ? ");
              
        Connection conexao = ConexaoFactory.conectar();
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        comando.setString(1, f.getDescricao());
        comando.setLong(2, f.getCodigo());
        
        comando.executeUpdate();
    }
     
     public Fabricante buscarPorCodigo(Fabricante f) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT codigo, descricao ");
        sql.append("FROM fabricante ");
        sql.append("WHERE codigo = ? ");
        
        Connection conexao = ConexaoFactory.conectar();
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        comando.setLong(1, f.getCodigo());
        ResultSet resultado = comando.executeQuery();
        
        Fabricante retorno = null;
        
        if(resultado.next()){
            retorno = new Fabricante();
            retorno.setCodigo(resultado.getLong("codigo"));
            retorno.setDescricao(resultado.getString("descricao"));
        }
        return retorno;
     }
     
     public ArrayList<Fabricante> listar() throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT codigo, descricao ");
        sql.append("FROM fabricante ");
        sql.append("ORDER BY codigo ASC ");
        
        Connection conexao = ConexaoFactory.conectar();
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        ResultSet resultado = comando.executeQuery();
        ArrayList<Fabricante> lista = new ArrayList<Fabricante>();
        
        while(resultado.next()){
            Fabricante f = new Fabricante();
            f.setCodigo(resultado.getLong("codigo"));
            f.setDescricao(resultado.getString("descricao"));
            
            lista.add(f);
        }
        return lista;
     }    
     
     
     public ArrayList<Fabricante> buscarPorDescricao(Fabricante f) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT codigo, descricao ");
        sql.append("FROM fabricante ");
        sql.append("WHERE descricao LIKE ? ");
        sql.append("ORDER BY codigo ASC ");
        
        Connection conexao = ConexaoFactory.conectar();
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        comando.setString(1, "%" + f.getDescricao() + "%");
        ResultSet resultado = comando.executeQuery();
        ArrayList<Fabricante> lista = new ArrayList<Fabricante>();
        
        while(resultado.next()){
            Fabricante item = new Fabricante();
            item.setCodigo(resultado.getLong("codigo"));
            item.setDescricao(resultado.getString("descricao"));
            
            lista.add(item);
        }
        return lista;
     }    
   
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
    
     
     public static void main(String[] args){
       /*
       //SALVAR
         Fabricante f1 = new Fabricante();
        f1.setDescricao("Descrição 5");
        
        FabricanteDAO dao = new FabricanteDAO();
        
        try{
            dao.salvar(f1);
            System.out.println("Salvo com sucesso!");
        }catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("Não foi possível salvar!");
        }
       /*
       //EXCLUIR
       Fabricante f1 = new Fabricante();
       f1.setCodigo(2L);
       
       FabricanteDAO dao = new FabricanteDAO();
       
       try{
           dao.excluir(f1);
           System.out.println("Excluido com sucesso!");
       }catch(SQLException ex){
           ex.printStackTrace();
           System.out.println("Não foi possível excluir!");
       }
       
       //EDITAR
       Fabricante f1 = new Fabricante();
       f1.setCodigo(1L);
       f1.setDescricao("DESCRIÇÃO 1");
       
       FabricanteDAO dao = new FabricanteDAO();
       
       try{
           dao.editar(f1);
           System.out.println("Editado com sucesso!");
       }catch(SQLException ex){
           ex.printStackTrace();
           System.out.println("Não foi possível editar!");
       }
       
       //BuscarPorCodigo
       Fabricante f1 = new Fabricante();
       f1.setCodigo(1L);
              
       FabricanteDAO dao = new FabricanteDAO();
       
       try{
           Fabricante f2 = dao.buscarPorCodigo(f1);
           System.out.println("Resultado: " + f2);
       }catch(SQLException ex){
           ex.printStackTrace();
           System.out.println("Erro ao tentar pesquisar!");
       }
       
         //LISTAR
       FabricanteDAO dao = new FabricanteDAO();
       try{
           ArrayList<Fabricante> lista = dao.listar();
           for(Fabricante f : lista){
               System.out.println(f);
           }
       }catch(SQLException ex){
           ex.printStackTrace();
           System.out.println("Erro ao tentar listar!");
       }*/
       
       
       //buscarPorDescriçao
       Fabricante f1 = new Fabricante();
       f1.setDescricao("3");
       
       FabricanteDAO dao = new FabricanteDAO();
       
       try{
           ArrayList<Fabricante> lista = dao.buscarPorDescricao(f1);
           for(Fabricante f : lista){
               System.out.println(f);
           }
       }catch(SQLException ex){
           ex.printStackTrace();
           System.out.println("Ocorreu um erro ao tentar pesquisar!");
       }
       
    }    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.dao;

import br.edu.qi.conexao.ConnectionFactory;
import br.edu.qi.model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Diego
 */
public class ClienteRepository {
    

         public static void salvar(Pessoa pessoa) throws Exception {
        if (pessoa.getIdpessoa() == 0) {
            
            adcionar(pessoa);
            
        } else {
            alterar(pessoa);
        }
    }
     

    public static void adcionar(Pessoa pessoa) throws Exception {
        
        ConnectionFactory c = new ConnectionFactory();
        System.out.println("Chegou aqui DAO 1");
        if (pessoa == null) {
            throw new Exception("Erro: arquivo não pode ser em branco.");
        }

                    System.out.println("Chegou aqui DAO 2");
			//conn = new ConnectionFactory().getCon();
			String SQL = "INSERT INTO pessoa(nome , email, celular)"
                     + "values(?,?,?)"; 
                        
                        System.out.println("Chegou aqui DAO 3");   
    			
                        PreparedStatement ps = c.getCon().prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);  
                        System.out.println("Chegou aqui statement");  
			//ps.setInt(1, pessoa.getInstituicao().getIdinstituicao());
			 System.out.println("Chegou aqui depois statement");  
                         ps.setString(1, pessoa.getNome());
                         System.out.println("Chegou aqui DAO 4");
                         ps.setString(2, pessoa.getEmail());
                        System.out.println("Chegou aqui DAO 5");
                        ps.setString(3, pessoa.getCelular()); 
                          System.out.println("Chegou aqui DAO 6");			
                        ps.execute();
                        System.out.println("Chegou aqui DAO 7");
			c.confirmar();
                        System.out.println("Chegou a salvar");
                        
                         ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        int idpessoa = rs.getInt(1);
		
		 
	}
    
     public static void alterar(Pessoa pessoa) throws Exception {
        ConnectionFactory c = new ConnectionFactory();
        String sql = "UPDATE pessoa SET NOME=?, CELULAR=?, EMAIL=? WHERE idpessoa=?";
        PreparedStatement ps = c.getCon().prepareStatement(sql);
        ps.setString(1, pessoa.getNome());
        ps.setString(2, pessoa.getCelular());
        ps.setString(3, pessoa.getEmail());
        ps.setInt(4, pessoa.getIdpessoa());
        ps.execute();
        ps.close();
    }
    
    
    public ObservableList<Pessoa> listar()throws Exception {
		Connection conn;
		ObservableList<Pessoa> itens = FXCollections.observableArrayList();		
			conn = new ConnectionFactory().getCon();
			String sql = "select * from pessoa";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {                           
                            System.out.println("Chegou aqui lista 15");
				Pessoa pessoa = new Pessoa();                               
                                System.out.println("Chegou aqui lista 16");                                
				pessoa.setNome(rs.getString("nome"));
				pessoa.setCelular(rs.getString("celular"));
				pessoa.setEmail(rs.getString("email"));
                                System.out.println("Chegou aqui lista 17");
				itens.add(pessoa);
			}
                        System.out.println("Chegou aqui item");
		return itens;     
	}
    
    public static Pessoa recuperar(int codigo) throws Exception {
        System.out.println("Chegou aqui lista 18");
        ConnectionFactory c = new ConnectionFactory();
        System.out.println("Chegou aqui lista 19");
        String SQL = "SELECT * FROM pessoa WHERE idpessoa=?";
        System.out.println("Chegou aqui lista 20");
        PreparedStatement ps = c.getCon().prepareStatement(SQL);
        System.out.println("Chegou aqui lista 21");
        ps.setInt(1, codigo);
        System.out.println("Chegou aqui lista 22");
        ResultSet rs = ps.executeQuery();
        System.out.println("Chegou aqui lista 23");
        Pessoa pessoa = new Pessoa();
        System.out.println("Chegou aqui lista 24");
        if (rs.next()) {
            pessoa.setIdpessoa(rs.getInt("CODIGO"));
            pessoa.setNome(rs.getString("NOME"));
            pessoa.setCelular(rs.getString("CELULAR"));
            pessoa.setEmail(rs.getString("EMAIL"));
            System.out.println("Chegou aqui lista 25");
        }

        return pessoa;
    }
    
	public void excluir(Pessoa pessoa){
		Connection conn;
		try {
			conn = new ConnectionFactory().getCon();
			String sql = "DELETE FROM pessoa WHERE nome = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, pessoa.getNome());			
			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}	
}
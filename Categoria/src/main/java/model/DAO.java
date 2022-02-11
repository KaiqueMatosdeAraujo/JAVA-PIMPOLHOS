package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {

	public DAO() {
		
	}
	
	//                                           FORNECEDORES
	
	public void inserirCategoria(Categoria categoria) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("insert into categoria (nome_categoria) VALUES (?)");
			p.setString(1, categoria.getNome_categoria());
		   
			
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Categoria> exibir(){
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		ArrayList<Categoria> lista = new ArrayList<Categoria>();
		try {
			PreparedStatement p = con.prepareStatement("select * from categoria");
			ResultSet r = p.executeQuery();			
			
			while (r.next()) {
				Integer cod_categoria = r.getInt("cod_categoria");
				String nome_categoria = r.getString("nome_categoria");
				
			     
				Categoria categoria = new Categoria(nome_categoria);
				categoria.setCod_categoria(cod_categoria);
				lista.add(categoria);
			}
			r.close();
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	public void deletar(Integer id) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("delete from categoria where cod_categoria = ?");
			p.setInt(1, id);
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void atualizar(Categoria categoria) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("update categoria set nome_categoria = ?  where cod_categoria = ? ");
			p.setString(1, categoria.getNome_categoria());
			p.setInt(2, categoria.getCod_categoria());
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Categoria recuperarCategoria (Integer id) {	
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		Categoria u = null;
		try {
			PreparedStatement p = con.prepareStatement("select * from categoria where cod_categoria = ?");
			p.setInt(1, id);
			ResultSet r = p.executeQuery();			
			
			
			while (r.next()) {
				Integer id1 = r.getInt("cod_categoria");
				String nome_categoria = r.getString("nome_categoria");
				
				u = new Categoria(nome_categoria);
				u.setCod_categoria(id1);
			}
			r.close();
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	
//  CLIENTE
	
	
	
	
	
}

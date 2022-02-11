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
	
	public void inserirFornecedor(Fornecedor fornecedor) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("insert into fornecedor (nome_fornecedor) VALUES (?)");
			p.setString(1, fornecedor.getNome_fornecedor());
		   
			
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
	
	public ArrayList<Fornecedor> exibir(){
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		ArrayList<Fornecedor> lista = new ArrayList<Fornecedor>();
		try {
			PreparedStatement p = con.prepareStatement("select * from fornecedor");
			ResultSet r = p.executeQuery();			
			
			while (r.next()) {
				Integer cod_fornecedor = r.getInt("cod_fornecedor");
				String nome_fornecedor = r.getString("nome_fornecedor");
				
			     
				Fornecedor fornecedor = new Fornecedor(nome_fornecedor);
				fornecedor.setCod_forcenedor(cod_fornecedor);
				lista.add(fornecedor);
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
			PreparedStatement p = con.prepareStatement("delete from fornecedor where cod_fornecedor = ?");
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
	
	
	public void atualizar(Fornecedor fornecedor) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("update fornecedor set nome_fornecedor = ?  where cod_fornecedor = ? ");
			p.setString(1, fornecedor.getNome_fornecedor());
			p.setInt(2, fornecedor.getcod_fornecedor());
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
	public Fornecedor recuperarFornecedor (Integer id) {	
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		Fornecedor u = null;
		try {
			PreparedStatement p = con.prepareStatement("select * from fornecedor where cod_fornecedor = ?");
			p.setInt(1, id);
			ResultSet r = p.executeQuery();			
			
			
			while (r.next()) {
				Integer id1 = r.getInt("cod_fornecedor");
				String nome_fornecedor = r.getString("nome_fornecedor");
				
				u = new Fornecedor(nome_fornecedor);
				u.setCod_forcenedor(id1);
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

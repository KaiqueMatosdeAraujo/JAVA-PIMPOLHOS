package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {

	public DAO() {
		
	}
	
	//                                           CLIENTE
	
	public void inserir (Usuario usuario) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("insert into cliente nome_cliente,cpf,email,senha   values (?, ? , ?, ?)");
			p.setString(1, usuario.getNome());
		    p.setString(2, usuario.getCpf());
			//p.setDate(3,(Date) usuario.getNascimento());
			p.setString(3, usuario.getEmail());
		    p.setString(4, usuario.getSenha());
			
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
	
	public ArrayList<Usuario> exibir(){
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		try {
			PreparedStatement p = con.prepareStatement("select * from cliente");
			ResultSet r = p.executeQuery();			
			
			while (r.next()) {
				Integer id = r.getInt("id");
				String nome = r.getString("nome_cliente");
				String cpf = r.getString("cpf");
			//	Date data = r.getDate("data_nasc");
				String email = r.getString("email");
				String senha = r.getString("senha");
				Usuario usuario = new Usuario(nome,cpf,email,senha);
				usuario.setId(id);
				lista.add(usuario);
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
			PreparedStatement p = con.prepareStatement("delete from cliente where id = ?");
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
	
	//public void updateUser(Integer id, String newName) {
	public void atualizar(Usuario usuario) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("update cliente set nome_cliente =? , cpf = ?, email = ?, senha = ?  where id = ?");
			p.setString(1, usuario.getNome());
			p.setString(2, usuario.getCpf());
			//p.setDate(3, (Date) usuario.getNascimento());
			p.setString(3, usuario.getEmail());
			p.setString(4, usuario.getSenha());
			p.setInt(5, usuario.getId());
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
	public Usuario recuperarUsuario (Integer id) {	
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		Usuario u = null;
		try {
			PreparedStatement p = con.prepareStatement("select * from cliente where id = ?");
			p.setInt(1, id);
			ResultSet r = p.executeQuery();			
			
			
			while (r.next()) {
				Integer id1 = r.getInt("id");
				String nome = r.getString("nome_cliente");
				String cpf = r.getString("cpf");
			//	Date data = r.getDate("data_nasc");
				String email = r.getString("email");
				String senha = r.getString("senha");
				u = new Usuario (nome,cpf,email,senha);
				u.setId(id1);
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

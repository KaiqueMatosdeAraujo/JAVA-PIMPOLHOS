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
	
	///////////////////////////////////////////////////////////CLIENTE//////////////////////////////////////////
	
	//public void inserirUsuario (Usuario usuario) {
		//Conexao c = Conexao.getInstance();
		//Connection con = c.getConnection();
		
		//try {
		//	PreparedStatement p = con.prepareStatement("insert into cliente (nome_cliente, cpf, data_nasc,email,senha) VALUES (?,?,?,?,?)");
		//	p.setString(1, usuario.getNome());
		 //   p.setString(2, usuario.getCpf());
		//	p.setDate(3,(Date) usuario.getNascimento());
		//	p.setString(4, usuario.getEmail());
		  //  p.setString(5, usuario.getSenha());
			
			//System.out.println(p);
			//p.executeUpdate();
			//System.out.println("Comando executado");
			//p.close();
			//con.close();
		//} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
		
	//}
	
	public ArrayList<Usuario> exibirUsuarios(){
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		try {
			PreparedStatement p = con.prepareStatement("select * from cliente");
			ResultSet r = p.executeQuery();			
			
			while (r.next()) {
				Integer id = r.getInt("cod_cliente");
				String nome = r.getString("nome_cliente");
				String cpf = r.getString("cpf");
			     Date data = r.getDate("data_nasc");
				String email = r.getString("email");
				String senha = r.getString("senha");
				Usuario usuario = new Usuario(nome,cpf,data,email,senha);
				usuario.setCod_cliente(id);;
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
	
	//public void deletarUsuario(Integer id) {
		//Conexao c = Conexao.getInstance();
		//Connection con = c.getConnection();
		
		//try {
			//PreparedStatement a = con.prepareStatement("delete from endereco_cliente where cod_cliente = ?");
		   // a.setInt(1, id);
		   // System.out.println(a);
		    //a.executeUpdate();
		    //System.out.println("Comando executado");
		    
			//PreparedStatement p = con.prepareStatement("delete from cliente where cod_cliente = ?");
			//p.setInt(1, id);
			//System.out.println(p);
			//p.executeUpdate();
			//System.out.println("Comando executado");
			//p.close();
			//con.close();
		//} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
	//}
	
	
	//public void atualizarUsuario(Usuario usuario) {
		//Conexao c = Conexao.getInstance();
		//Connection con = c.getConnection();
		
		//try {
			//PreparedStatement p = con.prepareStatement("update cliente set nome_cliente = ? , cpf = ?, data_nasc = ?,email = ?, senha = ?  where cod_cliente = ? ");
			//p.setString(1, usuario.getNome());
			//p.setString(2, usuario.getCpf());
		    //p.setDate(3, (Date) usuario.getNascimento());
			//p.setString(4, usuario.getEmail());
			//p.setString(5, usuario.getSenha());
			//p.setInt(6, usuario.getCod_cliente());
			//System.out.println(p);
			//p.executeUpdate();
			//System.out.println("Comando executado");
			//p.close();
			//con.close();
		//} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
	//}
	
	public Usuario recuperarUsuario (Integer id) {	
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		Usuario u = null;
		try {
			PreparedStatement p = con.prepareStatement("select * from cliente where cod_cliente = ?");
			p.setInt(1, id);
			ResultSet r = p.executeQuery();			
			
			
			while (r.next()) {
				Integer id1 = r.getInt("cod_cliente");
				String nome = r.getString("nome_cliente");
				String cpf = r.getString("cpf");
		        Date data = r.getDate("data_nasc");
				String email = r.getString("email");
				String senha = r.getString("senha");
				u = new Usuario(nome, cpf, data, email, senha);
				u.setCod_cliente(id1);
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

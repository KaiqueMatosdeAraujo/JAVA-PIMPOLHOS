package model;
import java.lang.ref.WeakReference;

import java.util.ArrayList;

public class TesteConexao {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Teste de conexão
		Conexao c = new Conexao();
		c.getConnection();
		WeakReference ref = new WeakReference<Object>(c);
		c = null;
		//System.gc(); //Garbage Collector
		while(ref.get() != null) {
	       System.gc();
	       System.out.println(".");
	     }
		c = new Conexao();
		c.getConnection();
		
	}

}
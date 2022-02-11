package model;

	public class app {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			DAO maca = new DAO();
			System.out.println(maca.exibir());
			
			Fornecedor laranja = new Fornecedor("Jhonson & Jhonso 3n");
			maca.inserirFornecedor(laranja);
			System.out.println(maca.exibir());
			
			Fornecedor laranja1 = new Fornecedor("Jhonson & Jhonso 46");
			maca.atualizar(laranja1);
			System.out.println(maca.exibir());
			
//			User laranja1 = new User("Will", "Japão", "melao@rd.com.br");
//			maca.insert(laranja1);
//			System.out.println(maca.selectAll());
//			
//			maca.delete(2);
//			System.out.println(maca.selectAll());
//			
//			User laranja2 = new User("Muryllo", "Malásia", "uva@rd.com.br");
//			maca.insert(laranja2);
//			System.out.println(maca.selectAll());
//			
//			maca.delete(2);
//			System.out.println(maca.selectAll());
//			
//		   laranja.setCpf("7777");
//			maca.atualizar(laranja);;
//		    System.out.println(maca.exibir());
//			
//			User novo = maca.selectById(3);
//			System.out.println(novo);
//			
//			User novo1 = maca.selectById(10);
//			System.out.println(novo1);
		}

		}

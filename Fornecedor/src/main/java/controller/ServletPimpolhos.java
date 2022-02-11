package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import model.DAO;
import model.Fornecedor;


/**
 * Servlet implementation class ServletPimpolhos
 */
@WebServlet("/ServletPimpolhos")
public class ServletPimpolhos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private DAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPimpolhos() {
        super();
        // TODO Auto-generated constructor stub
        this.dao = new DAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		String option = request.getParameter("option");
		if (option == null) {
			option = "Opção Invalida";
		}
		switch(option) {
			case ("insertForm"):
				showInsertUser(request, response);
			break;
			case ("updateForm"):
				showUpdateUser(request, response);
			break;
			case ("update"):
				updateUser(request, response);
			break;
			case ("delete"):
				deleteUser(request, response);
			break;
			case ("insert"):
				inserirFornecedor(request, response);
			break;
			default:
				selectAllFornecedores(request, response);
		}
		
	}

	
	
	private void showInsertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("form.jsp").forward(request, response);
	}
	
	private void showUpdateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer id = Integer.parseInt(request.getParameter("cod_fornecedor"));
		Fornecedor fornecedor = this.dao.recuperarFornecedor(id);
		request.setAttribute("fornecedor", fornecedor);
		request.getRequestDispatcher("form.jsp").forward(request, response);
		
//		Integer id = Integer.parseInt(request.getParameter("id"));
//		User u = this.cont.selectById(id);
//		request.setAttribute("user", u);
//		request.getRequestDispatcher("form.jsp").forward(request, response);
	}
	
	private void inserirFornecedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String nomeFornecedorBack = request.getParameter("name");
		
		
		if ( nomeFornecedorBack != null) {
			if (!nomeFornecedorBack.equals("")){
				Fornecedor fornecedor1 = new Fornecedor (nomeFornecedorBack);
				this.dao.inserirFornecedor(fornecedor1);
	}
		}
		response.sendRedirect("ServletPimpolhos");
	}
	
	private void selectAllFornecedores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		request.setAttribute("listUser", this.dao.exibir());
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idBack = request.getParameter("cod_fornecedor");
		if (idBack != null) {
			Integer id = Integer.parseInt(idBack);
			this.dao.deletar(id);
		}
		response.sendRedirect("ServletPimpolhos");
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idBack = request.getParameter("cod_fornecedor");
		String nomefornecedorBack = request.getParameter("name");
		
		
		if ((nomefornecedorBack != null)) {
			if (!nomefornecedorBack.equals("")){
				Integer id = Integer.parseInt(idBack);
				Fornecedor fornecedor = new Fornecedor (nomefornecedorBack );
				fornecedor.setCod_forcenedor(id);
				this.dao.atualizar(fornecedor);
			}
		}
	
		response.sendRedirect("ServletPimpolhos");
	}
	
	
	
}

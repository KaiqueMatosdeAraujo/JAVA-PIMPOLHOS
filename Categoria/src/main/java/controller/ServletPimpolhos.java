package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import model.DAO;
import model.Categoria;


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
				showInsertCategoria(request, response);
			break;
			case ("updateForm"):
				showUpdateCategoria(request, response);
			break;
			case ("update"):
				updateUser(request, response);
			break;
			case ("delete"):
				deleteUser(request, response);
			break;
			case ("insert"):
				inserirCategoria(request, response);
			break;
			default:
				selectAllCategoria(request, response);
		}
		
	}

	
	
	private void showInsertCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("form.jsp").forward(request, response);
	}
	
	private void showUpdateCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer id = Integer.parseInt(request.getParameter("cod_categoria"));
		Categoria categoria = this.dao.recuperarCategoria(id);
		request.setAttribute("categoria", categoria);
		request.getRequestDispatcher("form.jsp").forward(request, response);
		
//		Integer id = Integer.parseInt(request.getParameter("id"));
//		User u = this.cont.selectById(id);
//		request.setAttribute("user", u);
//		request.getRequestDispatcher("form.jsp").forward(request, response);
	}
	
	private void inserirCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String nomeCategoriaBack = request.getParameter("name");
		
		
		if ( nomeCategoriaBack != null) {
			if (!nomeCategoriaBack.equals("")){
				Categoria categoria1 = new Categoria (nomeCategoriaBack);
				this.dao.inserirCategoria(categoria1);
	}
		}
		response.sendRedirect("ServletPimpolhos");
	}
	
	private void selectAllCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		request.setAttribute("listUser", this.dao.exibir());
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idBack = request.getParameter("cod_categoria");
		if (idBack != null) {
			Integer id = Integer.parseInt(idBack);
			this.dao.deletar(id);
		}
		response.sendRedirect("ServletPimpolhos");
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idBack = request.getParameter("cod_categoria");
		String nomeCategoriaBack = request.getParameter("name");
		
		
		if ((nomeCategoriaBack != null)) {
			if (!nomeCategoriaBack.equals("")){
				Integer id = Integer.parseInt(idBack);
				Categoria categoria = new Categoria (nomeCategoriaBack );
				categoria.setCod_categoria(id);
				this.dao.atualizar(categoria);
			}
		}
	
		response.sendRedirect("ServletPimpolhos");
	}
	
	
	
}

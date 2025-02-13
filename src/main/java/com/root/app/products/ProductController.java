package com.root.app.products;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.root.app.ActionForward;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductService productService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        productService = new ProductService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ActionForward actionForward = new ActionForward();
//		actionForward.setFlag(true);
//		actionForward.setPath("/WEB-INF/views/errors/notfound.jsp");
		
		try {
			String uri = request.getRequestURI();
			uri = uri.substring(uri.lastIndexOf("/")+1);
			
			switch (uri) {
			case "list.do":
				productService.getList(request, actionForward);
				
				break;
			case "detail.do" :
				productService.getDetail(request, actionForward);
				
				break;
			case "add.do" :
				String method = request.getMethod();
				if(method.equalsIgnoreCase("post")){
					productService.add(request, actionForward);
				}else {
					actionForward.setFlag(true);
					actionForward.setPath("/WEB-INF/views/products/add.jsp");
				}
				break;
			case "update.do" :
				method = request.getMethod();
				if(method.equalsIgnoreCase("post")) {
					productService.updateProcess(request, actionForward);
				}else {
					
					actionForward.setFlag(true);
					actionForward.setPath("/WEB-INF/views/products/update.jsp");
					
				}
				break;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		if(actionForward.isFlag()) {
			RequestDispatcher view = request.getRequestDispatcher(actionForward.getPath());
			view.forward(request, response);			
//		}else {
//			// redirect
//			response.sendRedirect(actionForward.getPath());
//		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

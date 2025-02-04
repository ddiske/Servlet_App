package com.root.app.departments;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DepartmentController
 */
@WebServlet("/DepartmentController")
public class DepartmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 서버 요청시
	 * 	1. URL(ip:port/경로)
	 * 	2. 메서드 형식
	 * 		1) GET
	 * 			* 단순 요청시
	 * 			* 파라미터가 주소창에 노출(파라미터가 Header에 담김)
	 * 			* 작은 용량을 보낼 때 사용
	 * 		2) POST
	 * 			* 보안이 요구되는 요청시
	 * 			* 파라미터가 주소창에 노출되지 않음 (파라미터가 Body에 담김)
	 * 			* 큰 용량을 보낼 때 사용
	 * 
	 * 	3. 메서드 결정
	 * 		1) 주소창에 URL 직접 입력 - GET
	 * 		2) a 태그 사용 - GET
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
		// TODO Auto-generated method stub
		String method = request.getMethod();
		StringBuffer sb = request.getRequestURL();
		String uri = request.getRequestURI();
		System.out.println(method);
		System.out.println(sb.toString());
		System.out.println(uri);
		
		DepartmentDAO departmentDAO = new DepartmentDAO();
		String [] str = uri.split("/");
		String st = str [str.length-1];
		System.out.println(st);
		this.useSubString(uri);
		
		if(st.equals("list.do")) {
			List<DepartmentDTO> ar = departmentDAO.getList();
			
			PrintWriter p = response.getWriter();
			p.println("<h1>Department List</h1>");
			
			p.println("<h3>");
			p.println(ar.get(0).getDepartment_id());
			p.println("</h3>");
			
			p.println("<h3>"+ar.get(0).getDepartment_name()+"</h3>");
			
			
			for(int i = 0; i < ar.size(); i++) {
				p.println("<h3>"+ar.get(i).getDepartment_id()+"\t"+ar.get(i).getDepartment_name()+"</h3>");
			}
			
			p.println("<table border=1>");
			p.println("<thead>");
			p.println("<tr>");
			p.println("<th>Department_ID</th>");
			p.println("<th>Department_Name</th>");
			p.println("</tr");
			p.println("</thead>");
			for(int i = 0; i < ar.size(); i++) {
				p.println("<tr>");
				p.println("<td>"+ar.get(i).getDepartment_id()+"</td>");
				p.println("<td>"+ar.get(i).getDepartment_name()+"</td>");
				p.println("</tr>");
			}
			p.println("</table>");
			
			p.close();
			
		}else if(st.equals("detail.do")) {
			departmentDAO.getDetail();
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void useSubString(String data) {
		String result = data.substring(data.lastIndexOf("/")+1);
		System.out.println(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.root.app.employees;

import javax.servlet.http.HttpServletRequest;

import com.root.app.ActionForward;

public class EmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	public EmployeeService() {
		employeeDAO = new EmployeeDAO();
	}
	
	public void add(HttpServletRequest request, ActionForward actionForward) throws Exception {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setCommission_pct(Double.parseDouble(request.getParameter("commission_pct")));
		employeeDTO.setDepartment_id(Integer.parseInt(request.getParameter("department_id")));
		employeeDTO.setEmail(request.getParameter("email"));
		employeeDTO.setEmployee_id(Integer.parseInt(request.getParameter("manager_id")));
		employeeDTO.setFirst_name(request.getParameter("first_name"));
		employeeDTO.setJob_id(request.getParameter("job_id"));
		employeeDTO.setLast_name(request.getParameter("last_name"));
		employeeDTO.setManager_id(Integer.parseInt(request.getParameter("manager_id")));
		employeeDTO.setPassword(request.getParameter("password"));
		employeeDTO.setPhone_number(request.getParameter("phone_number"));
		employeeDTO.setSalary(Double.parseDouble(request.getParameter("salary")));
		
		int result = employeeDAO.add(employeeDTO);
		String str = "등록 실패";
		
		if(result > 0) {
			str = "등록 완료";
		}
		
		request.setAttribute("result", str);
		actionForward.setFlag(true);
		actionForward.setPath("/WEB-INF/views/commons/result.jsp");
		
	}
	
	public void login(HttpServletRequest request, ActionForward actionForward) throws Exception {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmployee_id(Integer.parseInt(request.getParameter("employee_id")));
		employeeDTO.setPassword(request.getParameter("password"));
		employeeDTO = employeeDAO.login(employeeDTO);
		
		if(employeeDTO != null) {
			// /index.do
			actionForward.setFlag(false);
			actionForward.setPath("../index.do");
		}else {
			request.setAttribute("result", "로그인 실패");
			request.setAttribute("path", "./login.do");
			actionForward.setFlag(true);
			actionForward.setPath("/WEB-INF/views/commons/result.jsp");
		}
		
	}

}

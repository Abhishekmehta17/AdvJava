package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Employee;
import com.app.service.EmployeeService;

@Controller
@RequestMapping("/emps")
public class EmployeeController {
	@Autowired
	private EmployeeService empService;
	public EmployeeController() {
		System.out.println("in const of " + getClass());
	}

	/*
	 * http://host:port/day14_boot/emps/list ,method = post payload(req body ) :
	 * dept_id = 1
	 */
	//@requestParam :annotation to bind incoming request parametr --> method argument , does the parsing also!
	//MATCH request parameter name with method arg name
	//SC : Long dept_id = long.parseLong(request.getParameter ("dept_id"))
	@PostMapping("/list")
	public String listEmpsByDept(@RequestParam Long dept_id ,Model modelMap) {
		System.out.println("in list emps by dept "+ dept_id);
		modelMap.addAttribute("emp_list",empService.getAllEmpsByDeptId(dept_id));
		return "/emps/list";// AVN : /WEB-INF/views/emp/list.jsp

	}
	//url : http://host:port/day14_boot/emps/login , method=get
	@GetMapping("/signin")
	public String showLoginForm(){
		System.out.println("in show login form ");
		return "/emps/login";//AVM :/WEB-INF/views/emp/login.jsp
	}
	//url : http://host:port/day14_boot/emps/signin, method=post
	@PostMapping("/signin")
	public String processLoginform(@RequestParam String email,@RequestParam String password,Model mapEmail) {
		System.out.println("in process login form " +email+" "+password);
		//EmployeeService obj to authenticate it 
		Employee emp = empService.authenticateEmp(email, password);
		if (emp != null)//vaild login --> forword to the client  
		{
			mapEmail.addAttribute("emp_dtls",emp);
			return "/emps/details";//AVM :/WEB-INF/views/emps/details.jsp 
		}
		//invalid login 
		return "/emps/login";
	}
	

}

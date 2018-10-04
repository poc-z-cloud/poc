package poc.restful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import poc.domain.Employee;

@Controller
public class EmployeeController {
	
	@Autowired private RestTemplate restTemplate;
	@RequestMapping("/")
    public String employee(Model model) {
//		Employee employee = new Employee();
//		employee.setFirstName("jason");
//		employee.setLastName("Gu");
		
//		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("admin","admin"));
		String url="http://localhost:8000/employee";
		Employee employee = restTemplate.getForObject(url, Employee.class);
//		String url="http://localhost:8000/name";
//		String name = restTemplate.getForObject(url, String.class);
//
//		Employee employee = new Employee();
//		employee.setFirstName(name);
		
    	model.addAttribute("employee", employee);
        return "employee";
    }

}

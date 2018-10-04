package poc.restful.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poc.domain.Employee;

@RestController
public class EmployeeController
{
    @RequestMapping("/employee")
    public Employee getEmployee()
    {
        Employee employees = new Employee(1,"lokesh","gupta","howtodoinjava@gmail.com");
        return employees;
    }

    @RequestMapping("/name")
    public String getName()
    {
        return "Jon Snow";
    }

}
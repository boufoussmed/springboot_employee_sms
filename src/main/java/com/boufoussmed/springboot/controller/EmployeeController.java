package com.boufoussmed.springboot.controller;

import com.boufoussmed.springboot.entity.Employee;
import com.boufoussmed.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping
    public String viewHomePage(Model model) {
        model.addAttribute("employeesListModel", this.employeeService.getAllEmployees());
        return "employeesListView";
    }

    @GetMapping("/add")
    public String addEmployee(Model model) {
        model.addAttribute("employee", new Employee());

        return "addEmployeeView";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

        this.employeeService.saveEmployee(employee);

        return "redirect:/employee?msg=success";
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable("id") Long id, Model model) {

        Employee employee = this.employeeService.getEmployeeById(id);

        model.addAttribute("employee", employee);

        if (!employee.equals(null))
            return "editEmployeeView";
        return null;
    }

    @PostMapping("/edit/{id}")
    public String editEmployee(@PathVariable("id") Long id, @ModelAttribute("employee") Employee employee) {

        Employee employee1 = employeeService.getEmployeeById(id);

        if (!employee1.equals(null)) {
            employeeService.saveEmployee(employee);
            return "redirect:/employee?msg=success";
        }

        return "redirect:/employee?msg=error";

    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {

        employeeService.deleteEmployee(id);

        return "redirect:/employee?msg=success";
    }

}

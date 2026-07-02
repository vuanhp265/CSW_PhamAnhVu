package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmployeeWebController {
    private final EmployeeService employeeService;

    public EmployeeWebController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping({"/", "/employees"})
    public String index(Model model) {
        model.addAttribute("employees", employeeService.getEmployees());
        model.addAttribute("newEmployee", new Employee());
        model.addAttribute("updateEmployee", new Employee());
        return "employees";
    }

    @PostMapping("/employees/add")
    public String addEmployee(@Valid @ModelAttribute("newEmployee") Employee employee,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {
        try {
            if (bindingResult.hasErrors()) {
                redirectAttributes.addFlashAttribute("error", "Invalid data. Please check id, name and salary.");
                return "redirect:/employees";
            }
            employeeService.addEmployees(employee);
            redirectAttributes.addFlashAttribute("success", "Employee added successfully.");
        } catch (IllegalArgumentException ex) {
            redirectAttributes.addFlashAttribute("error", ex.getMessage());
        }
        return "redirect:/employees";
    }

    @PostMapping("/employees/update")
    public String updateEmployee(@Valid @ModelAttribute("updateEmployee") Employee employee,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {
        try {
            if (bindingResult.hasErrors()) {
                redirectAttributes.addFlashAttribute("error", "Invalid data. Please check id, name and salary.");
                return "redirect:/employees";
            }
            employeeService.updateEmployee(employee);
            redirectAttributes.addFlashAttribute("success", "Employee updated successfully.");
        } catch (IllegalArgumentException ex) {
            redirectAttributes.addFlashAttribute("error", ex.getMessage());
        }
        return "redirect:/employees";
    }
}

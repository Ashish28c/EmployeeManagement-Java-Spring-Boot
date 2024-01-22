package com.springboot.EmpManagement.controller;

import java.util.List;
import java.util.Optional;

import com.springboot.EmpManagement.Repository.empRepo;
import com.springboot.EmpManagement.entity.employee;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class EmpController {

    @Autowired
    private empRepo empRepo;

    @GetMapping("/")
    public String home(Model model) {
        List<employee> emp = empRepo.findAll();
        model.addAttribute("emp", emp);
        return "index";
    }

    @GetMapping("/add")
    public String add() {
        return "addemp";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute employee e) {
        System.out.println(e);
        empRepo.save(e);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        Optional<employee> optionalEmployee = empRepo.findById(id);
        optionalEmployee.ifPresent(employee -> model.addAttribute("empObj", employee));
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("empObj") employee e) {
        empRepo.save(e);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        empRepo.deleteById(id);
        return "redirect:/";
    }
}

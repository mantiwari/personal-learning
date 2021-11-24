package com.company.Controller;

import com.company.Model.Employee;
import com.company.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService empservice;

    @RequestMapping("/")
    public String index(){
        return "welcome";
    }

    @RequestMapping("/addpage")
    public String addpage() {
        return "addpage";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(@RequestParam String name,@RequestParam String role, @RequestParam String current_project, @RequestParam String contact){
        Employee emp = new Employee();
        emp.setName(name);
        emp.setContact(contact);
        emp.setCurrent_project(current_project);
        emp.setRole(role);
        empservice.addEmployee(emp);
        return "welcome";
    }


    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public  String  show(Model model){
       model.addAttribute("list",empservice.showEmployee());
       return  "show";
    }

    @ResponseBody
    @RequestMapping(value="/update",method=RequestMethod.POST)
    public String update(@RequestParam String name,@RequestParam String role, @RequestParam String current_project, @RequestParam String contact,@RequestParam Long id){
       Employee emp = empservice.updateEmployee(id);
      // emp.setId(id);
       emp.setName(name);
       emp.setCurrent_project(current_project);
       emp.setRole(role);
       emp.setContact(contact);
       empservice.addEmployee(emp);
       return "updated";
    }

    @RequestMapping("/delete")
    public String showdeletepage(){return"delete";}

   @RequestMapping(value="/deleteuser",method=RequestMethod.GET)
    public String delete(@RequestParam String id){
       Long cid = Long.parseLong(id);
        empservice.deleteEmployee(cid);
        return "welcome";
    }

}

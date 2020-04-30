package com.jun.managementsystem.controller;

import com.jun.managementsystem.dao.DepartmentDao;
import com.jun.managementsystem.dao.EmployeeDao;
import com.jun.managementsystem.pojo.Department;
import com.jun.managementsystem.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    /**
     * 查询所有员工信息
     * @param model
     * @return
     */
    @RequestMapping("/emps")
    public String list(Model model){
     Collection<Employee> employees = employeeDao.getAll();
     model.addAttribute("emps",employees);
     return "emp/list";
    }

    /**
     * 转到添加员工页面
     * @param model
     * @return
     */
    @GetMapping("/add")
    public String toAddPage(Model model){
        //查出所有部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    /**
     * 添加员工
     * @param employee
     * @return
     */
    @PostMapping("/addEmp")
    public String addEmp(Employee employee){
        employeeDao.save(employee);//保存员工信息
        return "redirect:/emps";
    }

    /**
     * 转到更新员工信息页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/updEmp/{id}")
    public String toUpdateEmp(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("emp",employee);
        //查出部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/update";
    }

    /**
     *更新员工信息
     * @param employee
     * @return
     */
    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 删除员工
     * @param id
     * @return
     */
    @GetMapping("/delemp/{id}")
    public String delEmp(@PathVariable("id") int id){
        employeeDao.detele(id);
        return "redirect:/emps";
    }
}

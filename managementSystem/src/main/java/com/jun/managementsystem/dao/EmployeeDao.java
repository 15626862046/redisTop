package com.jun.managementsystem.dao;


import com.jun.managementsystem.pojo.Department;
import com.jun.managementsystem.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//员工dao
@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;
    @Autowired
    private DepartmentDao departmentDao;
    static {
        employees = new HashMap<>();
        employees.put(1001,new Employee(1001,"AA","731177205@qq.COM",1,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"BB","731177203@qq.COM",0,new Department(102,"市场部")));
        employees.put(1003,new Employee(1003,"CC","731177201@163.COM",1,new Department(103,"教研部")));
        employees.put(1004,new Employee(1004,"DD","731177202@163.COM",0,new Department(104,"运维部")));
        employees.put(1005,new Employee(1005,"EE","731177204@163.COM",1,new Department(105,"技术部")));
    }
    //主键自增
    private static Integer initid=1006;
    //增加一个员工
    public void save(Employee employee){
        if (employee.getId()==null){
            employee.setId(initid++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }
    //查询全部员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }
    //通过ID查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }
    //删除员工通过ID
    public void detele(Integer id){
        employees.remove(id);
    }
}

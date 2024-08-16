package org.example;

import org.example.model.dao.DaoFactory;
import org.example.model.dao.DepartmentDao;
import org.example.model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class DepartmentTest {

    public static void main(String[] args) {

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== TEST 1: insert ===");
        Department newDepartment = new Department(null, "New Department");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! new Id = " + newDepartment.getId());

        System.out.println();
        System.out.println("=== TEST 2: findById ===");
        Department department = departmentDao.findById(3);

        System.out.println(department);

        System.out.println();
        System.out.println("=== TEST 3: update ===");
        department = departmentDao.findById(7);
        department.setName("DEPPP");
        departmentDao.update(department);
        System.out.println("Update Completed");

        System.out.println();
        System.out.println("=== TEST 4: delete ===");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");

        sc.close();

        System.out.println();
        System.out.println("=== TEST 5: findAll ===");
        List<Department> departmentList  = departmentDao.findAll();
        for (Department department1 : departmentList) {

            System.out.println(department1);

        }

    }

}

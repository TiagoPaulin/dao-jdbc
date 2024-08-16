package org.example;

import org.example.model.dao.DaoFactory;
import org.example.model.dao.DepartmentDao;
import org.example.model.entities.Department;
import org.example.model.entities.Seller;

import java.util.Date;

public class DepartmentTest {

    public static void main(String[] args) {

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println();
        System.out.println("=== TEST 1: insert ===");
        Department newDepartment = new Department(null, "New Department");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! new Id = " + newDepartment.getId());

    }

}

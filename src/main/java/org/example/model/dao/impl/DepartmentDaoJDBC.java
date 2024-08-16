package org.example.model.dao.impl;

import org.example.model.dao.DepartmentDao;
import org.example.model.entities.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection connection = null;

    public DepartmentDaoJDBC(Connection connection) {

        this.connection = connection;

    }

    @Override
    public void insert(Department obj) {

    }

    @Override
    public void update(Department obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Department findById(Integer id) {
        return null;
    }

    @Override
    public List<Department> findAll() {
        return null;
    }
}

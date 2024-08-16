package org.example.model.dao.impl;

import org.example.db.DB;
import org.example.db.DbException;
import org.example.model.dao.DepartmentDao;
import org.example.model.entities.Department;

import java.sql.*;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection connection = null;

    public DepartmentDaoJDBC(Connection connection) {

        this.connection = connection;

    }

    @Override
    public void insert(Department obj) {

        PreparedStatement preparedStatement = null;

        try {

            preparedStatement = connection.prepareStatement(
                    "INSERT INTO department " +
                            "(Name) " +
                            "VALUES " +
                            "(?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            preparedStatement.setString(1, obj.getName());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {

                ResultSet resultSet = preparedStatement.getGeneratedKeys();

                if (resultSet.next()) {

                    int id = resultSet.getInt(1);
                    obj.setId(id);

                }

                DB.closeResultSet(resultSet);

            }

        } catch (SQLException e) {

            throw new DbException(e.getMessage());

        } finally {

            DB.closeStatement(preparedStatement);

        }

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

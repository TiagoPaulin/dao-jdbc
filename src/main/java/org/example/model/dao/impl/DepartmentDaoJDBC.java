package org.example.model.dao.impl;

import org.example.db.DB;
import org.example.db.DbException;
import org.example.model.dao.DepartmentDao;
import org.example.model.entities.Department;
import org.example.model.entities.Seller;

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

        PreparedStatement preparedStatement = null;

        try {

            preparedStatement = connection.prepareStatement(
                    "UPDATE department " +
                            "SET Name = ? " +
                            "WHERE Id = ?"
            );

            preparedStatement.setString(1, obj.getName());
            preparedStatement.setInt(2, obj.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {

            throw new DbException(e.getMessage());

        } finally {

            DB.closeStatement(preparedStatement);

        }

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Department findById(Integer id) {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            preparedStatement = connection.prepareStatement(
                    "SELECT * " +
                            "FROM department " +
                            "WHERE Id = ?"
            );

            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                Department department = instantiateDepartment(resultSet);

                return department;

            }

            return null;

        } catch (SQLException e) {

            throw new DbException(e.getMessage());

        } finally {

            DB.closeStatement(preparedStatement);
            DB.closeResultSet(resultSet);

        }

    }

    @Override
    public List<Department> findAll() {
        return null;
    }

    private Department instantiateDepartment(ResultSet resultSet) throws SQLException {

        Department department = new Department();
        department.setId(resultSet.getInt("Id"));
        department.setName(resultSet.getString("Name"));

        return department;

    }

}

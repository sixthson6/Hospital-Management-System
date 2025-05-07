package manage.hospital.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manage.hospital.model.Employee;

public class EmployeeDAO {

    public void insertEmployee(Employee employee) {
        String sql = "INSERT INTO Employee (id, surname, first_name, address, phone) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, employee.getEmployeeId());
            stmt.setString(2, employee.getSurname());
            stmt.setString(3, employee.getFirstName());
            stmt.setString(4, employee.getAddress());
            stmt.setString(5, employee.getPhone());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error inserting employee: " + e.getMessage());
        }
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM Employee";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Employee emp = new Employee(
                    rs.getInt("id"),
                    rs.getString("surname"),
                    rs.getString("first_name"),
                    rs.getString("address"),
                    rs.getString("phone")
                );
                employees.add(emp);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching employees: " + e.getMessage());
        }

        return employees;
    }

    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM Employee WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Employee(
                        rs.getInt("id"),
                        rs.getString("surname"),
                        rs.getString("first_name"),
                        rs.getString("address"),
                        rs.getString("phone")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error fetching employee by ID: " + e.getMessage());
        }
        return null;
    }

    public void updateEmployee(Employee employee) {
        String sql = "UPDATE Employee SET surname = ?, first_name = ?, address = ?, phone = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, employee.getSurname());
            stmt.setString(2, employee.getFirstName());
            stmt.setString(3, employee.getAddress());
            stmt.setString(4, employee.getPhone());
            stmt.setInt(5, employee.getEmployeeId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updating employee: " + e.getMessage());
        }
    }

    public void deleteEmployee(int id) {
        String sql = "DELETE FROM Employee WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting employee: " + e.getMessage());
        }

    }
}


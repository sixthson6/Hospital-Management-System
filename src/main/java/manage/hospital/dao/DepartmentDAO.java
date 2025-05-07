package manage.hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manage.hospital.model.Department;

public class DepartmentDAO {
    public void insertDepartment(Department department) {
        String sql = "INSERT INTO Department (code, name, building, director_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, department.getDepartmentCode());
            stmt.setString(2, department.getName());
            stmt.setString(3, department.getBuilding());
            stmt.setInt(4, department.getDirectorId());
            stmt.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<>();
        String sql = "SELECT * FROM Department";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Department dep = new Department(
                    rs.getInt("code"),
                    rs.getString("name"),
                    rs.getString("building"),
                    rs.getInt("director_id")
                );
                departments.add(dep);
            }
        } catch (SQLException e) {
        }
        return departments;
    }
}


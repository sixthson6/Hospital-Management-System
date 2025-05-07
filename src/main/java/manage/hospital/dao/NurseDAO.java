package manage.hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manage.hospital.model.Nurse;

public class NurseDAO {
    public void insertNurse(Nurse nurse) {
        String sql = "INSERT INTO Nurse (employee_id, rotation, salary, department_code) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, nurse.getEmployeeId());
            stmt.setString(2, nurse.getRotation());
            stmt.setDouble(3, nurse.getSalary());
            stmt.setInt(4, nurse.getDepartmentCode());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error inserting nurse: " + e.getMessage());
        }
    }

    public List<Nurse> getAllNurses() {
        List<Nurse> nurses = new ArrayList<>();
        String sql = "SELECT e.*, n.rotation, n.salary, n.department_code " +
                     "FROM Employee e JOIN Nurse n ON e.employee_id = n.employee_id";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Nurse nurse = new Nurse(
                    rs.getInt("employee_id"),
                    rs.getString("surname"),
                    rs.getString("first_name"),
                    rs.getString("address"),
                    rs.getString("phone"),
                    rs.getString("rotation"),
                    rs.getDouble("salary"),
                    rs.getInt("department_code")
                );
                nurses.add(nurse);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching nurses: " + e.getMessage());
        }
        return nurses;
    }
}


package manage.hospital.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manage.hospital.model.Doctor;

public class DoctorDAO {
    public void insertDoctor(Doctor doctor) {
        String sql = "INSERT INTO Doctor (employee_id, speciality) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, doctor.getEmployeeId());
            stmt.setString(2, doctor.getSpeciality());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error inserting doctor: " + e.getMessage());
        }
    }

    public List<Doctor> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        String sql = "SELECT e.*, d.speciality FROM Employee e JOIN Doctor d ON e.employee_id = d.employee_id";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Doctor doctor = new Doctor(
                    rs.getInt("employee_id"),
                    rs.getString("surname"),
                    rs.getString("first_name"),
                    rs.getString("address"),
                    rs.getString("phone"),
                    rs.getString("speciality")
                );
                doctors.add(doctor);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching doctors: " + e.getMessage());
        }
        return doctors;
    }
}



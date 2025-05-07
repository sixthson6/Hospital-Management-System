package manage.hospital.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manage.hospital.model.Ward;

public class WardDAO {
    public void insertWard(Ward ward) {
        String sql = "INSERT INTO Ward (ward_id, ward_number, department_code, number_of_beds, supervisor_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ward.getWardId());
            stmt.setInt(2, ward.getWardNumber());
            stmt.setInt(3, ward.getDepartmentCode());
            stmt.setInt(4, ward.getNumberOfBeds());
            stmt.setInt(5, ward.getSupervisorId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error inserting ward: " + e.getMessage());
        }
    }

    public List<Ward> getAllWards() {
        List<Ward> wards = new ArrayList<>();
        String sql = "SELECT * FROM Ward";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Ward ward = new Ward(
                    rs.getInt("ward_id"),
                    rs.getInt("ward_number"),
                    rs.getInt("department_code"),
                    rs.getInt("number_of_beds"),
                    rs.getInt("supervisor_id")
                );
                wards.add(ward);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching wards: " + e.getMessage());
        }
        return wards;
    }
}


package manage.hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manage.hospital.model.Patient;

public class PatientDAO {

    public void insertPatient(Patient patient) {
        String sql = "INSERT INTO Patient (patient_id, surname, first_name, address, phone) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, patient.getId());
            stmt.setString(2, patient.getSurname());
            stmt.setString(3, patient.getFirstName());
            stmt.setString(4, patient.getAddress());
            stmt.setString(5, patient.getPhone());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error inserting patient: " + e.getMessage());
        }
    }

    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM Patient";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Patient p = new Patient(
                    rs.getInt("patient_id"),
                    rs.getString("surname"),
                    rs.getString("first_name"),
                    rs.getString("address"),
                    rs.getString("phone")
                );
                patients.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching patients: " + e.getMessage());
        }
        return patients;
    }

    public void updatePatient(Patient patient) {
        String sql = "UPDATE Patient SET surname = ?, first_name = ?, address = ?, phone = ? WHERE patient_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, patient.getSurname());
            stmt.setString(2, patient.getFirstName());
            stmt.setString(3, patient.getAddress());
            stmt.setString(4, patient.getPhone());
            stmt.setInt(5, patient.getId());
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Patient updated successfully.");
            } else {
                System.out.println("⚠️ Patient not found for update.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating patient: " + e.getMessage());
        }
    }

    public void deletePatient(int patientId) {
        String sql = "DELETE FROM Patient WHERE patient_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, patientId);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("🗑️ Patient deleted successfully.");
            } else {
                System.out.println("⚠️ Patient not found for deletion.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting patient: " + e.getMessage());
        }
    }
}

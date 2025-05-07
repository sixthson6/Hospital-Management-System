package manage.hospital.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manage.hospital.model.Hospitalization;

public class HospitalizationDAO {

    public void admitPatient(Hospitalization hospitalization) {
        String sql = "INSERT INTO Hospitalization (patient_id, ward_id, bed_number, diagnosis, doctor_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, hospitalization.getPatientId());
            stmt.setInt(2, hospitalization.getWardId());
            stmt.setInt(3, hospitalization.getBedNumber());
            stmt.setString(4, hospitalization.getDiagnosis());
            stmt.setInt(5, hospitalization.getDoctorId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error admitting patient: " + e.getMessage());
        }
    }

    public void transferPatient(int patientId, int newWardId, int newBedNumber) {
        String sql = "UPDATE Hospitalization SET ward_id = ?, bed_number = ? WHERE patient_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, newWardId);
            stmt.setInt(2, newBedNumber);
            stmt.setInt(3, patientId);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error transferring patient: " + e.getMessage());
        }
    }

    public List<Hospitalization> getAllHospitalizations() {
        List<Hospitalization> list = new ArrayList<>();
        String sql = "SELECT * FROM Hospitalization";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Hospitalization h = new Hospitalization(
                    rs.getInt("patient_id"),
                    rs.getInt("ward_id"),
                    rs.getInt("bed_number"),
                    0, rs.getString("diagnosis"),
                    rs.getInt("doctor_id"), null, null
                );
                list.add(h);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching hospitalizations: " + e.getMessage());
        }

        return list;
    }
}

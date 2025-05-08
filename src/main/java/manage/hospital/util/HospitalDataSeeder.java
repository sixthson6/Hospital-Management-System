package manage.hospital.util;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import manage.hospital.dao.DBConnection;

public class HospitalDataSeeder {

    public static void seedData() {
        try (Connection conn = DBConnection.getConnection()) {

            // Insert Employees
            try (PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO Employee (id, surname, first_name, address, phone) VALUES (?, ?, ?, ?, ?)")) {
                stmt.setInt(1, 1); stmt.setString(2, "House"); stmt.setString(3, "Gregory");
                stmt.setString(4, "221B Baker Street"); stmt.setString(5, "555-1001"); stmt.addBatch();

                stmt.setInt(1, 2); stmt.setString(2, "Watson"); stmt.setString(3, "John");
                stmt.setString(4, "221B Baker Street"); stmt.setString(5, "555-1002"); stmt.addBatch();

                stmt.setInt(1, 3); stmt.setString(2, "Chase"); stmt.setString(3, "Robert");
                stmt.setString(4, "13 Hospital Ave"); stmt.setString(5, "555-1003"); stmt.addBatch();

                stmt.setInt(1, 4); stmt.setString(2, "Adams"); stmt.setString(3, "Lisa");
                stmt.setString(4, "42 Medicine Rd"); stmt.setString(5, "555-1004"); stmt.addBatch();

                stmt.setInt(1, 5); stmt.setString(2, "Wilson"); stmt.setString(3, "James");
                stmt.setString(4, "5 Oncology Dr"); stmt.setString(5, "555-1005"); stmt.addBatch();

                stmt.executeBatch();
            }

            // Insert Doctors
            try (PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO Doctor (employee_id, speciality) VALUES (?, ?)")) {
                stmt.setInt(1, 1); stmt.setString(2, "Diagnostic Medicine"); stmt.addBatch();
                stmt.setInt(1, 2); stmt.setString(2, "Cardiology"); stmt.addBatch();
                stmt.setInt(1, 3); stmt.setString(2, "Surgery"); stmt.addBatch();
                stmt.executeBatch();
            }

            // Insert Nurses
            try (PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO Nurse (employee_id, department_code, rotation, salary) VALUES (?, ?, ?, ?)")) {
                stmt.setInt(1, 4); stmt.setInt(2, 1); stmt.setString(3, "Night"); stmt.setDouble(4, 45000); stmt.addBatch();
                stmt.setInt(1, 5); stmt.setInt(2, 2); stmt.setString(3, "Day"); stmt.setDouble(4, 47000); stmt.addBatch();
                stmt.executeBatch();
            }

            // Insert Departments
            try (PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO Department (code, name, building, director_id) VALUES (?, ?, ?, ?)")) {
                stmt.setInt(1, 1); stmt.setString(2, "Diagnostics"); stmt.setString(3, "A"); stmt.setInt(4, 1); stmt.addBatch();
                stmt.setInt(1, 2); stmt.setString(2, "Oncology"); stmt.setString(3, "B"); stmt.setInt(4, 2); stmt.addBatch();
                stmt.executeBatch();
            }

            // Insert Wards
            try (PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO Ward (number, department_code, number_of_beds, supervisor_id) VALUES (?, ?, ?, ?)")) {
                stmt.setInt(1, 1); stmt.setInt(2, 1); stmt.setInt(3, 10); stmt.setInt(4, 4); stmt.addBatch();
                stmt.setInt(1, 2); stmt.setInt(2, 1); stmt.setInt(3, 0); stmt.setInt(4, 4); stmt.addBatch();
                stmt.setInt(1, 1); stmt.setInt(2, 2); stmt.setInt(3, 8); stmt.setInt(4, 5); stmt.addBatch();
                stmt.executeBatch();
            }

            // Insert Patients
            try (PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO Patient (patient_id, surname, first_name, address, phone) VALUES (?, ?, ?, ?, ?)")) {
                stmt.setInt(1, 101); stmt.setString(2, "Foreman"); stmt.setString(3, "Eric");
                stmt.setString(4, "12 Clinic Way"); stmt.setString(5, "555-2001"); stmt.addBatch();

                stmt.setInt(1, 102); stmt.setString(2, "Cameron"); stmt.setString(3, "Allison");
                stmt.setString(4, "98 Med St"); stmt.setString(5, "555-2002"); stmt.addBatch();

                stmt.setInt(1, 103); stmt.setString(2, "Park"); stmt.setString(3, "Chi");
                stmt.setString(4, "77 Hospital Lane"); stmt.setString(5, "555-2003"); stmt.addBatch();

                stmt.executeBatch();
            }

            // Insert Hospitalization
            try (PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO Hospitalization (patient_id, ward_number, department_code, bed_number, diagnosis, doctor_id) VALUES (?, ?, ?, ?, ?, ?)")) {
                stmt.setInt(1, 101); stmt.setInt(2, 1); stmt.setInt(3, 1);
                stmt.setInt(4, 5); stmt.setString(5, "Lupus"); stmt.setInt(6, 1); stmt.addBatch();

                stmt.setInt(1, 102); stmt.setInt(2, 1); stmt.setInt(3, 2);
                stmt.setInt(4, 2); stmt.setString(5, "Tumor"); stmt.setInt(6, 2); stmt.addBatch();

                stmt.setInt(1, 103); stmt.setInt(2, 2); stmt.setInt(3, 1);
                stmt.setInt(4, 1); stmt.setString(5, "Infection"); stmt.setInt(6, 3); stmt.addBatch();

                stmt.executeBatch();
            }

            System.out.println("✅ Sample data seeded successfully!");

        } catch (SQLException e) {
            System.err.println("❌ Error seeding database: " + e.getMessage());
        }
    }
}

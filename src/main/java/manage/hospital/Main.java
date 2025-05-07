package manage.hospital;

import java.sql.Connection;

import manage.hospital.dao.DBConnection;
import manage.hospital.dao.PatientDAO;
import manage.hospital.model.Patient;
import manage.hospital.util.SQLExecutor;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection()) {
            // Run schema SQL script from resources/sql/hospital_schema.sql
            SQLExecutor.runSQLScript(conn, "/sql/hospital_schema.sql");

            PatientDAO dao = new PatientDAO();

            // INSERT
            Patient p1 = new Patient(1, "Smith", "John", "123 Main St", "555-1234");
            Patient p2 = new Patient(2, "Tabari", "Linus", "42 First St", "551-4334");
            Patient p3 = new Patient(3, "Sam", "John", "123 MainMan St", "555-12343");
            Patient p4 = new Patient(4, "Tabari", "Adjei", "4243 First St", "551-334");
            // dao.insertPatient(p2);
            dao.insertPatient(p1);
            // dao.insertPatient(p3);
            // dao.insertPatient(p4);

            // SELECT
            // List<Patient> patients = dao.getAllPatients();
            // patients.forEach(System.out::println);

            // UPDATE
            p1.setPhone("555-64444");
            // dao.updatePatient(p1);

            // DELETE
            // dao.deletePatient(1);
        } catch (Exception e) {
            System.err.println("❌ Failed to initialize or execute: " + e.getMessage());
        }
    }
}

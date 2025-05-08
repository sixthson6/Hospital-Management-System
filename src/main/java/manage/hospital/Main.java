package manage.hospital;

import java.sql.Connection;

import manage.hospital.dao.DBConnection;
import manage.hospital.util.HospitalDataSeeder;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection()) {
            // Run schema SQL script from resources/sql/hospital_schema.sql
            // SQLExecutor.runSQLScript(conn, "/sql/hospital_schema.sql");

            // SQLExecutor.runSQLScript(conn, "/sql/populate_schema.sql");
            HospitalDataSeeder.seedData();

        } catch (Exception e) {
            System.err.println("❌ Failed to initialize or execute: " + e.getMessage());
        }
    }
}

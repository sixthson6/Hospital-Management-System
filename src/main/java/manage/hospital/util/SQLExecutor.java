package manage.hospital.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Statement;

public class SQLExecutor {

    public static void runSQLScript(Connection conn, String resourcePath) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(SQLExecutor.class.getResourceAsStream(resourcePath)));
             Statement stmt = conn.createStatement()) {
    
            StringBuilder sqlBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sqlBuilder.append(line);
                if (line.trim().endsWith(";")) {
                    stmt.execute(sqlBuilder.toString());
                    sqlBuilder.setLength(0); // Clear for next statement
                }
            }
    
            System.out.println("✅ SQL schema executed.");
        } catch (Exception e) {
            System.err.println("❌ Error executing SQL schema: " + e.getMessage());
        }
    }
}
